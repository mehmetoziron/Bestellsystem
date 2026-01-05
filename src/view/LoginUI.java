package view;

import business.UserController;
import core.Helper;
import entity.User;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginUI.class.getName());
    
    private UserController userController;

    public LoginUI() {
        initComponents();
        this.userController = new UserController();
        this.add(container);
        this.setTitle("Lager- und Kundenmanagementsystem");
        //this.setSize(500, 500);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        pnl_bottom = new javax.swing.JPanel();
        lbl_email = new javax.swing.JLabel();
        fld_email = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        fld_password = new javax.swing.JPasswordField();
        btn_register = new javax.swing.JButton();
        pnl_top = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("container");
        setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        container.setMinimumSize(new java.awt.Dimension(100, 100));
        container.setName("container"); // NOI18N
        container.setPreferredSize(new java.awt.Dimension(500, 500));

        lbl_email.setText("E-Mail");

        fld_email.setToolTipText("");
        fld_email.addActionListener(this::fld_emailActionPerformed);

        lbl_password.setText("Password");

        btn_login.setText("Anmelden");
        btn_login.addActionListener(this::btn_loginActionPerformed);

        btn_register.setText("Registrieren");
        btn_register.addActionListener(this::btn_registerActionPerformed);

        javax.swing.GroupLayout pnl_bottomLayout = new javax.swing.GroupLayout(pnl_bottom);
        pnl_bottom.setLayout(pnl_bottomLayout);
        pnl_bottomLayout.setHorizontalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bottomLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fld_password, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register)
                    .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_email, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_bottomLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_login, btn_register, fld_email, fld_password, lbl_email, lbl_password});

        pnl_bottomLayout.setVerticalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bottomLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_email, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_email, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_password, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fld_password, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_register)
                .addGap(105, 105, 105))
        );

        pnl_bottomLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_login, btn_register});

        pnl_top.setName("pnl_top"); // NOI18N

        lbl_title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Lager- und Kundenmanagementsystem");
        lbl_title.setToolTipText("");

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnl_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(container);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fld_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_emailActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        JTextField[] fields ={fld_email,fld_password};
        if(!Helper.isEmailValid(fld_email.getText())){
            Helper.showMsg("Bitte geben Sie eine gültige E-Mail-Adresse ein.");
        }
        else if ( Helper.isFieldListHaveAEmpty(fields) ) {
            Helper.showMsg("fill");
        }
        else{
            User user = this.userController.findByLogin(fld_email.getText(), fld_password.getText());
            if(user == null){
                Helper.showMsg("Es existiert kein solcher Benutzer.");
            }else{
                this.dispose();
                DashboardUI dashboardUI = new DashboardUI(user);
            } 
        }


    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        new RegisterUI();
    }//GEN-LAST:event_btn_registerActionPerformed

    public static void main(String args[]) {

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
        //java.awt.EventQueue.invokeLater(() -> new LoginUI().setVisible(true));
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JPanel container;
    private javax.swing.JTextField fld_email;
    private javax.swing.JPasswordField fld_password;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bottom;
    private javax.swing.JPanel pnl_top;
    // End of variables declaration//GEN-END:variables
}
