
package secure;
import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;

public class Login extends javax.swing.JFrame {


    public Login() {
        super("Hospital Management System - Login");
        setLayout(new FlowLayout());
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(716, 515);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        jbutton_login = new javax.swing.JButton();
        jbutton_reset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("HOSPITAL MANAGEMENT SYSTEM");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 38, 650, 44);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 332, 90, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 370, 90, 15);

        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        getContentPane().add(un);
        un.setBounds(136, 329, 250, 30);
        getContentPane().add(pw);
        pw.setBounds(136, 367, 250, 30);

        jbutton_login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_login.setText("LOGIN");
        jbutton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jbutton_login);
        jbutton_login.setBounds(140, 430, 100, 23);

        jbutton_reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_reset.setText("RESET");
        jbutton_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_resetActionPerformed(evt);
            }
        });
        getContentPane().add(jbutton_reset);
        jbutton_reset.setBounds(250, 430, 100, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/secure/1.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 700, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void jbutton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_loginActionPerformed
       
        try{
            Connection conn = MySqlConnect.ConnectDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from login where username = '"+un.getText()+"' and password = '"+pw.getText()+"'");
            
            if(rs.next()){
                if(rs.getString(2).equals("admin")){
                    JOptionPane.showMessageDialog(null, "Administrator logged in successfully", "Access Granted", JOptionPane.INFORMATION_MESSAGE);
                    HomeAd h = new HomeAd();
                    this.dispose();
                    
                }else if(rs.getString(2).equals("recep")){
                    JOptionPane.showMessageDialog(null, "Receptionist logged in successfully", "Access Granted", JOptionPane.INFORMATION_MESSAGE);
                    Homerecep h2 = new Homerecep();
                    this.dispose();
                    
                }else if(rs.getString(2).equals("hrman")){
                    JOptionPane.showMessageDialog(null, "HR Manager logged in successfully", "Access Granted", JOptionPane.INFORMATION_MESSAGE);
                    HomeHr h3 = new HomeHr();
                    this.dispose();
                    
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Access Denied",JOptionPane.ERROR_MESSAGE);
                    un.setText(null);
                    pw.setText(null);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            
    }//GEN-LAST:event_jbutton_loginActionPerformed

    private void jbutton_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_resetActionPerformed
        un.setText(null);
        pw.setText(null);
    }//GEN-LAST:event_jbutton_resetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbutton_login;
    private javax.swing.JButton jbutton_reset;
    private javax.swing.JPasswordField pw;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
