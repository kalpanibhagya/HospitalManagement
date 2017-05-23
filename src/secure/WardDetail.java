package secure;
import java.awt.FlowLayout;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class WardDetail extends javax.swing.JFrame {

    public WardDetail() {
        
        super("Hospital Management System - Ward Details (Administrator logged in)");
        setLayout(new FlowLayout());
        initComponents();
        Show_Wards_In_JTable();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(854, 460);
        setVisible(true);
    }
    Connection conn = MySqlConnect.ConnectDB();
    public ArrayList<Ward> getwardsList(){
        ArrayList<Ward> wardList = new ArrayList();
        //Connection conn = MySqlConnect.ConnectDB();
        
        String query  = "Select * from ward";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Ward ward;
            while(rs.next()){
                ward = new Ward(rs.getInt("Ward_wno"),rs.getString("Ward_name"),rs.getString("SpecializedArea"));
                wardList.add(ward);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return wardList;
    }
    
    public void Show_Wards_In_JTable(){
        
        ArrayList<Ward> list = getwardsList();
        DefaultTableModel model = (DefaultTableModel)jTable_ward.getModel();
        Object[] row= new Object[3];
        for(int i =0; i < list.size(); i++){
            row[0] = list.get(i).getWard_no();
            row[1] = list.get(i).getWard_name();
            row[2] = list.get(i).getWard_speciality();
            
            model.addRow(row);
        }
    }
    
    public void executeSQLQuery(String query,String message){
        //Connection conn = MySqlConnect.ConnectDB();
        Statement st;
        try{
            st = conn.createStatement();
            if(st.executeUpdate(query) == 1){
                //refresh table
                
                DefaultTableModel model = (DefaultTableModel)jTable_ward.getModel();
                model.setRowCount(0);
                Show_Wards_In_JTable();
                
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

        jLabel2 = new javax.swing.JLabel();
        ward_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ward_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        specialized_area = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbutton_add = new javax.swing.JButton();
        jbutton_update = new javax.swing.JButton();
        jbutton_delete = new javax.swing.JButton();
        jbutton_ok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ward = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ward No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Ward Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Specialized Area");

        specialized_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialized_areaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbutton_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_add.setText("ADD");
        jbutton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_addActionPerformed(evt);
            }
        });

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

        jbutton_ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_ok.setText("OK");
        jbutton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbutton_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbutton_update, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jbutton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbutton_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbutton_add)
                .addGap(18, 18, 18)
                .addComponent(jbutton_update)
                .addGap(18, 18, 18)
                .addComponent(jbutton_delete)
                .addGap(18, 18, 18)
                .addComponent(jbutton_ok)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTable_ward.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ward No", "Ward Name", "SP area"
            }
        ));
        jTable_ward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_wardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ward);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ward_name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specialized_area, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ward_no, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ward_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ward_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(specialized_area, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void specialized_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialized_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specialized_areaActionPerformed

    private void jbutton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_addActionPerformed
        
        String query = "INSERT INTO `ward`(`Ward_wno`, `Ward_name`, `SpecializedArea`) VALUES ("+ward_no.getText()+",'"+ward_name.getText()+"','"+specialized_area.getText()+"')";
        executeSQLQuery(query,"inserted");
        
    }//GEN-LAST:event_jbutton_addActionPerformed

    private void jbutton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_updateActionPerformed
        
        String query = "UPDATE `ward` SET `Ward_name`='"+ward_name.getText()+"',`SpecializedArea`='"+specialized_area.getText()+"' WHERE `Ward_wno`="+ward_no.getText();
        executeSQLQuery(query,"updated");
    }//GEN-LAST:event_jbutton_updateActionPerformed

    private void jbutton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_deleteActionPerformed
        
        String query = "DELETE FROM `ward` WHERE `Ward_wno`="+ward_no.getText();
        executeSQLQuery(query,"deleted");
        ward_no.setText(null);
        ward_name.setText(null);
        specialized_area.setText(null);
        
    }//GEN-LAST:event_jbutton_deleteActionPerformed

    private void jbutton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_okActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_okActionPerformed

    private void jTable_wardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_wardMouseClicked
        // Display Selected row in JTextFields
        int i = jTable_ward.getSelectedRow();
        TableModel model = jTable_ward.getModel();
        ward_no.setText(model.getValueAt(i, 0).toString());
        ward_name.setText(model.getValueAt(i, 1).toString());
        specialized_area.setText(model.getValueAt(i, 2).toString());
        
    }//GEN-LAST:event_jTable_wardMouseClicked

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
            java.util.logging.Logger.getLogger(WardDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WardDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WardDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WardDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WardDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ward;
    private javax.swing.JButton jbutton_add;
    private javax.swing.JButton jbutton_delete;
    private javax.swing.JButton jbutton_ok;
    private javax.swing.JButton jbutton_update;
    private javax.swing.JTextField specialized_area;
    private javax.swing.JTextField ward_name;
    private javax.swing.JTextField ward_no;
    // End of variables declaration//GEN-END:variables
}
