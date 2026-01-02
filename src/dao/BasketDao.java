package dao;

import core.Database;
import entity.Basket;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BasketDao {

    private Connection connection;
    private ProductDao productDao;

    public BasketDao() {
        this.connection = Database.getInstance();
        this.productDao = new ProductDao();
    }

    public ArrayList<Basket> findAll() {
        ArrayList<Basket> baskets = new ArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM basket");
            while (rs.next()) {
                baskets.add(match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return baskets;
    }

    public Basket getByProductID(int product_id) {
        Basket basket = new Basket();

        //sql query, conn , res
        String query = "SELECT * FROM basket WHERE product_id = ?";

        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, product_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                basket = this.match(rs);
            }

        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return basket;
    }

    public Basket getByID(int id) {
        Basket basket = new Basket();

        //sql query, conn , res
        String query = "SELECT * FROM basket WHERE id = ?";

        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                basket = this.match(rs);
            }

        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return basket;
    }
    
    public boolean save(Basket basket) {
        try {
            //String query = "INSERT INTO basket (product_id, quantity) VALUES (?,?)";
            String query = "INSERT INTO basket "
                    + "("
                    + "product_id,"
                    + "quantity"
                    + ")"
                    + "VALUES (?,?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, basket.getProduct_id());
            pr.setInt(2, basket.getQuantity());
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }
    public boolean update(Basket basket) {
        try {
            //"UPDATE basket SET `quantity` = ? WHERE (`id` = ?)"
            String query = "UPDATE basket SET " 
                    + "`quantity` = ? "
                    + "WHERE (`id` = ?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, basket.getQuantity());
            pr.setInt(2, basket.getId());
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }
    public boolean delete(int id) {
        String query = "DELETE FROM basket WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return true;
    }

    public boolean clear() {
        String query = "DELETE FROM basket";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(BasketDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return true;
    }

    public Basket match(ResultSet rs) throws SQLException {
        Basket basket = new Basket();
        basket.setId(rs.getInt("id"));
        basket.setProduct_id(rs.getInt("product_id"));
        basket.setQuantity(rs.getInt("quantity"));
        basket.setProduct(this.productDao.getById(rs.getInt("product_id")));
        return basket;
    }
}
