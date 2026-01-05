
package bestellsystem;


import business.UserController;
import core.Database;
import core.Helper;
import entity.User;
import java.sql.Connection;
import view.DashboardUI;
import view.LoginUI;


public class Bestellsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Helper.setTheme();
        LoginUI loginUI = new LoginUI();
        //UserController userController = new UserController();
        //User user =  userController.findByLogin("m@g.com", "123123");
        //DashboardUI dashboardUI = new DashboardUI(user);
    }
    
}
