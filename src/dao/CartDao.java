 
package dao;

import java.sql.Connection;
import core.Database;
import entity.Cart; 
import entity.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author OZIRON GAMING
 */
public class CartDao {
     private Connection connection;
     private CustomerDao customerDao; 
     private ProductDao productDao;

    public CartDao() {
        this.connection = Database.getInstance();
        this.customerDao = new CustomerDao();
        this.productDao = new ProductDao();
    }
    
      public ArrayList<Cart> findAll() {
        ArrayList<Cart> carts = new ArrayList<>();
        ResultSet rs;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM cart");
            while (rs.next()) {
                carts.add(match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(CartDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return carts;

    }
      public boolean save(Cart cart) {
        try {
            //String query = "INSERT INTO cart ("customer_id",...) VALUES (?,...)";
            String query = "INSERT INTO cart "
                    + "("
                    + "customer_id,"
                    + "product_id,"
                    + "price,"
                    + "quantity,"
                    + "date,"
                    + "note"
                    + ")"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, cart.getCustomerId());
            pr.setInt(2, cart.getProductId());
            pr.setInt(3, cart.getPrice());
            pr.setInt(4, cart.getQuantity());
            pr.setDate(5, Date.valueOf(cart.getDate()));
            pr.setString(6, cart.getNote());
            //System.out.println(pr);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(CartDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }
      
      private Cart match(ResultSet rs) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getInt("id"));
        cart.setCustomerId(rs.getInt("customer_id"));
        cart.setProductId(rs.getInt("product_id"));
        cart.setPrice(rs.getInt("price"));
        cart.setQuantity(rs.getInt("quantity"));
        cart.setNote(rs.getString("note"));
        cart.setDate(LocalDate.parse(rs.getString("date")));
        cart.setCustomer(this.customerDao.getById(cart.getCustomerId()));
        cart.setProduct(this.productDao.getById(cart.getProductId()));
        cart.toString();
        return cart;
    }
}