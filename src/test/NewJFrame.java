package test;

import connection.DatabaseConnection;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class NewJFrame extends javax.swing.JFrame {

//    private final Connection con;
    
    public NewJFrame() {
        initComponents();
//        con = DatabaseConnection.getInstance().getConnection();
    }
    
    private void test() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\THINKPAD\\Desktop\\icons"));
        
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String n = file.getName().toLowerCase();
                if(file.isDirectory() | n.endsWith(".png") | n.endsWith(".jpg") | n.endsWith(".jpeg")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return ".png | .jpg | .jepg";
            }
        });
        
        int X = fileChooser.showSaveDialog(null);
        if(X == JFileChooser.APPROVE_OPTION) {
            
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            image.setIcon(new ImageIcon(filename));
            System.out.println(name.getText() + " " + filename);
            UploadImage(name.getText().trim(), filename, Integer.parseInt(ID.getText()));
        }
    }
    
    private void UploadImage(String category, String path, int id) {
        
        int userid = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement pS = con.prepareStatement("UPDATE products SET image=? WHERE id=?");
            pS.setBinaryStream(1, new FileInputStream(path));
            pS.setInt(2, id);
            
            pS.execute();
            pS.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upload = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        getContentPane().add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 348, 89, 44));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 237, 259, 46));
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 17, 259, 202));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 289, 89, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        test();
    }//GEN-LAST:event_uploadActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel image;
    private javax.swing.JTextField name;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}
