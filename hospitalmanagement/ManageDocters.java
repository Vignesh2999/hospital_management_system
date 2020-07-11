package hospitalmanagement;


import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class ManageDocters extends JFrame{
    Connection con;
     Statement stmt;
     ResultSet rs;
    public ManageDocters() {
        initComponents();
        Connect();
    }

   public void Connect(){
       try{
          String host="jdbc:mysql://localhost:3306/hospitalcopy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          String uName="root";
          String uPass="";
          con=DriverManager.getConnection(host,uName,uPass);
         stmt=con.createStatement();
       }catch(SQLException e){
       JOptionPane.showMessageDialog(this,e.getMessage());
       }
    }
      private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 102, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/doctors.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 40, 300, 70);

        jLabel2.setText("Doctor ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 180, 290, 14);

        jLabel3.setText("Doctor Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 240, 290, 14);

        jLabel4.setText("Specialization");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 310, 290, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(500, 170, 220, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(500, 230, 220, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(499, 300, 220, 20);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 340, 150, 23);

        jButton2.setText("Modify");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 340, 150, 23);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 340, 150, 23);

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(550, 340, 150, 23);

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(730, 340, 130, 23);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/2.JPG"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(20, 10, 50, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DoctorID", "DoctorName", "Specialization"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 420, 440, 150);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try
         {
        String doctorid=jTextField1.getText();
        String doctorname=jTextField2.getText();
        String specialization = jTextField3.getText();



        String sql="insert into doctor values("+doctorid+",'"+doctorname+"','"+specialization+"')";
        int n = stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,n + " Record Saved Successfully!");
     }
    catch(SQLException e)
    {
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
      
        try{


       String sql = "update doctor set doctorname='"+jTextField2.getText()+"',specialization='"+jTextField3.getText()+"' where doctorid="+jTextField1.getText();
            int n = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,n + " Records Updated Successfully!");
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        try{

        String sql="delete from doctor where doctorid="+jTextField1.getText();
         int n = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,n + " Records Removed Successfully!");
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       try{

        String sql="select * from doctor";
        rs=stmt.executeQuery(sql);
         
DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
model.setRowCount(0);
         while(rs.next()){
            
            String doctorid =  rs.getString("doctorid");
            String doctorname = rs.getString("doctorname");
            String specialization = rs.getString("specialization");

            model.addRow(new Object[]{doctorid, doctorname, specialization});
            }
         
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }/

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
      jTextField1.setText("");
      jTextField2.setText("");
      jTextField3.setText("");
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       dispose();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDocters().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
   
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
