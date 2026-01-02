 
package business;
 
import dao.BasketDao;
import entity.Basket;
import java.util.ArrayList;

public class BasketController {
    private final BasketDao basketDao = new BasketDao();
    
    public ArrayList<Basket> findAll() {
        return this.basketDao.findAll();
    }
    
    public boolean save(Basket basket){
        return this.basketDao.save(basket);
    }
    
    public boolean update (Basket basket){
        return this.basketDao.update(basket);
    }
    
    public boolean delete (int id){
        return this.basketDao.delete(id);
    }
    
    public boolean clear (){
        return this.basketDao.clear();
    }
    
    public Basket getByProductID (int product_id){
        return this.basketDao.getByProductID(product_id);
    }
    
    public Basket getByID (int id){
        return this.basketDao.getByID(id);
    }
}
