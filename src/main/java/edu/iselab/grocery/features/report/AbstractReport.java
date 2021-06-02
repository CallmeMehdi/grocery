package edu.iselab.grocery.features.report;

import edu.iselab.grocery.features.managecarts.CartRepository;

public abstract class AbstractReport {

    public CartRepository cartRepository = CartRepository.getInstance();

    public abstract void execute();
}
