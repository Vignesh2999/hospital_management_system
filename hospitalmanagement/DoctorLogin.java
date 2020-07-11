
package hospitalmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;
public class DoctorLogin extends javax.swing.JFrame {
    Connection con;
Statement stmt;
ResultSet rs;

    static String name2;
    static String pwd;
    /**
     * Creates new form PatientLogin
     */
    public DoctorLogin() {
        initComponents();
        //Connect();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalcopy","root","");
        stmt=con.createStatement();
        }
        catch(Exception e){
JOptionPane.showMessageDialog(null,"adf");
        }
    }
   
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/doctors.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(280, 10, 300, 110);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 210, 340, 50);

        jLabel2.setText("Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 230, 60, 13);

        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 320, 50, 13);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/login.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(360, 390, 140, 80);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(240, 290, 340, 50);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/2.JPG"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(43, 10, 50, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        String name1 = jTextField1.getText();
        String password1 = jPasswordField1.getText();
Connection con;
PreparedStatement pst;
try{

 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalcopy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
 pst=con.prepareStatement("SELECT * FROM Doctor WHERE DoctorName=? AND Password=?");
 pst.setString(1,jTextField1.getText());
 pst.setString(2,String.valueOf(jPasswordField1.getPassword()));
 ResultSet rs=pst.executeQuery();
 
 if(rs.next())
 {
        ViewAppointments va=new ViewAppointments();
        va.setVisible(true);
        va.setSize(1400,900);
 }
 else
 {
 JOptionPane.showMessageDialog(this,"Name or Password Invalid");
 }
}   catch (SQLException ex) {
        Logger.getLogger(PatientLogin.class.getName()).log(Level.SEVERE, null, ex);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorLogin().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables 
}
