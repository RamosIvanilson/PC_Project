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

public class NewJFrame1 extends javax.swing.JFrame {

//    private final Connection con;
    
    public NewJFrame1() {
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
            float p = Float.valueOf(price.getText().trim());
            UploadImage(category.getText().trim(), name.getText().trim(), p, filename);
        }
    }
    
    private void UploadImage(String category, String name, float price, String path) {
        
        int userid = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement pS = con.prepareStatement("INSERT INTO products(category, name, price, image) VALUES(?,?,?,?)");

            pS.setString(1, category);
            pS.setString(2, name);
            pS.setFloat(3, price);
            pS.setBinaryStream(4, new FileInputStream(path));
            
            pS.execute();
            pS.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upload = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        price = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(category)
                                    .addComponent(price)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField category;
    private javax.swing.JLabel image;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}
