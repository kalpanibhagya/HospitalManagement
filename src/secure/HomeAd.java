
package secure;
import java.awt.FlowLayout;
import javax.swing.*;

public class HomeAd extends javax.swing.JFrame {

    public HomeAd() {
        super("Hospital Management System - Home (Administrator logged in)");
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
        jbutton_wardDetails = new javax.swing.JButton();
        jbutton_paymentDetails = new javax.swing.JButton();
        jbutton_testDetails = new javax.swing.JButton();
        jbutton_treatmentDetails = new javax.swing.JButton();
        jbutton_logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbutton_wardDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_wardDetails.setText("WARD DETAILS");
        jbutton_wardDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_wardDetailsActionPerformed(evt);
            }
        });

        jbutton_paymentDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_paymentDetails.setText("PAYMENT DETAILS");
        jbutton_paymentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_paymentDetailsActionPerformed(evt);
            }
        });

        jbutton_testDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_testDetails.setText("TEST DETAILS");
        jbutton_testDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_testDetailsActionPerformed(evt);
            }
        });

        jbutton_treatmentDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_treatmentDetails.setText("TREATMENT DETAILS");
        jbutton_treatmentDetails.setToolTipText("");
        jbutton_treatmentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_treatmentDetailsActionPerformed(evt);
            }
        });

        jbutton_logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_logout.setText("LOG OUT");
        jbutton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbutton_testDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbutton_paymentDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbutton_wardDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbutton_treatmentDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jbutton_logout)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jbutton_wardDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jbutton_paymentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jbutton_testDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jbutton_treatmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jbutton_logout)
                .addGap(83, 83, 83))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -10, 240, 760);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/secure/d.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_wardDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_wardDetailsActionPerformed

        WardDetail wardDeatails = new WardDetail();
        
    }//GEN-LAST:event_jbutton_wardDetailsActionPerformed

    private void jbutton_paymentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_paymentDetailsActionPerformed

        Payment paymentDetails = new Payment();
        
    }//GEN-LAST:event_jbutton_paymentDetailsActionPerformed

    private void jbutton_testDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_testDetailsActionPerformed
        
        TestDetails test = new TestDetails();
        
    }//GEN-LAST:event_jbutton_testDetailsActionPerformed

    private void jbutton_treatmentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_treatmentDetailsActionPerformed
        
        TreatmentDetails td = new TreatmentDetails();
        
    }//GEN-LAST:event_jbutton_treatmentDetailsActionPerformed

    private void jbutton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_logoutActionPerformed
        
        Login login = new Login();
        this.dispose();
    }//GEN-LAST:event_jbutton_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(HomeAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutton_logout;
    private javax.swing.JButton jbutton_paymentDetails;
    private javax.swing.JButton jbutton_testDetails;
    private javax.swing.JButton jbutton_treatmentDetails;
    private javax.swing.JButton jbutton_wardDetails;
    // End of variables declaration//GEN-END:variables
}
