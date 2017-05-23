
package secure;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JFrame;

public class TestDetails extends javax.swing.JFrame {

    public TestDetails() {
        super("Hospital Management System - Test Details (Administrator logged in)");
        setLayout(new FlowLayout());
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 520);
        setVisible(true);
    }
    
    Connection conn = MySqlConnect.ConnectDB();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        admission_no = new javax.swing.JTextField();
        patient_name = new javax.swing.JTextField();
        test_no = new javax.swing.JTextField();
        test_name = new javax.swing.JTextField();
        test_result = new javax.swing.JTextField();
        jbutton_record = new javax.swing.JButton();
        jbutton_update = new javax.swing.JButton();
        jbutton_delete = new javax.swing.JButton();
        jbutton_cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_test = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Admission No.");

        jLabel3.setText("Patient Name");

        jLabel4.setText("Test No.");

        jLabel5.setText("Test Name");

        jLabel6.setText("Test Result");

        patient_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_nameActionPerformed(evt);
            }
        });

        test_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                test_noKeyReleased(evt);
            }
        });

        test_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_nameActionPerformed(evt);
            }
        });

        test_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_resultActionPerformed(evt);
            }
        });

        jbutton_record.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_record.setText("RECORD");

        jbutton_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_update.setText("UPDATE");
        jbutton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_updateActionPerformed(evt);
            }
        });

        jbutton_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_delete.setText("DELETE");
        jbutton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_deleteActionPerformed(evt);
            }
        });

        jbutton_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_cancel.setText("CANCEL");
        jbutton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_cancelActionPerformed(evt);
            }
        });

        jTable_test.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission No.", "Patient Name", "Test No.", "Test Name", "Test Result"
            }
        ));
        jScrollPane1.setViewportView(jTable_test);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(admission_no, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(patient_name))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(test_no, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(test_name, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(test_result, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbutton_record, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbutton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbutton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbutton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(admission_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(patient_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(test_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(test_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(test_result, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbutton_record)
                            .addComponent(jbutton_update)
                            .addComponent(jbutton_delete)
                            .addComponent(jbutton_cancel))))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patient_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_nameActionPerformed

    private void test_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_test_nameActionPerformed

    private void test_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_test_resultActionPerformed

    private void jbutton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_updateActionPerformed
        
    }//GEN-LAST:event_jbutton_updateActionPerformed

    private void jbutton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbutton_deleteActionPerformed

    private void jbutton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_cancelActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_cancelActionPerformed

    private void test_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_test_noKeyReleased
        // TODO add your handling code here:
        try{
            String query = "Select * from test WHERE Test_no ="+test_no.getText();
        
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            String add = rs.getString("Test_name");
            test_name.setText(add);
            
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_test_noKeyReleased

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
            java.util.logging.Logger.getLogger(TestDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admission_no;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_test;
    private javax.swing.JButton jbutton_cancel;
    private javax.swing.JButton jbutton_delete;
    private javax.swing.JButton jbutton_record;
    private javax.swing.JButton jbutton_update;
    private javax.swing.JTextField patient_name;
    private javax.swing.JTextField test_name;
    private javax.swing.JTextField test_no;
    private javax.swing.JTextField test_result;
    // End of variables declaration//GEN-END:variables
}
