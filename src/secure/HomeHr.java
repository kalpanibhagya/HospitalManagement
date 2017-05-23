package secure;
import javax.swing.*;
import java.awt.*;

public class HomeHr extends javax.swing.JFrame {

    public HomeHr() {
        super("Hospital Management System - Home (HR Manager logged in)");
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
        jbutton_employeeDetails = new javax.swing.JButton();
        jbutton_wards = new javax.swing.JButton();
        jbutton_logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jbutton_employeeDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_employeeDetails.setText("EMPLOYEE DETAILS");
        jbutton_employeeDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_employeeDetailsActionPerformed(evt);
            }
        });

        jbutton_wards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutton_wards.setText("WARDS");
        jbutton_wards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_wardsActionPerformed(evt);
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
                .addGap(72, 72, 72)
                .addComponent(jbutton_logout)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbutton_employeeDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jbutton_wards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jbutton_employeeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jbutton_wards, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(jbutton_logout)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 230, 770);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/secure/d.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1500, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_employeeDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_employeeDetailsActionPerformed
        
        EmpDetails empDetails = new EmpDetails();
        
    }//GEN-LAST:event_jbutton_employeeDetailsActionPerformed

    private void jbutton_wardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_wardsActionPerformed
        
        Wards wards = new Wards();
        
    }//GEN-LAST:event_jbutton_wardsActionPerformed

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
            java.util.logging.Logger.getLogger(HomeHr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeHr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeHr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeHr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeHr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutton_employeeDetails;
    private javax.swing.JButton jbutton_logout;
    private javax.swing.JButton jbutton_wards;
    // End of variables declaration//GEN-END:variables
}
