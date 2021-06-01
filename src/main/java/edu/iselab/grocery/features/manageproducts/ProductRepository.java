package edu.iselab.grocery.features.manageproducts;

import edu.iselab.grocery.database.AbstractDatabase;

public class ProductRepository extends AbstractDatabase<Product> {

    private static ProductRepository instance;

    public static ProductRepository getInstance() {

        if (instance == null) {
            instance = new ProductRepository();
        }

        return instance;
    }
}
