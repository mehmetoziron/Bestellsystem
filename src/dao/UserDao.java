package dao;

import core.Database;
import entity.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    private Connection connection;

    public UserDao() {
        this.connection = Database.getInstance();
    }

    public User findByLogin(String email, String password) {
        User user = null;
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = match(rs);
            }

        } catch (SQLException ex) {
            System.getLogger(UserDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return user;
    }
    
    public ArrayList<User> findAll(){
        ArrayList<User> users = new ArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM user");
            while (rs.next()){ 
                users.add(match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(UserDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return users;
    }
    public boolean save(User user) {
        try {
            
            String query = "INSERT INTO user "
                    + "("
                    + "name,"
                    + "email,"
                    + "password"
                    + ")"
                    + "VALUES (?,?,?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, user.getName());
            pr.setString(2, user.getEmail());
            pr.setString(3, user.getPassword()); 
            //System.out.println(pr);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(UserDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }

    public User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        return user;
    }

}
