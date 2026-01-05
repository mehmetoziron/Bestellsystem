package business;

import core.Helper;
import dao.UserDao;
import entity.User;
import java.util.ArrayList;

public class UserController {

    private final UserDao userDao = new UserDao();

    public User findByLogin(String email, String password) {
        if (!Helper.isEmailValid(email)) {
            return null;
        }
        return this.userDao.findByLogin(email, password);
    }

    public boolean save(User user) {
        if (Helper.EmailCheckOnList(userDao.findAll(), user.getEmail())) {
            Helper.showMsg("Sie haben bereits ein Konto.");
        } else {
            return userDao.save(user);
        }
        return false;
    }

    public ArrayList<User> findAll() {
        return userDao.findAll();
    }
}
