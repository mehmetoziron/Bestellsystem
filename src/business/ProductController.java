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

    public Product getById (int id){
        return productDao.getById(id);
    }
    
    public boolean save(Product product) {
        return productDao.save(product) ;
    }
    
    public boolean update(Product product) {
        return productDao.update(product);
    }
    
    public boolean delete(int id){
        return productDao.delete(id);
    }
}
