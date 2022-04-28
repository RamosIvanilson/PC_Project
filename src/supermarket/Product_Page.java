
package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import scroll.ScrollBarCustom;

public class Product_Page extends javax.swing.JFrame {

    public Product_Page(String category) {
        initComponents();
        body.setLayout(new WrapLayout(WrapLayout.CENTER));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        buy.setVisible(false);
        init(category);
    }
    
    private void init(String categ) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT name, price, image FROM products WHERE category=?");
            ps.setString(1, categ);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String Name = rs.getString("name");
                String pri = String.valueOf(rs.getFloat("price"));
                ImageIcon schImage = new ImageIcon(rs.getBytes("image"));
                body.add(new Product_Page_Grid(Name, pri, schImage));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private Product_Page() {
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();
        buy = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        scroll.setBorder(null);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );

        scroll.setViewportView(body);

        buy.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout buyLayout = new javax.swing.GroupLayout(buy);
        buy.setLayout(buyLayout);
        buyLayout.setHorizontalGroup(
            buyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );
        buyLayout.setVerticalGroup(
            buyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addComponent(buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Product_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel buy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
