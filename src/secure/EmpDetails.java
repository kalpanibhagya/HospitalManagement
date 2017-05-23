package secure;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmpDetails extends javax.swing.JFrame {

    public EmpDetails() {
        super("Hospital Management System - Employee Details (HR Manager logged in)");
        setLayout(new FlowLayout());
        initComponents();
        
        Show_Members_In_JTable();
        Show_Nurses_In_JTable();
        Show_Doctors_In_JTable();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1340, 700);
        setVisible(true);
    }

    Connection conn = MySqlConnect.ConnectDB();
   
    public ArrayList<MaintenanceStaffMember> getmembersList(){
        ArrayList<MaintenanceStaffMember> memberList = new ArrayList();
        
        String query  = "Select * from maintenance_staff_member";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                MaintenanceStaffMember member = new MaintenanceStaffMember(rs.getString("MID"),rs.getString("Mname"),rs.getInt("Mage"),rs.getString("Mgender"),rs.getString("Maddress"),rs.getString("Mtelephone"),rs.getFloat("Salary_rate_M"),rs.getInt("Mattendance"),rs.getFloat("MSalary"));
                memberList.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return memberList;
    }
    
    public ArrayList<Nurse> getnursesList(){
        ArrayList<Nurse> nurseList = new ArrayList();
        
        String query2  = "Select * from nurse";
        Statement st2;
        ResultSet rs2;
        
        try {
            st2 = conn.createStatement();
            rs2 = st2.executeQuery(query2);

            while(rs2.next()){
                Nurse nurse = new Nurse(rs2.getInt("Ward_no"),rs2.getString("NID"),rs2.getString("Nname"),rs2.getInt("Nage"),rs2.getString("Ngender"),rs2.getString("Naddress"),rs2.getString("Ntelephone"),rs2.getFloat("Salary_rate_N"),rs2.getInt("Nattendence"),rs2.getFloat("NSalary"));
                nurseList.add(nurse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return nurseList;
    }
    
    public ArrayList<Doctor> getdoctorsList(){
        ArrayList<Doctor> doctorList = new ArrayList();
        
        String query3  = "Select * from doctor";
        Statement st3;
        ResultSet rs3;
        
        try {
            st3 = conn.createStatement();
            rs3 = st3.executeQuery(query3);

            while(rs3.next()){
                Doctor doctor = new Doctor(rs3.getString("LC"),rs3.getString("Dmail"),rs3.getString("Specialized_area"),rs3.getString("DID"),rs3.getString("Dname"),rs3.getInt("Dage"),rs3.getString("Dgender"),rs3.getString("Daddress"),rs3.getString("Dtelephone"),rs3.getFloat("Salary_rate_D"),rs3.getInt("Dattendence"),rs3.getFloat("DSalary"));
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return doctorList;
    }
    
    
    public void Show_Members_In_JTable(){
        
        ArrayList<MaintenanceStaffMember> list = getmembersList();
        DefaultTableModel model = (DefaultTableModel)jTable_member.getModel();
        Object[] row= new Object[9];
        for(int k =0; k < list.size(); k++){
            row[0] = list.get(k).getEmp_id();
            row[1] = list.get(k).getEmp_name();
            row[2] = list.get(k).getEmp_age();
            row[3] = list.get(k).getEmp_gender();
            row[4] = list.get(k).getEmp_address();
            row[5] = list.get(k).getEmp_telephone();
            row[6] = list.get(k).getEmp_salary_rate();
            row[7] = list.get(k).getEmp_attendence();
            row[8] = list.get(k).getEmp_salary();
            
            model.addRow(row);
        }
    }
    public void Show_Nurses_In_JTable(){
        
        ArrayList<Nurse> list = getnursesList();
        DefaultTableModel model2 = (DefaultTableModel)jTable_nurse.getModel();
        Object[] row= new Object[10];
        for(int k =0; k < list.size(); k++){
            row[0] = list.get(k).getEmp_id();
            row[1] = list.get(k).getEmp_name();
            row[2] = list.get(k).getNurse_ward_no();
            row[3] = list.get(k).getEmp_age();
            row[4] = list.get(k).getEmp_gender();
            row[5] = list.get(k).getEmp_address();
            row[6] = list.get(k).getEmp_telephone();
            row[7] = list.get(k).getEmp_salary_rate();
            row[8] = list.get(k).getEmp_attendence();
            row[9] = list.get(k).getEmp_salary();
            
            model2.addRow(row);
        }
    }
    
    public void Show_Doctors_In_JTable(){
        
        ArrayList<Doctor> list = getdoctorsList();
        DefaultTableModel model3 = (DefaultTableModel)jTable_doc.getModel();
        Object[] row= new Object[12];
        for(int k =0; k < list.size(); k++){
            row[0] = list.get(k).getEmp_id();
            row[1] = list.get(k).getEmp_name();
            row[2] = list.get(k).getSpecialized_area();
            row[3] = list.get(k).getDoctor_LC();
            row[4] = list.get(k).getEmp_age();
            row[5] = list.get(k).getEmp_gender();
            row[6] = list.get(k).getEmp_address();
            row[7] = list.get(k).getEmp_telephone();
            row[8] = list.get(k).getDoctor_email();
            row[9] = list.get(k).getEmp_salary_rate();
            row[10] = list.get(k).getEmp_attendence();
            row[11] = list.get(k).getEmp_salary();
            
            model3.addRow(row);
        }
    }
    
    public void executeSQLQuery(String query,String message,javax.swing.JTable jtable){
        
        Statement st;
        try{
            st = conn.createStatement();
            if(st.executeUpdate(query) == 1){
                //refresh tables
                
                DefaultTableModel model = (DefaultTableModel)jtable.getModel();
                model.setRowCount(0);

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        doc_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        doc_name = new javax.swing.JTextField();
        doc_age = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        doc_sp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        doc_address = new javax.swing.JTextField();
        doc_telephone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_doc = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton_add_doc = new javax.swing.JButton();
        jbutton_update_doc = new javax.swing.JButton();
        jbutton_delete_doc = new javax.swing.JButton();
        jbutton_ok_doc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        doc_email = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        salary_rate_d = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        attendence_d = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        salary_d = new javax.swing.JTextField();
        doc_lc = new javax.swing.JTextField();
        doc_gender = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        nurse_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nurse_ward_no = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        nurse_name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nurse_age = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nurse_telephone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        nurse_address = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        salary_rate_n = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        attendance_n = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        salary_n = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton_nurse_add = new javax.swing.JButton();
        jbutton_update_nurse = new javax.swing.JButton();
        jbutton_delete_nurse = new javax.swing.JButton();
        jbutton_ok_nurse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_nurse = new javax.swing.JTable();
        nurse_gender = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        member_id = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        member_name = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        member_age = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        member_address = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        member_telephone = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        salary_rate_m = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        attendance_m = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        salary_m = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton_add_member = new javax.swing.JButton();
        jbutton_update_member = new javax.swing.JButton();
        jbutton_delete_member = new javax.swing.JButton();
        jbutton_ok_member = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_member = new javax.swing.JTable();
        member_gender = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Employee ID");

        jLabel3.setText("Name");

        jLabel5.setText("Leading Consultant");

        jLabel8.setText("Address");

        jLabel9.setText("Telephone");

        jLabel6.setText("Age");

        jLabel4.setText("Specialized Area");

        jLabel7.setText("Gender");

        doc_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_addressActionPerformed(evt);
            }
        });

        jTable_doc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Name", "Sp area", "LC", "Age", "Gender", "Address", "Telephone", "Email address", "Salary rate", "Attendence", "Salary"
            }
        ));
        jTable_doc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_docMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_doc);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_add_doc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add_doc.setText("ADD");
        jButton_add_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_docActionPerformed(evt);
            }
        });

        jbutton_update_doc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_update_doc.setText("UPDATE");
        jbutton_update_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_update_docActionPerformed(evt);
            }
        });

        jbutton_delete_doc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_delete_doc.setText("DELETE");
        jbutton_delete_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_delete_docActionPerformed(evt);
            }
        });

        jbutton_ok_doc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_ok_doc.setText("OK");
        jbutton_ok_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_ok_docActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbutton_ok_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_delete_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_update_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_add_doc)
                .addGap(18, 18, 18)
                .addComponent(jbutton_update_doc)
                .addGap(18, 18, 18)
                .addComponent(jbutton_delete_doc)
                .addGap(18, 18, 18)
                .addComponent(jbutton_ok_doc)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setText("Email Address");

        doc_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_emailActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setText("Salary rate");

        jLabel36.setText("Attendance");

        jLabel37.setText("Salary");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary_rate_d, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attendence_d, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salary_d))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(salary_rate_d, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(attendence_d, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(salary_d, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(doc_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doc_address)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(doc_age, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(doc_lc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(doc_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doc_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doc_email, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(163, 163, 163)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(doc_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doc_lc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(doc_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(doc_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(doc_age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(doc_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(doc_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Doctor Details", jPanel1);

        jLabel10.setText("Employee ID");

        nurse_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nurse_idActionPerformed(evt);
            }
        });

        jLabel14.setText("Ward No.");

        jLabel15.setText("Name");

        jLabel16.setText("Age");

        jLabel17.setText("Gender");

        jLabel18.setText("Telephone");

        jLabel19.setText("Address");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setText("Salary rate");

        jLabel24.setText("Attendence");

        jLabel25.setText("Salary");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary_rate_n, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attendance_n, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salary_n))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(salary_rate_n, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(attendance_n, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(salary_n, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_nurse_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_nurse_add.setText("ADD");
        jButton_nurse_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nurse_addActionPerformed(evt);
            }
        });

        jbutton_update_nurse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_update_nurse.setText("UPDATE");
        jbutton_update_nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_update_nurseActionPerformed(evt);
            }
        });

        jbutton_delete_nurse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_delete_nurse.setText("DELETE");
        jbutton_delete_nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_delete_nurseActionPerformed(evt);
            }
        });

        jbutton_ok_nurse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_ok_nurse.setText("OK");
        jbutton_ok_nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_ok_nurseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbutton_delete_nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_update_nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_ok_nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_nurse_add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_nurse_add)
                .addGap(18, 18, 18)
                .addComponent(jbutton_update_nurse)
                .addGap(18, 18, 18)
                .addComponent(jbutton_delete_nurse)
                .addGap(18, 18, 18)
                .addComponent(jbutton_ok_nurse)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable_nurse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Name", "Ward No", "Age", "Gender", "Address", "Telephone", "Salary rate", "Attendence", "Salary"
            }
        ));
        jTable_nurse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_nurseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_nurse);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(nurse_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(nurse_age, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nurse_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nurse_ward_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nurse_name)
                            .addComponent(nurse_address)
                            .addComponent(nurse_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(nurse_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(nurse_ward_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nurse_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nurse_age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(nurse_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nurse_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(nurse_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Nurse Details", jPanel2);

        jLabel20.setText("Employee ID");

        member_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                member_idActionPerformed(evt);
            }
        });

        jLabel21.setText("Name");

        jLabel22.setText("Age");

        jLabel26.setText("Gender");

        jLabel27.setText("Address");

        jLabel28.setText("Telephone");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setText("Salary rate");

        salary_rate_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary_rate_mActionPerformed(evt);
            }
        });

        jLabel30.setText("Attendence");

        jLabel31.setText("Salary");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary_rate_m, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attendance_m, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salary_m))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(salary_rate_m, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(attendance_m, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(salary_m, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_add_member.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add_member.setText("ADD");
        jButton_add_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_memberActionPerformed(evt);
            }
        });

        jbutton_update_member.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_update_member.setText("UPDATE");
        jbutton_update_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_update_memberActionPerformed(evt);
            }
        });

        jbutton_delete_member.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_delete_member.setText("DELETE");
        jbutton_delete_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_delete_memberActionPerformed(evt);
            }
        });

        jbutton_ok_member.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbutton_ok_member.setText("OK");
        jbutton_ok_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_ok_memberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbutton_update_member, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_delete_member, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutton_ok_member, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add_member, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_add_member)
                .addGap(18, 18, 18)
                .addComponent(jbutton_update_member)
                .addGap(18, 18, 18)
                .addComponent(jbutton_delete_member)
                .addGap(18, 18, 18)
                .addComponent(jbutton_ok_member)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Name", "Age", "Gender", "Address", "Telephone", "Salary rate", "Attendence", "Salary"
            }
        ));
        jTable_member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_memberMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_member);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(member_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(member_age, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(member_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(member_name)
                                    .addComponent(member_address))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(member_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(member_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(member_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(member_age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26)
                            .addComponent(member_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(member_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(member_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Maintenance Staff Details ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doc_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_addressActionPerformed

    }//GEN-LAST:event_doc_addressActionPerformed

    private void jButton_add_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_docActionPerformed
        String query = "INSERT INTO `doctor`(`DID`, `Dname`, `Dage`, `Dgender`, `Dmail`, `Daddress`, `Dtelephone`, `LC`, `Specialized_area`, `Salary_rate_D`) VALUES ('"+doc_id.getText()+"','"+doc_name.getText()+"',"+doc_age.getText()+",'"+doc_gender.getText()+"','"+doc_email.getText()+"','"+doc_address.getText()+"','"+doc_telephone.getText()+"','"+doc_lc.getText()+"','"+doc_sp.getText()+"',"+salary_rate_d.getText()+")";
        executeSQLQuery(query,"inserted",jTable_doc);
        Show_Doctors_In_JTable();
        
    }//GEN-LAST:event_jButton_add_docActionPerformed

    private void jbutton_update_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_update_docActionPerformed
        String query = "UPDATE `doctor` SET `Dname`='"+doc_name.getText()+"',`Dage`="+doc_age.getText()+",`Dgender`='"+doc_gender.getText()+"',`Dmail`='"+doc_email.getText()+"',`Daddress`='"+doc_address.getText()+"',`Dtelephone`='"+doc_telephone.getText()+"',`LC`='"+doc_lc.getText()+"',`Specialized_area`='"+doc_sp.getText()+"',`Dattendence`="+attendence_d.getText()+",`Salary_rate_D`="+salary_rate_d.getText()+",`DSalary`="+salary_d.getText()+" WHERE `DID`='"+doc_id.getText()+"'";
        executeSQLQuery(query,"updated",jTable_doc);
        Show_Doctors_In_JTable();
        
    }//GEN-LAST:event_jbutton_update_docActionPerformed

    private void nurse_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nurse_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nurse_idActionPerformed

    private void jbutton_delete_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_delete_docActionPerformed
        String query = "DELETE FROM `doctor` WHERE `DID`='"+doc_id.getText()+"'";
        executeSQLQuery(query,"deleted",jTable_doc);
        Show_Doctors_In_JTable();
        
    }//GEN-LAST:event_jbutton_delete_docActionPerformed

    private void jbutton_ok_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_ok_docActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_ok_docActionPerformed

    private void jButton_nurse_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nurse_addActionPerformed
        String query = "INSERT INTO `nurse`(`NID`, `Nname`, `Nage`, `Ngender`, `Naddress`, `Ntelephone`, `Ward_no`, `Salary_rate_N`) VALUES ('"+nurse_id.getText()+"','"+nurse_name.getText()+"',"+nurse_age.getText()+",'"+nurse_gender.getText()+"','"+nurse_address.getText()+"','"+nurse_telephone.getText()+"',"+nurse_ward_no.getText()+","+salary_rate_n.getText()+")";
        executeSQLQuery(query,"inserted",jTable_nurse);
        Show_Nurses_In_JTable();
    }//GEN-LAST:event_jButton_nurse_addActionPerformed

    private void jbutton_update_nurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_update_nurseActionPerformed
        
        String query = "UPDATE `nurse` SET `Nname`='"+nurse_name.getText()+"',`Nage`="+nurse_age.getText()+",`Ngender`='"+nurse_gender.getText()+"',`Naddress`='"+nurse_address.getText()+"',`Ntelephone`='"+nurse_telephone.getText()+"',`Ward_no`="+nurse_ward_no.getText()+",`Salary_rate_N`="+salary_rate_n.getText()+",`Nattendence`="+attendance_n.getText()+",`NSalary`="+salary_n.getText()+" WHERE `NID`='"+nurse_id.getText()+"'";
        executeSQLQuery(query,"updated",jTable_nurse);
        Show_Nurses_In_JTable();
        
    }//GEN-LAST:event_jbutton_update_nurseActionPerformed

    private void jbutton_delete_nurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_delete_nurseActionPerformed
        
        String query = "DELETE FROM `nurse` WHERE `NID`='"+nurse_id.getText()+"'";
        executeSQLQuery(query,"deleted",jTable_nurse);
        Show_Nurses_In_JTable();
        
    }//GEN-LAST:event_jbutton_delete_nurseActionPerformed

    private void jbutton_ok_nurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_ok_nurseActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_ok_nurseActionPerformed

    private void member_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_member_idActionPerformed
        
    }//GEN-LAST:event_member_idActionPerformed

    private void jButton_add_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_memberActionPerformed
        
        String query = "INSERT INTO `maintenance_staff_member`(`MID`, `Mname`, `Mage`, `Mgender`, `Maddress`, `Mtelephone`, `Salary_rate_M`) VALUES ('"+member_id.getText()+"','"+member_name.getText()+"',"+member_age.getText()+",'"+member_gender.getText()+"','"+member_address.getText()+"','"+member_telephone.getText()+"',"+salary_rate_m.getText()+")";
        executeSQLQuery(query,"inserted",jTable_member);
        Show_Members_In_JTable();
        
    }//GEN-LAST:event_jButton_add_memberActionPerformed

    private void jbutton_update_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_update_memberActionPerformed
        
        String query = "UPDATE `maintenance_staff_member` SET `Mname`='"+member_name.getText()+"',`Mage`="+member_age.getText()+",`Mgender`='"+member_gender.getText()+"',`Maddress`='"+member_address.getText()+"',`Mtelephone`='"+member_telephone.getText()+"',`Salary_rate_M`="+salary_rate_m.getText()+",`Mattendance`="+attendance_m.getText()+",`MSalary`="+salary_m.getText()+" WHERE `MID`='"+member_id.getText()+"'";
        executeSQLQuery(query,"updated",jTable_member);
        Show_Members_In_JTable();
        
    }//GEN-LAST:event_jbutton_update_memberActionPerformed

    private void jbutton_delete_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_delete_memberActionPerformed
        
        String query = "DELETE FROM `maintenance_staff_member` WHERE `MID`='"+member_id.getText()+"'";
        executeSQLQuery(query,"deleted",jTable_member);
        Show_Members_In_JTable();
        
    }//GEN-LAST:event_jbutton_delete_memberActionPerformed

    private void jbutton_ok_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_ok_memberActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbutton_ok_memberActionPerformed

    private void doc_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_emailActionPerformed

    private void jTable_memberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_memberMouseClicked
        
        int k = jTable_member.getSelectedRow();
        TableModel model = jTable_member.getModel();
        member_id.setText(model.getValueAt(k, 0).toString());
        member_name.setText(model.getValueAt(k, 1).toString());
        member_age.setText(model.getValueAt(k, 2).toString());
        member_gender.setText(model.getValueAt(k, 3).toString());
        member_address.setText(model.getValueAt(k, 4).toString());
        member_telephone.setText(model.getValueAt(k, 5).toString());
        salary_rate_m.setText(model.getValueAt(k, 6).toString());
        attendance_m.setText(model.getValueAt(k, 7).toString());
        salary_m.setText(model.getValueAt(k, 8).toString());
        
    }//GEN-LAST:event_jTable_memberMouseClicked

    private void jTable_nurseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_nurseMouseClicked
        
        int j = jTable_nurse.getSelectedRow();
        TableModel model = jTable_nurse.getModel();
        nurse_id.setText(model.getValueAt(j, 0).toString());
        nurse_name.setText(model.getValueAt(j, 1).toString());
        nurse_ward_no.setText(model.getValueAt(j, 2).toString());
        nurse_age.setText(model.getValueAt(j, 3).toString());
        nurse_gender.setText(model.getValueAt(j, 4).toString());
        nurse_address.setText(model.getValueAt(j, 5).toString());
        nurse_telephone.setText(model.getValueAt(j, 6).toString());
        salary_rate_n.setText(model.getValueAt(j, 7).toString());
        attendance_n.setText(model.getValueAt(j, 8).toString());
        salary_n.setText(model.getValueAt(j, 9).toString());
        
    }//GEN-LAST:event_jTable_nurseMouseClicked

    private void jTable_docMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_docMouseClicked
        
        int i = jTable_doc.getSelectedRow();
        TableModel model = jTable_doc.getModel();
        doc_id.setText(model.getValueAt(i, 0).toString());
        doc_name.setText(model.getValueAt(i, 1).toString());
        doc_lc.setText(model.getValueAt(i, 2).toString());
        doc_sp.setText(model.getValueAt(i, 3).toString());
        doc_age.setText(model.getValueAt(i, 4).toString());
        doc_gender.setText(model.getValueAt(i, 5).toString());
        doc_address.setText(model.getValueAt(i, 6).toString());
        doc_telephone.setText(model.getValueAt(i, 7).toString());
        doc_email.setText(model.getValueAt(i, 8).toString());
        salary_rate_d.setText(model.getValueAt(i, 9).toString());
        attendence_d.setText(model.getValueAt(i, 10).toString());
        salary_d.setText(model.getValueAt(i, 11).toString());
        
    }//GEN-LAST:event_jTable_docMouseClicked

    private void salary_rate_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary_rate_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salary_rate_mActionPerformed
       
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
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attendance_m;
    private javax.swing.JTextField attendance_n;
    private javax.swing.JTextField attendence_d;
    private javax.swing.JTextField doc_address;
    private javax.swing.JTextField doc_age;
    private javax.swing.JTextField doc_attendence;
    private javax.swing.JTextField doc_attendence1;
    private javax.swing.JTextField doc_email;
    private javax.swing.JTextField doc_gender;
    private javax.swing.JTextField doc_id;
    private javax.swing.JTextField doc_lc;
    private javax.swing.JTextField doc_name;
    private javax.swing.JTextField doc_salary;
    private javax.swing.JTextField doc_salary1;
    private javax.swing.JTextField doc_salary_rate;
    private javax.swing.JTextField doc_salary_rate1;
    private javax.swing.JTextField doc_sp;
    private javax.swing.JTextField doc_telephone;
    private javax.swing.JButton jButton_add_doc;
    private javax.swing.JButton jButton_add_member;
    private javax.swing.JButton jButton_nurse_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_doc;
    private javax.swing.JTable jTable_member;
    private javax.swing.JTable jTable_nurse;
    private javax.swing.JButton jbutton_delete_doc;
    private javax.swing.JButton jbutton_delete_member;
    private javax.swing.JButton jbutton_delete_nurse;
    private javax.swing.JButton jbutton_ok_doc;
    private javax.swing.JButton jbutton_ok_member;
    private javax.swing.JButton jbutton_ok_nurse;
    private javax.swing.JButton jbutton_update_doc;
    private javax.swing.JButton jbutton_update_member;
    private javax.swing.JButton jbutton_update_nurse;
    private javax.swing.JTextField member_address;
    private javax.swing.JTextField member_age;
    private javax.swing.JTextField member_gender;
    private javax.swing.JTextField member_id;
    private javax.swing.JTextField member_name;
    private javax.swing.JTextField member_telephone;
    private javax.swing.JTextField nurse_address;
    private javax.swing.JTextField nurse_age;
    private javax.swing.JTextField nurse_gender;
    private javax.swing.JTextField nurse_id;
    private javax.swing.JTextField nurse_name;
    private javax.swing.JTextField nurse_telephone;
    private javax.swing.JTextField nurse_ward_no;
    private javax.swing.JTextField salary_d;
    private javax.swing.JTextField salary_m;
    private javax.swing.JTextField salary_n;
    private javax.swing.JTextField salary_rate_d;
    private javax.swing.JTextField salary_rate_m;
    private javax.swing.JTextField salary_rate_n;
    // End of variables declaration//GEN-END:variables
}
