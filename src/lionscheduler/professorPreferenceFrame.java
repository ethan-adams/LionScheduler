/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lionscheduler;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerModel;

/**
 *
 * @author mch5367
 */
public class professorPreferenceFrame extends javax.swing.JFrame {
    /**
     * Creates new form professorPreferenceFrame
     */
    Date def;
    Date def1;
    Date def2;
    Date def3;
            
    public professorPreferenceFrame() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSubmit = new javax.swing.JButton();
        jCheckFriday = new javax.swing.JCheckBox();
        jCheckSaturday = new javax.swing.JCheckBox();
        jCheckSunday = new javax.swing.JCheckBox();
        jlMonday = new javax.swing.JLabel();
        jlTuesday = new javax.swing.JLabel();
        jlWednesDay = new javax.swing.JLabel();
        jlThursday = new javax.swing.JLabel();
        jlFriday = new javax.swing.JLabel();
        jlSaturday = new javax.swing.JLabel();
        jlSunday = new javax.swing.JLabel();
        jlProfessorPreferences = new javax.swing.JLabel();
        jlProfessor = new javax.swing.JLabel();
        jCBProfessor = new javax.swing.JComboBox<>();
        jlDays = new javax.swing.JLabel();
        jCheckMonday = new javax.swing.JCheckBox();
        jCheckTuesday = new javax.swing.JCheckBox();
        jCheckWednesday = new javax.swing.JCheckBox();
        jCheckThursday = new javax.swing.JCheckBox();
        jlTime = new javax.swing.JLabel();
        jLBreak = new javax.swing.JLabel();
        SimpleDateFormat fd = new SimpleDateFormat("hh:mm");
        try
        {
            def = fd.parse("00:00");
        }
        catch(ParseException ex)
        {
        }
        jSTime1 = new javax.swing.JSpinner();
        SimpleDateFormat fd1 = new SimpleDateFormat("HH:mm");
        try
        {
            def1 = fd1.parse("00:00");
        }
        catch(ParseException ex)
        {
        }
        jSTime2 = new javax.swing.JSpinner();
        SimpleDateFormat fd2 = new SimpleDateFormat("HH:mm");
        try
        {
            def2 = fd2.parse("00:00");
        }
        catch(ParseException ex)
        {
        }
        jSTime3 = new javax.swing.JSpinner();
        SimpleDateFormat fd3 = new SimpleDateFormat("HH:mm");
        try
        {
            def3 = fd3.parse("00:00");
        }
        catch(ParseException ex)
        {
        }
        jSTime4 = new javax.swing.JSpinner();
        jLDash = new javax.swing.JLabel();
        jLDash1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSubmit.setText("Submit");
        jbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitActionPerformed(evt);
            }
        });

        jlMonday.setText(" M");

        jlTuesday.setText("  T");

        jlWednesDay.setText(" W");

        jlThursday.setText(" Th");

        jlFriday.setText("  F");

        jlSaturday.setText("  S");

        jlSunday.setText("Sun");

        jlProfessorPreferences.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlProfessorPreferences.setText("Professor Preference");

        jlProfessor.setText("Professor:");

        jCBProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProfessorActionPerformed(evt);
            }
        });

        jlDays.setText("Days:");

        jCheckMonday.setToolTipText("");
        jCheckMonday.setAutoscrolls(true);
        jCheckMonday.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlTime.setText("Time:");

        jLBreak.setText("Break:");

        jSTime1.setModel(new SpinnerDateModel());
        jSTime1.setEditor(new JSpinner.DateEditor(jSTime1, "hh:mm"));
        jSTime1.setValue(def);

        jSTime2.setModel(new SpinnerDateModel());
        jSTime2.setEditor(new JSpinner.DateEditor(jSTime2, "HH:mm"));
        jSTime2.setValue(def);

        jSTime3.setModel(new SpinnerDateModel());
        jSTime3.setEditor(new JSpinner.DateEditor(jSTime3, "HH:mm"));
        jSTime3.setValue(def);

        jSTime4.setModel(new SpinnerDateModel());
        jSTime4.setEditor(new JSpinner.DateEditor(jSTime4, "HH:mm"));
        jSTime4.setValue(def);

        jLDash.setText("-");

        jLDash1.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbSubmit)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlDays)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckMonday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlMonday, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTuesday)
                                    .addComponent(jCheckTuesday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlWednesDay)
                                    .addComponent(jCheckWednesday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlThursday)
                                    .addComponent(jCheckThursday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckFriday)
                                    .addComponent(jlFriday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckSaturday)
                                    .addComponent(jlSaturday))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSunday)
                            .addComponent(jCheckSunday))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLBreak)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSTime3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLDash)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLDash1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSTime4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlProfessorPreferences)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlProfessorPreferences)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlProfessor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDays)
                    .addComponent(jlMonday, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTuesday)
                    .addComponent(jlWednesDay)
                    .addComponent(jlThursday)
                    .addComponent(jlFriday)
                    .addComponent(jlSaturday)
                    .addComponent(jlSunday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckMonday)
                            .addComponent(jCheckTuesday)
                            .addComponent(jCheckWednesday)
                            .addComponent(jCheckFriday)
                            .addComponent(jCheckSaturday)
                            .addComponent(jCheckSunday))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTime)
                            .addComponent(jSTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDash))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSTime3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLBreak)
                            .addComponent(jLDash1)
                            .addComponent(jSTime4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCheckThursday))
                .addGap(28, 28, 28)
                .addComponent(jbSubmit)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBProfessorActionPerformed

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed

        int sqlM = 0;
        int sqlT = 0;
        int sqlW = 0;
        int sqlTh = 0;
        int sqlF = 0;
        int sqlS = 0;
        int sqlSun = 0;
        if(jCheckMonday.isSelected() == true)
        {
            sqlM = 1;
            if(jCheckMonday.isSelected() == false)
            {
                sqlM = 0;
            }
        }
        if(jCheckTuesday.isSelected() == true)
        {
            sqlT = 1;
            if(jCheckTuesday.isSelected() == false)
            {
                sqlT = 0;
            }
        }
        if(jCheckWednesday.isSelected() == true)
        {
            sqlW = 1;
            if(jCheckWednesday.isSelected() == false)
            {
                sqlW = 0;
            }
        }
        if(jCheckThursday.isSelected() == true)
        {
            sqlTh = 1;
            if(jCheckThursday.isSelected() == false)
            {
                sqlTh = 0;
            }
        }
        if(jCheckFriday.isSelected() == true)
        {
            sqlF = 1;
            if(jCheckFriday.isSelected() == false)
            {
                sqlF = 0;
            }
        }
        if(jCheckSaturday.isSelected() == true)
        {
            sqlS = 1;
            if(jCheckSaturday.isSelected() == false)
            {
                sqlS = 0;
            }
        }
        if(jCheckSunday.isSelected() == true)
        {
            sqlSun = 1;
            if(jCheckSunday.isSelected() == false)
            {
                sqlSun = 0;
            }
        }
        
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://istdata.bk.psu.edu:3306/bmb5858","bmb5858","berks!bmb5858");
            
//            String sqlStatement = "UPDATE Preferences SET Day = (?,?,?,?,?,?,?)"; 
//            PreparedStatement pst = con.prepareStatement(sqlStatement);
//            pst.setInt(1, sqlM);
//            pst.setInt(2, sqlT);
//            pst.setInt(3, sqlW);
//            pst.setInt(4, sqlTh);
//            pst.setInt(5, sqlF);
//            pst.setInt(6, sqlS);
//            pst.setInt(7, sqlSun);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(professorPreferenceFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(professorPreferenceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }    
            //System.out.println(sqlM + " " + sqlT + " " + sqlW + " " + sqlTh + " " + sqlF + " " + sqlS + " " + sqlSun);

        
    }//GEN-LAST:event_jbSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(professorPreferenceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(professorPreferenceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(professorPreferenceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(professorPreferenceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new professorPreferenceFrame().setVisible(true);
            }
        });
        

        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://istdata.bk.psu.edu:3306/bmb5858","bmb5858","berks!bmb5858");
        
        String getProfessor = "SELECT Name FROM Faculty";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(getProfessor);
       
        while(rs.next())
        {
            jCBProfessor.addItem(rs.getString(1));
        }
        
        String checkSt = "SELECT Day From Preferences";
        Statement st1 = con.createStatement();
        ResultSet rs1 = st1.executeQuery(checkSt);
            
            while(rs1.next())
            {
                System.out.println(rs1.getString(1));         
            }
        
        

        
        //jCBProfessor.setModel(new DefaultComboBoxModel(professorName));

        
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> jCBProfessor;
    private javax.swing.JCheckBox jCheckFriday;
    private javax.swing.JCheckBox jCheckMonday;
    private javax.swing.JCheckBox jCheckSaturday;
    private javax.swing.JCheckBox jCheckSunday;
    private javax.swing.JCheckBox jCheckThursday;
    private javax.swing.JCheckBox jCheckTuesday;
    private javax.swing.JCheckBox jCheckWednesday;
    private javax.swing.JLabel jLBreak;
    private javax.swing.JLabel jLDash;
    private javax.swing.JLabel jLDash1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSTime1;
    private javax.swing.JSpinner jSTime2;
    private javax.swing.JSpinner jSTime3;
    private javax.swing.JSpinner jSTime4;
    private javax.swing.JButton jbSubmit;
    private javax.swing.JLabel jlDays;
    private javax.swing.JLabel jlFriday;
    private javax.swing.JLabel jlMonday;
    private javax.swing.JLabel jlProfessor;
    private javax.swing.JLabel jlProfessorPreferences;
    private javax.swing.JLabel jlSaturday;
    private javax.swing.JLabel jlSunday;
    private javax.swing.JLabel jlThursday;
    private javax.swing.JLabel jlTime;
    private javax.swing.JLabel jlTuesday;
    private javax.swing.JLabel jlWednesDay;
    // End of variables declaration//GEN-END:variables
}
