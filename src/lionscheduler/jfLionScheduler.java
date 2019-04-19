/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lionscheduler;

import com.davidmoodie.SwingCalendar.Calendar;
import com.davidmoodie.SwingCalendar.CalendarEvent;
import com.davidmoodie.SwingCalendar.WeekCalendar;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.WindowConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sciss
 */
public class jfLionScheduler extends javax.swing.JFrame {
// *** NOTE: In order for JTable to work, rs2xml.jar file must be in Libraries - EJB ***
    
    static Connection con;
    Date dStartTime;
    Date dEndTime;
    
    /**
     * Creates new form jfLionScheduler
     */
    public jfLionScheduler() throws SQLException {
        initComponents();
        
        // MySQL database connection
        try {  
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        con=DriverManager.getConnection(  
        "jdbc:mysql://istdata.bk.psu.edu:3306/bmb5858","bmb5858","berks!bmb5858");
        System.out.println("connection established.");
        
        // Populates jComboBoxes
         fillSubjectCombo();
         fillCourseCombo();
         fillProfessorCombo();
         
         
         displayAllData();
        
        // loadListView method
//        try {
//            loadListView();
//        } catch (SQLException ex) {
//            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
//        }  
        
    } // Constructor
    
    private JEditorPane createEditorPane(String inRefreshURL) {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        java.net.URL refreshURL = null;
        
        try {
            refreshURL = new URL(inRefreshURL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (refreshURL != null) {
            try {
                editorPane.setPage(refreshURL);
            } catch (IOException e) {
                System.err.println("Attempted to read a bad URL: " + refreshURL);
            }
        } else {
            System.err.println("Couldn't find the URL: " + refreshURL);
        }

        return editorPane;
        
    } // createEditorPane
     
    
    private void fillSubjectCombo() throws SQLException
    {
        String strSubjectQuery = "SELECT Subject FROM Course "
                + "GROUP BY Subject";
        PreparedStatement psSubjectQuery = con.prepareStatement(strSubjectQuery);
        ResultSet rs = psSubjectQuery.executeQuery();
  
        while (rs.next())
        {
            jcbSubject.addItem(rs.getString(1));
            
        } // while
        
        
    } // fillSubjectCombo
    
   
    private void fillCourseCombo() throws SQLException
    {
        String strCourseQuery = "SELECT Num, Description FROM Course "
                + "WHERE Subject = ?"
                + "GROUP BY Num";
        PreparedStatement psCourseQuery = con.prepareStatement(strCourseQuery);
        psCourseQuery.setString(1,(String) jcbSubject.getSelectedItem()); // ? in query = Subject from jcbSubjectComboBox
        ResultSet rs = psCourseQuery.executeQuery();
        
        jcbCourse.addItem(" ");
        
        while (rs.next())
        {
            // Gets Num & Description
            jcbCourse.addItem(rs.getInt(1) + " " + rs.getString(2));
  
            
        } // while
      
    } // fillCourseCombo
    
    private void fillProfessorCombo() throws SQLException
    {
        String strProfessorQuery = "SELECT Name FROM Faculty "
                + "GROUP BY Name";
        PreparedStatement psProfessorQuery = con.prepareStatement(strProfessorQuery);
        ResultSet rs = psProfessorQuery.executeQuery();
      
        while (rs.next())
        {
            jcbProfessor.addItem(rs.getString(1));
            
        } // while
      
    } // fillProfessorCombo
    
    private void loadListView() throws SQLException {
//        try {  
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con=DriverManager.getConnection(  
//        "jdbc:mysql://istdata.bk.psu.edu:3306/bmb5858","bmb5858","berks!bmb5858");
//        System.out.println("connection established.");
        
        getCoursesGivenProf(con, "Xue");
        
        //call listview
        //String getCourses = "SELECT "
        
     //   con.close();
        
    } // loadListView  
    
    
    private void displayAllData() throws SQLException
    {
        String strDisplayData = "SELECT Subject, Num, Description, Section, Mon, Tue, Wed, Thu, Fri, Sat, Sun, Name "
                                  + "FROM Schedule "
                                  + "RIGHT JOIN Course ON Course.idCourse = Schedule.Course_idCourse "
                                  + "RIGHT JOIN Faculty ON Faculty.idFaculty = Schedule.Faculty_idFaculty";
                                
        try
        {
            PreparedStatement psDisplayData = con.prepareStatement(strDisplayData);
            ResultSet rs = psDisplayData.executeQuery();
            
            filterTable.setModel(DbUtils.resultSetToTableModel(rs));
        } // try
        catch (SQLException ex)
        {
            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
                    
        } // catch

    } // displayAllData
    
    
     private void getCoursesGivenProf(Connection con, String profName) {
         
        StringBuilder returnString = new StringBuilder(); 
        String inName = "%" + profName + "%";
        String sProf =  "SELECT Course_idCourse, Room_idRoom, BeginTime, EndTime, Mon, Tue, Wed, Thu, Fri, Sat, Sun, TotalEnrl FROM schedule \n" +
                                    "WHERE Faculty_idFaculty = (\n" +
                                    "SELECT idFaculty FROM faculty\n" +
                                    "WHERE Name LIKE '" + inName + "'\n);";
        
        try 
        {
            PreparedStatement psExe = con.prepareStatement(sProf);
            ResultSet rs = psExe.executeQuery();
            
            // Populates JTable - EJB
            filterTable.setModel(DbUtils.resultSetToTableModel(rs));
            
//            while (rs.next()) 
//            {
//                
//                returnString.append(rs.getInt("Course_idCourse") + "\t" 
//                        + rs.getInt("Room_idRoom") + "\t"
//                        + rs.getTime("BeginTime") + "\t"
//                        + rs.getTime("EndTime") + "\t"
//                        + rs.getInt("Mon") + "\t"
//                        + rs.getInt("Tue") + "\t"
//                        + rs.getInt("Wed") + "\t"
//                        + rs.getInt("Thu") + "\t"
//                        + rs.getInt("Fri") + "\t"
//                        + rs.getInt("Sat") + "\t"
//                        + rs.getInt("Sun") + "\t"
//                        + rs.getInt("TotalEnrl"));
//            } // while
            
        } // try 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
        } // catch
             
//         System.out.println(returnString.toString());
//         jtListView.setText(returnString.toString());

    } // getCoursesGivenProf
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbTools = new javax.swing.JToolBar();
        jbCreateCourse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbPreferences = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbEditCourse = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbGenerateReport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpCalendarPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        filterTable = new javax.swing.JTable();
        jpFilterPanel = new javax.swing.JPanel();
        jlFilterByLabel = new javax.swing.JLabel();
        jlSubjectLabel = new javax.swing.JLabel();
        jlCourseLabel = new javax.swing.JLabel();
        jlProfessorLabel = new javax.swing.JLabel();
        jlDaysLabel = new javax.swing.JLabel();
        jlStartTimeLabel = new javax.swing.JLabel();
        jlEndTimeLabel = new javax.swing.JLabel();
        jcbMonday = new javax.swing.JCheckBox();
        jcbTuesday = new javax.swing.JCheckBox();
        jcbThursday = new javax.swing.JCheckBox();
        jcbFriday = new javax.swing.JCheckBox();
        jcbWednesday = new javax.swing.JCheckBox();
        jcbSaturday = new javax.swing.JCheckBox();
        jcbSunday = new javax.swing.JCheckBox();
        jcbSubject = new javax.swing.JComboBox<>();
        jcbCourse = new javax.swing.JComboBox<>();
        jcbProfessor = new javax.swing.JComboBox<>();
        SimpleDateFormat sdfStartFormat = new SimpleDateFormat("hh:mm");
        try
        {
            dStartTime = sdfStartFormat.parse("00:00");
        } // try

        catch (ParseException ex)
        {

        } // catch
        jsStartTime = new javax.swing.JSpinner();
        SimpleDateFormat sdfEndFormat = new SimpleDateFormat("hh:mm");
        try
        {
            dEndTime = sdfEndFormat.parse("00:00");
        } // try

        catch (ParseException ex)
        {

        } // catch
        jsEndTime = new javax.swing.JSpinner();
        jbFilterButton = new javax.swing.JButton();
        jmMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lion Scheduler");

        jtbTools.setRollover(true);

        jbCreateCourse.setText("Create New Course");
        jbCreateCourse.setFocusable(false);
        jbCreateCourse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCreateCourse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCreateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateCourseActionPerformed(evt);
            }
        });
        jtbTools.add(jbCreateCourse);
        jtbTools.add(jSeparator1);

        jbPreferences.setText("Preferences");
        jbPreferences.setFocusable(false);
        jbPreferences.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbPreferences.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreferencesActionPerformed(evt);
            }
        });
        jtbTools.add(jbPreferences);
        jtbTools.add(jSeparator2);

        jbEditCourse.setText("Edit Course");
        jbEditCourse.setFocusable(false);
        jbEditCourse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditCourse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEditCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditCourseActionPerformed(evt);
            }
        });
        jtbTools.add(jbEditCourse);
        jtbTools.add(jSeparator3);

        jbGenerateReport.setText("Generate Report");
        jbGenerateReport.setFocusable(false);
        jbGenerateReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGenerateReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbTools.add(jbGenerateReport);

        filterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(filterTable);

        javax.swing.GroupLayout jpCalendarPanelLayout = new javax.swing.GroupLayout(jpCalendarPanel);
        jpCalendarPanel.setLayout(jpCalendarPanelLayout);
        jpCalendarPanelLayout.setHorizontalGroup(
            jpCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
        );
        jpCalendarPanelLayout.setVerticalGroup(
            jpCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jpCalendarPanel);

        jlFilterByLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlFilterByLabel.setText("Filter By");

        jlSubjectLabel.setText("Subject:");

        jlCourseLabel.setText("Course:");

        jlProfessorLabel.setText("Professor:");

        jlDaysLabel.setText("Days:");

        jlStartTimeLabel.setText("Start Time:");

        jlEndTimeLabel.setText("End Time:");

        jcbMonday.setText("Monday");

        jcbTuesday.setText("Tuesday");

        jcbThursday.setText("Thursday");

        jcbFriday.setText("Friday");

        jcbWednesday.setText("Wednesday");

        jcbSaturday.setText("Saturday");

        jcbSunday.setText("Sunday");

        jcbSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jcbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSubjectActionPerformed(evt);
            }
        });

        jcbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jsStartTime.setModel(new SpinnerDateModel());
        jsStartTime.setEditor(new JSpinner.DateEditor(jsStartTime, "hh:mm"));
        jsStartTime.setValue(dStartTime);

        jsEndTime.setModel(new SpinnerDateModel());
        jsEndTime.setEditor(new JSpinner.DateEditor(jsEndTime, "hh:mm"));
        jsEndTime.setValue(dEndTime);

        jbFilterButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbFilterButton.setText("Filter Data");
        jbFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFilterPanelLayout = new javax.swing.GroupLayout(jpFilterPanel);
        jpFilterPanel.setLayout(jpFilterPanelLayout);
        jpFilterPanelLayout.setHorizontalGroup(
            jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilterPanelLayout.createSequentialGroup()
                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFilterPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFilterPanelLayout.createSequentialGroup()
                                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbSunday)
                                    .addComponent(jcbSaturday)
                                    .addComponent(jcbWednesday)
                                    .addComponent(jcbFriday)
                                    .addComponent(jcbThursday)
                                    .addComponent(jcbTuesday)
                                    .addComponent(jlSubjectLabel)
                                    .addComponent(jlCourseLabel)
                                    .addComponent(jlProfessorLabel)
                                    .addComponent(jlDaysLabel)
                                    .addComponent(jcbMonday))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jcbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpFilterPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jlFilterByLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpFilterPanelLayout.createSequentialGroup()
                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlStartTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEndTimeLabel)
                    .addComponent(jsEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jpFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFilterPanelLayout.setVerticalGroup(
            jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilterPanelLayout.createSequentialGroup()
                .addComponent(jlFilterByLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSubjectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jlCourseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlProfessorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlDaysLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbMonday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbWednesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbThursday, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbFriday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSaturday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSunday)
                .addGap(18, 18, 18)
                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStartTimeLabel)
                    .addComponent(jlEndTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jsEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jsStartTime))
                .addGap(26, 26, 26)
                .addComponent(jbFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jmMenu.add(jMenu1);

        jMenu2.setText("Edit");
        jmMenu.add(jMenu2);

        setJMenuBar(jmMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(9, 9, 9))
            .addComponent(jtbTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtbTools, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jpFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreferencesActionPerformed
        professorPreferenceFrame prefs = new professorPreferenceFrame();
        prefs.setVisible(true);
    }//GEN-LAST:event_jbPreferencesActionPerformed

    private void jbCreateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateCourseActionPerformed
        addCourseScreen addCourse = new addCourseScreen();
        addCourse.setVisible(true);
    }//GEN-LAST:event_jbCreateCourseActionPerformed

    private void jbFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFilterButtonActionPerformed
        // TODO: Display data based upon filter selections
        
    }//GEN-LAST:event_jbFilterButtonActionPerformed

    private void jcbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSubjectActionPerformed
        jcbCourse.removeAllItems();
        try 
        {
            fillCourseCombo();
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
        } // catch
       
    }//GEN-LAST:event_jcbSubjectActionPerformed

    private void jbEditCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditCourseActionPerformed
        editCourseScreen editCourse = new editCourseScreen();
        editCourse.setVisible(true);
    }//GEN-LAST:event_jbEditCourseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfLionScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfLionScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfLionScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfLionScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		//</editor-fold>
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfLionScheduler().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jfLionScheduler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable filterTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JButton jbCreateCourse;
    private javax.swing.JButton jbEditCourse;
    private javax.swing.JButton jbFilterButton;
    private javax.swing.JButton jbGenerateReport;
    private javax.swing.JButton jbPreferences;
    public javax.swing.JComboBox<String> jcbCourse;
    private javax.swing.JCheckBox jcbFriday;
    private javax.swing.JCheckBox jcbMonday;
    private javax.swing.JComboBox<String> jcbProfessor;
    private javax.swing.JCheckBox jcbSaturday;
    private javax.swing.JComboBox<String> jcbSubject;
    private javax.swing.JCheckBox jcbSunday;
    private javax.swing.JCheckBox jcbThursday;
    private javax.swing.JCheckBox jcbTuesday;
    private javax.swing.JCheckBox jcbWednesday;
    private javax.swing.JLabel jlCourseLabel;
    private javax.swing.JLabel jlDaysLabel;
    private javax.swing.JLabel jlEndTimeLabel;
    private javax.swing.JLabel jlFilterByLabel;
    private javax.swing.JLabel jlProfessorLabel;
    private javax.swing.JLabel jlStartTimeLabel;
    private javax.swing.JLabel jlSubjectLabel;
    private javax.swing.JMenuBar jmMenu;
    private javax.swing.JPanel jpCalendarPanel;
    private javax.swing.JPanel jpFilterPanel;
    private javax.swing.JSpinner jsEndTime;
    private javax.swing.JSpinner jsStartTime;
    private javax.swing.JToolBar jtbTools;
    // End of variables declaration//GEN-END:variables
}
