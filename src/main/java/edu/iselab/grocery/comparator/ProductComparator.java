package edu.iselab.grocery.comparator;

import java.util.Comparator;

import edu.iselab.grocery.persistence.model.Product;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        if (o1.price > o2.price) {
            return 1;
        }

        if (o1.price < o2.price) {
            return -1;
        }

        return 0;
    }
}
