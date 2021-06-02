package edu.iselab.grocery.features.managecarts;

import edu.iselab.grocery.database.AbstractDatabase;
import edu.iselab.grocery.database.SQLDatabase;
import edu.iselab.grocery.features.manageproducts.Product;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class CartRepository extends AbstractDatabase<Cart> {

    private static CartRepository instance;

    public static CartRepository getInstance() {

        if (instance == null) {
            instance = new CartRepository();
        }

        return instance;
    }

    public void save(Cart order) {

        super.save(order);

//        for(Item item : order.getItems()){
//            super.save(item);
//        }
    }

    public Product findById(Long id) {
        return (Product) super.findById(Product.class, id);
    }

    public List<Product> findByDescription(String term) {

        Session session = SQLDatabase.getInstance().openSession();

        String hql = "from Product c where lower(c.description) LIKE lower(:term)";

        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        query.setParameter("term", "%" + term + "%");

        return query.getResultList();
    }

    public List<Cart> findAll(){

        Session session = SQLDatabase.getInstance().openSession();

        return session.createQuery("SELECT a FROM Cart a", Cart.class).getResultList();
    }
}
