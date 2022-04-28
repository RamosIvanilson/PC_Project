
package supermarket;

import java.sql.*;
import connection.DatabaseConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import scroll.ScrollBarCustom;


public class Seller_Page extends javax.swing.JFrame {
    
//    private final Connection con;
    
    public Seller_Page() {
        initComponents();
        init();
//        con = DatabaseConnection.getInstance().getConnection();
        prod_scroll.setVerticalScrollBar(new ScrollBarCustom());
        prod_scroll.getVerticalScrollBar().setUnitIncrement(16);
//        body.setLayout(new WrapLayout(WrapLayout.CENTER));
    }

    ImageIcon  GetImage(int id) {
        
        ImageIcon schImage = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT image FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                schImage = new ImageIcon(rs.getBytes("image"));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return schImage;
    }
    
    private void init() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prod_Name = new javax.swing.JTextField();
        prod_Qty = new javax.swing.JTextField();
        button1 = new swing.Button();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        button2 = new swing.Button();
        button3 = new swing.Button();
        prod_scroll = new javax.swing.JScrollPane();
        prodTable = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        button5 = new swing.Button();
        jLabel5 = new javax.swing.JLabel();
        button6 = new swing.Button();
        prod_image = new swing.ImageAvatar();
        button4 = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Product's Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, 37));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Quantity:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 68, 36));

        prod_Name.setEditable(false);
        jPanel2.add(prod_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 241, 38));
        jPanel2.add(prod_Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 241, 36));

        button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        button1.setForeground(new java.awt.Color(51, 102, 255));
        button1.setText("Clear");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 93, 35));

        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 143, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Product's List");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 214, 22));

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        button2.setText("Filter");
        jPanel2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 93, 41));

        button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        button3.setText("Refresh");
        jPanel2.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 125, 41));

        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod ID", "Prod Name", "Prod  Quantity", "Prod Price", "Prod Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prodTable.getTableHeader().setReorderingAllowed(false);
        prodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prodTableMousePressed(evt);
            }
        });
        prod_scroll.setViewportView(prodTable);
        if (prodTable.getColumnModel().getColumnCount() > 0) {
            prodTable.getColumnModel().getColumn(0).setResizable(false);
            prodTable.getColumnModel().getColumn(1).setResizable(false);
            prodTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(prod_scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 582, 243));

        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 203, 40));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 380, 580, 230));

        button5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        button5.setForeground(new java.awt.Color(51, 102, 255));
        button5.setText("Print Bill");
        button5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 123, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BILL");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 582, 35));

        button6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        button6.setForeground(new java.awt.Color(51, 102, 255));
        button6.setText("ADD");
        button6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 93, 35));

        prod_image.setBorderSize(2);
        prod_image.setBorderSpace(-1);
        jPanel2.add(prod_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 400, 380));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 1080, 740));

        button4.setBackground(new java.awt.Color(0, 102, 255));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("X");
        button4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_button4ActionPerformed

    private void prodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMouseClicked
        
    }//GEN-LAST:event_prodTableMouseClicked

    private void prodTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMousePressed
        int id = Integer.parseInt(prodTable.getValueAt(prodTable.getSelectedRow(), 0).toString());
        String prod_name = prodTable.getValueAt(prodTable.getSelectedRow(), 1).toString();
        String prod_qty = prodTable.getValueAt(prodTable.getSelectedRow(), 2).toString();
        ImageIcon imageIcon = GetImage(id);
        prod_image.setImage(imageIcon);
        prod_Name.setText(prod_name);
    }//GEN-LAST:event_prodTableMousePressed

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
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private swing.Button button3;
    private swing.Button button4;
    private swing.Button button5;
    private swing.Button button6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable prodTable;
    private javax.swing.JTextField prod_Name;
    private javax.swing.JTextField prod_Qty;
    private swing.ImageAvatar prod_image;
    private javax.swing.JScrollPane prod_scroll;
    // End of variables declaration//GEN-END:variables
}
