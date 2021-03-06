
package hospitalmanagement;


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ManagePatient extends javax.swing.JFrame {
Connection con;
     Statement stmt;
     ResultSet rs;
   
    public ManagePatient() {
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
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/patient.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 10, 310, 90);

        jLabel2.setText("Patient Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 120, 220, 40);

        jLabel3.setText("Patient  Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 180, 220, 40);

        jLabel4.setText("Patient Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 240, 220, 40);

        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 360, 220, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(380, 110, 230, 50);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(380, 170, 230, 50);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(380, 230, 230, 50);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(380, 360, 230, 50);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 430, 80, 21);

        jButton2.setText("Modify");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 430, 80, 21);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 430, 80, 21);

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(180, 480, 90, 21);

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(300, 480, 100, 20);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/2.JPG"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(30, 10, 50, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Patient Name", "Address", "Gender", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(640, 110, 520, 220);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(380, 300, 230, 50);

        jLabel6.setText("Gender");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 300, 220, 40);

        pack();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    
      jTextField1.setText("");
      jTextField2.setText("");
      jTextField3.setText("");
      jTextField4.setText("");


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       try
         {
        String patientid=jTextField1.getText();
        String patientname=jTextField2.getText();
        String patientaddress = jTextField3.getText();
        String gender = jTextField5.getText();
        String password = jTextField4.getText();

        String sql="insert into patient values("+patientid+",'"+patientname+"','"+patientaddress+"','"+gender+"','"+password+"')";
        int n = stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,n + " Record Saved Successfully!");
     }
    catch(SQLException e)
    {
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {/
         try{
String sql = "update patient set patientname='"+jTextField2.getText()+"',patientaddress='"+jTextField3.getText()+"',gender='"+jTextField5.getText()+"',password='"+jTextField4.getText()+"' where patientid="+jTextField1.getText();
            int n = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,n + " Records Updated Successfully!");
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    try{

        String sql="delete from patient where patientid="+jTextField1.getText();
         int n = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,n + " Records Removed Successfully!");
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
         try{

        String sql="select * from patient";
        rs=stmt.executeQuery(sql);
         
          DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
model.setRowCount(0);
         while(rs.next()){
             String patientid =  rs.getString("patientid");
            String patientname = rs.getString("patientname");
            String address = rs.getString("patientaddress");
            String gender = rs.getString("gender");
            String password = rs.getString("password");
            model.addRow(new Object[]{patientid, patientname,address,gender,password});
            
            }
         
        }catch(SQLException  e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
dispose();       
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePatient().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
  
}
