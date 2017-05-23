package secure;
import java.awt.*;
import javax.swing.*;

public class Homerecep extends javax.swing.JFrame {

    public Homerecep() {
        super("Hospital Management System - Home (Receptionist logged in)");
        setLayout(new FlowLayout());
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 750);
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbutton_patientDetails = new javax.swing.JButton();
        jbutton_newAdmission = new javax.swing.JButton();
        jbutton_wardDetails = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jbutton_externalPhysician = new javax.swing.JButton();
        jbutton_tests = new javax.swing.JButton();
        jbutton_treatments = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbutton_patientDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_patientDetails.setText("PATIENT DETAILS");
        jbutton_patientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_patientDetailsActionPerformed(evt);
            }
        });

        jbutton_newAdmission.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_newAdmission.setText("NEW ADMISSION");
        jbutton_newAdmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_newAdmissionActionPerformed(evt);
            }
        });

        jbutton_wardDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_wardDetails.setText("WARD DETAILS");
        jbutton_wardDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_wardDetailsActionPerformed(evt);
            }
        });

        logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jbutton_externalPhysician.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_externalPhysician.setText("EXTERNAL PHYSICIANS");
        jbutton_externalPhysician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_externalPhysicianActionPerformed(evt);
            }
        });

        jbutton_tests.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_tests.setText("TESTS");
        jbutton_tests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_testsActionPerformed(evt);
            }
        });

        jbutton_treatments.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_treatments.setText("TREATMENTS");
        jbutton_treatments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_treatmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbutton_newAdmission, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jbutton_patientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jbutton_wardDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jbutton_externalPhysician, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jbutton_tests, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jbutton_treatments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jbutton_newAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbutton_patientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jbutton_wardDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jbutton_externalPhysician, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jbutton_tests, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jbutton_treatments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(logout)
                .addGap(88, 88, 88))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 230, 760);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/secure/d.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1500, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_patientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_patientDetailsActionPerformed
        
        PatientDetails patientDetails = new PatientDetails();
        
    }//GEN-LAST:event_jbutton_patientDetailsActionPerformed

    private void jbutton_newAdmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_newAdmissionActionPerformed
        
        NewAdmission admission = new NewAdmission();
        
    }//GEN-LAST:event_jbutton_newAdmissionActionPerformed

    private void jbutton_wardDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_wardDetailsActionPerformed
        
        Wards wd = new Wards();
        
    }//GEN-LAST:event_jbutton_wardDetailsActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        
        Login login = new Login();
        this.dispose();
        
    }//GEN-LAST:event_logoutActionPerformed

    private void jbutton_externalPhysicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_externalPhysicianActionPerformed
        
        ExternalPhysicianDetails ePhysicianDetails = new ExternalPhysicianDetails();
    }//GEN-LAST:event_jbutton_externalPhysicianActionPerformed

    private void jbutton_testsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_testsActionPerformed
        
        Tests tests = new Tests();
        
    }//GEN-LAST:event_jbutton_testsActionPerformed

    private void jbutton_treatmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_treatmentsActionPerformed
        
        Treatments treatments = new Treatments();
        
    }//GEN-LAST:event_jbutton_treatmentsActionPerformed

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
            java.util.logging.Logger.getLogger(Homerecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homerecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homerecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homerecep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Homerecep h = new Homerecep();
                h.setSize(1500, 750);
                h.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutton_externalPhysician;
    private javax.swing.JButton jbutton_newAdmission;
    private javax.swing.JButton jbutton_patientDetails;
    private javax.swing.JButton jbutton_tests;
    private javax.swing.JButton jbutton_treatments;
    private javax.swing.JButton jbutton_wardDetails;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
