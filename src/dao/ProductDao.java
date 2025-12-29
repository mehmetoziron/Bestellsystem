package dao;

import core.Database;
import entity.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDao {

    private Connection connection;

    public ProductDao() {
        this.connection = Database.getInstance();
    }

    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        ResultSet rs;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM product");
            while (rs.next()) {
                products.add(match(rs));
            }
        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return products;

    }

    public Product getById(int id) {
        Product product = new Product();

        //sql query, conn , res
        String query = "SELECT * FROM product WHERE id = ?";

        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                product = this.match(rs);
            }

        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return product;
    }

    public boolean save(Product product) {
        try {
            //String query = "INSERT INTO product (name,code,price,stock) VALUES (?,?,?,?)";
            String query = "INSERT INTO product "
                    + "("
                    + "name,"
                    + "code,"
                    + "price,"
                    + "stock"
                    + ")"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, product.getName());
            pr.setString(2, product.getCode());
            pr.setInt(3, product.getPrice());
            pr.setInt(4, product.getStock());
            System.out.println(pr);
            return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return true;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM product WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        return false;
        }
    }

    public boolean update(Product product) {
        try {
            //"UPDATE product SET `name` = ?, `code` = ?, `price` = ?, `stock` = ? WHERE (`id` = ?)"; 
            String query = "UPDATE product SET "
                    + "`name` = ?, "
                    + "`code` = ?, "
                    + "`price` = ?, "
                    + "`stock` = ? "
                    + "WHERE (`id` = ?)";
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, product.getName());
            pr.setString(2, product.getCode());
            pr.setInt(3, product.getPrice());
            pr.setInt(4, product.getStock());
            pr.setInt(5, product.getId());
            return pr.executeUpdate()!= -1;
        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        return false;
        }
    }

    private Product match(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setCode(rs.getString("code"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.toString();
        return product;
    }

}
