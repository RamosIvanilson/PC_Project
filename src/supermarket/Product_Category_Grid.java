
package supermarket;

import javax.swing.Icon;

public class Product_Category_Grid extends javax.swing.JPanel {

    public Product_Category_Grid(String category, Icon imag) {
        initComponents();
        name.setText(category);
        image.setIcon(imag);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        image = new javax.swing.JButton();

        name.setBackground(new java.awt.Color(255, 255, 102));
        name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 51, 51));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setOpaque(true);

        image.setBorder(null);
        image.setOpaque(true);
        image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageActionPerformed
        new Product_Page(name.getText().trim()).setVisible(true);
    }//GEN-LAST:event_imageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton image;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
