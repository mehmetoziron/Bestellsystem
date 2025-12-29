package dao;

import core.Database;
import entity.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {

    private Connection connection;

    public CustomerDao() {
        this.connection = Database.getInstance();
    }

    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                customers.add(match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return customers;
    }

    public boolean save(Customer customer) {
        try {
            //String query = "INSERT INTO customer (name,type,phone,email,address) VALUES (?,?,?,?,?)";
            String query = "INSERT INTO customer "
                    + "("
                    + "name,"
                    + "type,"
                    + "phone,"
                    + "email,"
                    + "address"
                    + ")"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, customer.getName());
            pr.setString(2, customer.getType().toString());
            pr.setString(3, customer.getPhone());
            pr.setString(4, customer.getEmail());
            pr.setString(5, customer.getAddress());
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }

    public boolean update(Customer customer) {
        try {
            //"UPDATE customer SET `name` = ?, `type` = ?, `phone` = ?, `email` = ?, `address` = ? WHERE (`id` = ?)"; 
            String query = "UPDATE customer SET "
                    + "`name` = ?, "
                    + "`type` = ?, "
                    + "`phone` = ?, "
                    + "`email` = ?, "
                    + "`address` = ? "
                    + "WHERE (`id` = ?)";

            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, customer.getName());
            pr.setString(2, customer.getType().toString());
            pr.setString(3, customer.getPhone());
            pr.setString(4, customer.getEmail());
            pr.setString(5, customer.getAddress());
            pr.setInt(6, customer.getId());

            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM customer WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return true;
    }

    public ArrayList<Customer> query(String query) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                customers.add(this.match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return customers;
    }

    public Customer getById(int id) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                customer = this.match(rs);
            }
        } catch (SQLException ex) {
            System.getLogger(CustomerDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return customer;
    }

    public Customer match(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setPhone(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));
        customer.setAddress(rs.getString("address"));
        customer.setType(Customer.TYPE.valueOf(rs.getString("type")));
        return customer;
    }
}
