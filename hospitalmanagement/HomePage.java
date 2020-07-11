
package hospitalmanagement;

import java.awt.*;
import javax.swing.*;
public class HomePage extends javax.swing.JFrame {

   
    public HomePage() {
        initComponents();
   
    }

    

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/hospital management logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 0, 942, 140);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/login.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 390, 150, 90);

        jLabel2.setText("Enter Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 190, 110, 50);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 280, 100, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(450, 190, 340, 50);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(450, 280, 340, 50);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagement/images/2.JPG"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 20, 70, 60);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = jTextField1.getText();
        String password = jPasswordField1.getText();

        if(name.equals("admin") && password.equals("admin"))
        {
         AdminPanel admin = new AdminPanel();
         admin.setSize(1400,700);
admin.setVisible(true);
        }
 else
        {
          JOptionPane.showMessageDialog(this , "Login Failed");
 }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
        dispose();
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomePage home = new HomePage();
                home.setSize(1400,700);
                home.setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables

}

