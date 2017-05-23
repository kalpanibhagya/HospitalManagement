package secure;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ExternalPhysicianDetails extends javax.swing.JFrame {

    public ExternalPhysicianDetails() {
        
        super("Hospital Management System - External Physician Details");
        setLayout(new FlowLayout());
        initComponents();
        Show_Physicians_In_JTable();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(575, 575);
        setVisible(true);
    }

    Connection conn = MySqlConnect.ConnectDB();
    
    public ArrayList<ExternalPhysician> getphysicianList(){
        ArrayList<ExternalPhysician> physicianList = new ArrayList();
        
        
        String query  = "Select * from external_physician";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ExternalPhysician physician;
            while(rs.next()){
                physician = new ExternalPhysician(rs.getInt("Physician_no"),rs.getString("Physician_name"),rs.getString("Physician_address"),rs.getString("Physician_telephone"));
                physicianList.add(physician);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return physicianList;
    }
    
    public void Show_Physicians_In_JTable(){
        
        ArrayList<ExternalPhysician> list = getphysicianList();
        DefaultTableModel model = (DefaultTableModel)jTable_physician.getModel();
        Object[] row= new Object[4];
        for(int i =0; i < list.size(); i++){
            row[0] = list.get(i).getPhysician_id();
            row[1] = list.get(i).getPhysician_name();
            row[2] = list.get(i).getPhysician_address();
            row[3] = list.get(i).getPhysician_telephone();
            
            model.addRow(row);
        }
    }
    
     public void executeSQLQuery(String query,String message){
        
        Statement st;
        try{
            st = conn.createStatement();
            if(st.executeUpdate(query) == 1){
                //refresh table
                
                DefaultTableModel model = (DefaultTableModel)jTable_physician.getModel();
                model.setRowCount(0);
                Show_Physicians_In_JTable();
                
                JOptionPane.showMessageDialog(null, "Data " +message + " successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Data not " +message + " successfully");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        physician_name = new javax.swing.JTextField();
        ext = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        physician_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        physician_address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        physician_telephone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton_add = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_ok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_physician = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        ext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ext.setText("External Physician");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Physician ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Telephone");

        physician_telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physician_telephoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ext, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(physician_no, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(physician_name)
                    .addComponent(physician_address, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(physician_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physician_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ext))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physician_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physician_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physician_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add.setText("ADD");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_delete.setText("DELETE");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jButton_ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ok.setText("OK");
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_add)
                .addGap(18, 18, 18)
                .addComponent(jButton_update)
                .addGap(18, 18, 18)
                .addComponent(jButton_delete)
                .addGap(18, 18, 18)
                .addComponent(jButton_ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_add)
                    .addComponent(jButton_update)
                    .addComponent(jButton_delete)
                    .addComponent(jButton_ok))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTable_physician.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Physiciian No.", "Physician Name", "Address", "Telephone"
            }
        ));
        jTable_physician.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_physicianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_physician);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void physician_telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physician_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_physician_telephoneActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        
        String query = "INSERT INTO `external_physician`(`Physician_no`, `Physician_name`, `Physician_address`, `Physician_telephone`) VALUES ("+physician_no.getText()+",'"+physician_name.getText()+"','"+physician_address.getText()+"','"+physician_telephone.getText()+"')";
        executeSQLQuery(query,"inserted");
        
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        
        String query = "UPDATE `external_physician` SET `Physician_name`='"+physician_name.getText()+"',`Physician_address`='"+physician_address.getText()+"',`Physician_telephone`='"+physician_telephone.getText()+"' WHERE `Physician_no`="+physician_no.getText();
        executeSQLQuery(query,"updated");
            
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        
        String query = "DELETE FROM `external_physician` WHERE `Physician_no`="+physician_no.getText();
        executeSQLQuery(query,"deleted");
        physician_no.setText(null);
        physician_name.setText(null);
        physician_address.setText(null);
        physician_telephone.setText(null);
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jButton_okActionPerformed

    private void jTable_physicianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_physicianMouseClicked
        
        int i = jTable_physician.getSelectedRow();
        TableModel model = jTable_physician.getModel();
        physician_no.setText(model.getValueAt(i, 0).toString());
        physician_name.setText(model.getValueAt(i, 1).toString());
        physician_address.setText(model.getValueAt(i, 2).toString());
        physician_telephone.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jTable_physicianMouseClicked

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
            java.util.logging.Logger.getLogger(ExternalPhysicianDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExternalPhysicianDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExternalPhysicianDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExternalPhysicianDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExternalPhysicianDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ext;
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_physician;
    private javax.swing.JTextField physician_address;
    private javax.swing.JTextField physician_name;
    private javax.swing.JTextField physician_no;
    private javax.swing.JTextField physician_telephone;
    // End of variables declaration//GEN-END:variables
}
