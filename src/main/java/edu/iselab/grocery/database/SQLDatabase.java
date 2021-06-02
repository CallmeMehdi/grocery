package edu.iselab.grocery.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SQLDatabase {

    private static SQLDatabase instance;

    public SessionFactory sessionFactory;

    public static SQLDatabase getInstance() {

        if (instance == null) {
            instance = new SQLDatabase();
        }

        return instance;
    }

    public void open() {

        if (this.sessionFactory == null) {
            this.sessionFactory = new Configuration().configure().buildSessionFactory();
        }
    }

    public void close() {

        if (this.sessionFactory != null) {
            sessionFactory.close();
        }

        this.sessionFactory = null;
    }

    public Session openSession(){
        return sessionFactory.openSession();
    }
}
