package view;

import business.BasketController;
import business.CartController;
import business.ProductController;
import core.Helper;
import entity.Basket;
import entity.Cart;
import entity.Customer;
import entity.Product;
import java.awt.Toolkit;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.MaskFormatter;

public class CartUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CartUI.class.getName());

    private Customer customer;
    private BasketController basketController;
    private CartController cartController;
    private ProductController productController;
    private ArrayList<Basket> baskets;

    public CartUI(Customer customer) {

        this.customer = customer;
        this.basketController = new BasketController();
        this.cartController = new CartController();
        this.productController = new ProductController();
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(container);
        this.setTitle("Bestellung erstellen");
        this.setSize(400, 450);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        if (customer.getId() == 0) {
            Helper.showMsg("Bitte wählen Sie einen gültigen Kunden aus");
            dispose();
        }
        this.baskets = this.basketController.findAll();

        if (baskets.size() == 0) {
            Helper.showMsg("Bitte legen Sie einen Artikel in Ihren Warenkorb.");
            dispose();
        } else {
            this.setVisible(true);
        }

        this.lbl_customer.setText("Kunde: " + this.customer.getName());
        dateCalculator();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        lbl_cart_title = new javax.swing.JLabel();
        lbl_customer = new javax.swing.JLabel();
        lbl_cart_date = new javax.swing.JLabel();
        fld_cart_date = new javax.swing.JTextField();
        lbl_cart_note = new javax.swing.JLabel();
        scrl_tarea_cart_note = new javax.swing.JScrollPane();
        tarea_cart_note = new javax.swing.JTextArea();
        btn_cart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        lbl_cart_title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_cart_title.setText("Bestellung erstellen");

        lbl_customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_customer.setText("Kunde :");

        lbl_cart_date.setText("Bestelldatum");

        fld_cart_date.setText("//");
        fld_cart_date.addCaretListener(this::fld_cart_dateCaretUpdate);
        fld_cart_date.addActionListener(this::fld_cart_dateActionPerformed);

        lbl_cart_note.setText("Bestellhinweis");

        tarea_cart_note.setColumns(20);
        tarea_cart_note.setRows(5);
        scrl_tarea_cart_note.setViewportView(tarea_cart_note);

        btn_cart.setText("Bestellung erstellen");
        btn_cart.addActionListener(this::btn_cartActionPerformed);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cart_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_cart_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fld_cart_date)
                    .addComponent(lbl_cart_note, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrl_tarea_cart_note, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(btn_cart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cart_title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_customer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_cart_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_cart_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_cart_note, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrl_tarea_cart_note, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    private void dateCalculator(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fld_cart_date.setText(formatter.format(LocalDate.now()));
    }
    
    
    private void fld_cart_dateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fld_cart_dateCaretUpdate
    }//GEN-LAST:event_fld_cart_dateCaretUpdate

    private void fld_cart_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_cart_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_cart_dateActionPerformed

    private void btn_cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cartActionPerformed
        if(Helper.isFieldEmpty(this.fld_cart_date)){
            Helper.showMsg("fill");
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); ;
            for(Basket basket : this.baskets){
                if(basket.getProduct().getStock() <=0) continue;
                Cart cart = new Cart();
                cart.setCustomerId(this.customer.getId());
                cart.setProductId(basket.getProduct_id());
                cart.setPrice( basket.getProduct().getPrice()); 
                cart.setDate(LocalDate.parse(this.fld_cart_date.getText(), formatter));
                cart.setNote(this.tarea_cart_note.getText());
                this.cartController.save(cart);
                
                Product unStockProduct = basket.getProduct();
                unStockProduct.setStock(unStockProduct.getStock()-1);
                this.productController.update(unStockProduct);
            }
            this.basketController.clear();
            Helper.showMsg("done");
            dispose();
        }
        
    }//GEN-LAST:event_btn_cartActionPerformed
    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new CartUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cart;
    private javax.swing.JPanel container;
    private javax.swing.JTextField fld_cart_date;
    private javax.swing.JLabel lbl_cart_date;
    private javax.swing.JLabel lbl_cart_note;
    private javax.swing.JLabel lbl_cart_title;
    private javax.swing.JLabel lbl_customer;
    private javax.swing.JScrollPane scrl_tarea_cart_note;
    private javax.swing.JTextArea tarea_cart_note;
    // End of variables declaration//GEN-END:variables
}
