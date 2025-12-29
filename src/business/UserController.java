package business;

import core.Helper;
import dao.UserDao;
import entity.User;

public class UserController {

    private final UserDao userDao = new UserDao();

    public User findByLogin(String email, String password) {
        if(!Helper.isEmailValid(email)) return null;
        return this.userDao.findByLogin(email, password);
        
    }
}
