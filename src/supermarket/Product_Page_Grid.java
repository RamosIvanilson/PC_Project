
package supermarket;

import javax.swing.Icon;

public class Product_Page_Grid extends javax.swing.JPanel {

    public Product_Page_Grid(String n, String p, Icon i) {
        initComponents();
        name.setText(n);
        price.setText(p + " " + "RON");
        image.setIcon(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();

        name.setBackground(new java.awt.Color(255, 153, 153));
        name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setOpaque(true);

        price.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton image;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
