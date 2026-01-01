package business;

import core.Helper;
import dao.ProductDao;
import entity.Product;
import java.util.ArrayList;

public class ProductController {

    private ProductDao productDao = new ProductDao();

    public ArrayList<Product> findAll() {
        return productDao.findAll();
    }

    public Product getById(int id) {
        return productDao.getById(id);
    }

    public boolean save(Product product) {
        return productDao.save(product);
    }

    public boolean update(Product product) {
        return productDao.update(product);
    }

    public boolean delete(int id) {
        return productDao.delete(id);
    }

    public ArrayList<Product> filter(String name, String code, int stock) {
        //System.out.println(name + code + stock);
        String query = "SELECT * FROM product";

        ArrayList<String> whereList = new ArrayList<>();

        if (name.length() > 0) {
            whereList.add("name LIKE '%" + name + "%'");
        }
        if (code.length() > 0) {
            whereList.add("code LIKE '" + code + "%'");
        }
        if (stock == 2) {
            whereList.add("stock = 0");
        }
        if (stock == 1) {
            whereList.add("stock != 0");
        }
        if (whereList.size() > 0) {
            String whereQuery = String.join(" AND ", whereList);
            query += " WHERE " + whereQuery;
            System.out.println(query);
//            SELECT * FROM product WHERE name LIKE '%gitec%' AND code LIKE '12%' AND stock != 0
        }
        return productDao.query(query);
    }
}
