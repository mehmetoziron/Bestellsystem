package view;

import business.CustomerController;
import core.Helper;
import entity.Customer;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class CustomerUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerUI.class.getName());

    private Customer customer;
    private CustomerController customerController;

    public CustomerUI(Customer customer) {
        initComponents();
        setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.customer = customer;
        this.customerController = new CustomerController();
        this.add(container);
        this.setTitle("Kunde hinzufügen");
        this.setSize(400, 600);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);
        this.setVisible(true);

        this.cmb_customer_type.setModel(new DefaultComboBoxModel<>(Customer.TYPE.values()));

        if (this.customer.getId() == 0) {
            this.lbl_title.setText("Kunde hinzufügen");
        } else {
            this.lbl_title.setText("Kunde bearbeiten");
            this.fld_customer_name.setText(this.customer.getName());
            this.cmb_customer_type/*.getModel()*/.setSelectedItem(this.customer.getType());
            this.fld_customer_phone.setText(this.customer.getPhone());
            this.fld_customer_email.setText(this.customer.getEmail());
            this.tarea_customer_address.setText(this.customer.getAddress());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        lbl_customer_name = new javax.swing.JLabel();
        fld_customer_name = new javax.swing.JTextField();
        lbl_customer_type = new javax.swing.JLabel();
        cmb_customer_type = new javax.swing.JComboBox<>();
        lbl_customer_phone = new javax.swing.JLabel();
        fld_customer_phone = new javax.swing.JTextField();
        lbl_customer_email = new javax.swing.JLabel();
        fld_customer_email = new javax.swing.JTextField();
        lbl_customer_address = new javax.swing.JLabel();
        tarea_scroll_address = new javax.swing.JScrollPane();
        tarea_customer_address = new javax.swing.JTextArea();
        btn_customer_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        container.setMinimumSize(new java.awt.Dimension(100, 500));

        lbl_title.setText("jLabel1");

        lbl_customer_name.setText("Kundenname");

        fld_customer_name.addActionListener(this::fld_customer_nameActionPerformed);

        lbl_customer_type.setText("Kundentyp");

        cmb_customer_type.setModel(new javax.swing.DefaultComboBoxModel<>(Customer.TYPE.values()));

        lbl_customer_phone.setText("Telefonnummer");

        fld_customer_phone.setText("+");

        lbl_customer_email.setText("E-mail");

        lbl_customer_address.setText("Adresse");

        tarea_customer_address.setColumns(20);
        tarea_customer_address.setRows(5);
        tarea_scroll_address.setViewportView(tarea_customer_address);

        btn_customer_save.setText("Speichern");
        btn_customer_save.addActionListener(this::btn_customer_saveActionPerformed);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fld_customer_name)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_customer_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_customer_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_customer_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fld_customer_phone)
                    .addComponent(lbl_customer_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fld_customer_email)
                    .addComponent(lbl_customer_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tarea_scroll_address, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btn_customer_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_customer_type, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_customer_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_customer_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_customer_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tarea_scroll_address, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_customer_save, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fld_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_customer_nameActionPerformed

    private void btn_customer_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer_saveActionPerformed
        JTextField[] checkList = {this.fld_customer_name, this.fld_customer_phone};

        if (Helper.isFieldListHaveAEmpty(checkList)) {
            Helper.showMsg("fill");
        }else if(!Helper.isFieldEmpty(this.fld_customer_email) && !Helper.isEmailValid(this.fld_customer_email.getText())){
            Helper.showMsg("Bitte geben Sie eine gültige E-Mail-Adresse ein.");
        } else{
            boolean result = false;
            this.customer.setName(this.fld_customer_name.getText());
            this.customer.setPhone(this.fld_customer_phone.getText());
            this.customer.setEmail(this.fld_customer_email.getText());
            this.customer.setAddress(this.tarea_customer_address.getText());
            this.customer.setType((Customer.TYPE) this.cmb_customer_type.getSelectedItem());
            
            if (this.customer.getId() == 0){
                result = this.customerController.save(this.customer);
            }else{
                result = this.customerController.update(this.customer);
            }
            
            if(result){
                Helper.showMsg("done");
                dispose(); 
            }else{
                Helper.showMsg("error");
            }
            
        }
    }//GEN-LAST:event_btn_customer_saveActionPerformed

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
        //java.awt.EventQueue.invokeLater(() -> new CustomerUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_customer_save;
    private javax.swing.JComboBox<Customer.TYPE> cmb_customer_type;
    private javax.swing.JPanel container;
    private javax.swing.JTextField fld_customer_email;
    private javax.swing.JTextField fld_customer_name;
    private javax.swing.JTextField fld_customer_phone;
    private javax.swing.JLabel lbl_customer_address;
    private javax.swing.JLabel lbl_customer_email;
    private javax.swing.JLabel lbl_customer_name;
    private javax.swing.JLabel lbl_customer_phone;
    private javax.swing.JLabel lbl_customer_type;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextArea tarea_customer_address;
    private javax.swing.JScrollPane tarea_scroll_address;
    // End of variables declaration//GEN-END:variables
}
