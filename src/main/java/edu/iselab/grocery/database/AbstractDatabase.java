package edu.iselab.grocery.database;

import edu.iselab.grocery.features.manageproducts.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractDatabase<T extends AbstractModel> {

    public Object findById(Class<?> cls, Long id) {

        Session session = SQLDatabase.getInstance().openSession();

        return session.get(cls, id);
    }

    public void save(Object item) {

        Session session = SQLDatabase.getInstance().openSession();

        Transaction transaction  = session.beginTransaction();

        session.saveOrUpdate(item);

        transaction.commit();
    }

    public List<?> findAll(){

        Session session = SQLDatabase.getInstance().openSession();

        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }
}
