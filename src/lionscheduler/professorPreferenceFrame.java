/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lionscheduler;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mch5367
 */
public class professorPreferenceFrame extends javax.swing.JFrame {
    
    String[] subItem1 = {"Bartolacci", "Clark", "Konak", "Maurer", "Nasereddin", "Weisser"};
    String[] subItem2 = {"test1","test2"};

    /**
     * Creates new form professorPreferenceFrame
     */
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
        jFTFTimeMorning = new javax.swing.JFormattedTextField();
        jLDash = new javax.swing.JLabel();
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
        jFTFTimeAfternoon = new javax.swing.JFormattedTextField();
        jLDepartment = new javax.swing.JLabel();
        jCBDepartment = new javax.swing.JComboBox<>();
        jLBreak = new javax.swing.JLabel();
        jFTFBreakTime = new javax.swing.JFormattedTextField();
        jCBTimeSelect = new javax.swing.JComboBox<>();
        jCBTimeSelect1 = new javax.swing.JComboBox<>();
        jCBTimeSelect2 = new javax.swing.JComboBox<>();
        jCBTimeSelect3 = new javax.swing.JComboBox<>();
        jFTFBreakTime2 = new javax.swing.JFormattedTextField();
        jLDash1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFTFTimeMorning.setText("HH:MM");
        jFTFTimeMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFTimeMorningActionPerformed(evt);
            }
        });

        jLDash.setText("-");

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

        jCheckMonday.setAutoscrolls(true);

        jlTime.setText("Time:");

        jFTFTimeAfternoon.setText("HH:MM");

        jLDepartment.setText("Department:");

        jCBDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IST & SRA", "Accounting" }));
        jCBDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDepartmentActionPerformed(evt);
            }
        });

        jLBreak.setText("Break:");

        jFTFBreakTime.setText("HH:MM");
        jFTFBreakTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFBreakTimeActionPerformed(evt);
            }
        });

        jCBTimeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jCBTimeSelect1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jCBTimeSelect2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jCBTimeSelect3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jFTFBreakTime2.setText("HH:MM");
        jFTFBreakTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFBreakTime2ActionPerformed(evt);
            }
        });

        jLDash1.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlProfessorPreferences)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jlProfessor)
                                .addGap(18, 18, 18)
                                .addComponent(jCBProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlDays)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckMonday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlMonday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTuesday)
                                    .addComponent(jCheckTuesday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlWednesDay)
                                    .addComponent(jCheckWednesday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlThursday)
                                    .addComponent(jCheckThursday))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlFriday)
                                    .addComponent(jCheckFriday))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckSaturday)
                                            .addComponent(jlSaturday))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jCheckSunday))
                                            .addComponent(jlSunday, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jbSubmit))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFTFTimeMorning, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBTimeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFTFBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBTimeSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLDash1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFTFTimeAfternoon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBTimeSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFTFBreakTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBTimeSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLBreak)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLDepartment)
                                .addGap(18, 18, 18)
                                .addComponent(jCBDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlProfessorPreferences)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDepartment)
                    .addComponent(jCBDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jFTFTimeMorning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDash)
                            .addComponent(jFTFTimeAfternoon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBTimeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBTimeSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLBreak)
                            .addComponent(jFTFBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBTimeSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTFBreakTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDash1)
                            .addComponent(jCBTimeSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jbSubmit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckThursday)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void jCBDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDepartmentActionPerformed
        String item = (String)jCBDepartment.getSelectedItem();

        if(item == "IST & SRA")
        {
            jCBProfessor.setModel(new DefaultComboBoxModel(subItem1));
        }
        else
        {
            jCBProfessor.setModel(new DefaultComboBoxModel(subItem2));
        }
    }//GEN-LAST:event_jCBDepartmentActionPerformed

    private void jCBProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBProfessorActionPerformed

    private void jFTFTimeMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFTimeMorningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFTimeMorningActionPerformed

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSubmitActionPerformed

    private void jFTFBreakTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFBreakTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFBreakTimeActionPerformed

    private void jFTFBreakTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFBreakTime2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFBreakTime2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBDepartment;
    private javax.swing.JComboBox<String> jCBProfessor;
    private javax.swing.JComboBox<String> jCBTimeSelect;
    private javax.swing.JComboBox<String> jCBTimeSelect1;
    private javax.swing.JComboBox<String> jCBTimeSelect2;
    private javax.swing.JComboBox<String> jCBTimeSelect3;
    private javax.swing.JCheckBox jCheckFriday;
    private javax.swing.JCheckBox jCheckMonday;
    private javax.swing.JCheckBox jCheckSaturday;
    private javax.swing.JCheckBox jCheckSunday;
    private javax.swing.JCheckBox jCheckThursday;
    private javax.swing.JCheckBox jCheckTuesday;
    private javax.swing.JCheckBox jCheckWednesday;
    private javax.swing.JFormattedTextField jFTFBreakTime;
    private javax.swing.JFormattedTextField jFTFBreakTime2;
    private javax.swing.JFormattedTextField jFTFTimeAfternoon;
    private javax.swing.JFormattedTextField jFTFTimeMorning;
    private javax.swing.JLabel jLBreak;
    private javax.swing.JLabel jLDash;
    private javax.swing.JLabel jLDash1;
    private javax.swing.JLabel jLDepartment;
    private javax.swing.JPanel jPanel1;
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
