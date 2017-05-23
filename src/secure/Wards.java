package secure;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Wards extends javax.swing.JFrame {

    public Wards() {
        super("Hospital Management System - Wards");
        setLayout(new FlowLayout());
        initComponents();
        
        Show_Wards_In_JTable();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(485, 480);
        setVisible(true);
    }
    
    Connection conn = MySqlConnect.ConnectDB();
    public ArrayList<Ward> getwardsList(){
        ArrayList<Ward> wardList = new ArrayList();
        
        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbutton_ok = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_ward = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbutton_ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_ok.setText("OK");
        jbutton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_okActionPerformed(evt);
            }
        });

        jTable_ward.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ward No.", "Ward Name", "Specialized Area"
            }
        ));
        jScrollPane2.setViewportView(jTable_ward);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jbutton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbutton_ok)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_okActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_okActionPerformed

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
            java.util.logging.Logger.getLogger(Wards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_ward;
    private javax.swing.JButton jbutton_ok;
    // End of variables declaration//GEN-END:variables
}
