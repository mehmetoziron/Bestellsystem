package core;

import entity.User;
import java.util.ArrayList;
import javax.swing.*;

public class Helper {

    public static void setTheme() {

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    System.getLogger(Helper.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                break;
            }
        }

    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListHaveAEmpty(JTextField[] fields) {
        for (JTextField field : fields) {
            if (isFieldEmpty(field)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmailValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            return false;
        }

        if (!parts[1].contains(".")) {
            return false;
        }

        return true;
    }
    public static boolean EmailCheckOnList(ArrayList<User>users ,String email){
        for(User user : users){
            if(user.getEmail().equals(email))
                return true;
        }
        
        return false;
    }

    public static void optionPaneDialogDE() {
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");
        UIManager.put("OptionPane.noButtonText", "Nein");
    }

    public static void showMsg(String message) {
        String msg;
        String title;
        switch (message) {
            case "fill":
                msg = "Bitte füllen Sie alle Felder aus.";
                title = "Fehler";
                break;
            case "done":
                msg = "Transaktion erfolgreich.";
                title = "Ergebnis";
                break;
            case "error":
                msg = "Es ist ein Fehler aufgetreten";
                title = "Fehler";
                break;
            default:
                msg = message;
                title = "Info";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str) {

        String msg;

        if (str.equals("sure")) {
            msg = "Sind Sie sicher, dass Sie diese Aktion ausführen möchten?";
        } else {
            msg = str;
        }

        return JOptionPane.showConfirmDialog(null, msg, "Sind Sie sicher?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static String formatDateInput(String str) {
        if(str.length() != 0){
            System.out.println("if");
            if(str.length()==2){ 
                System.out.println("ifif");
                str+="/";
            }
        }
        System.out.println(str);
        // Sadece rakamları al
        return str;
    }

}
