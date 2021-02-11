package edu.iselab.grocery.random;

public class ImplementAPublicInterface implements PublicInterface {

    public void getNsm() {
        System.out.println("Hello");
    }

    public int getS(int a, int b) {
           
        int sum = a + b;
        
        return sum;
    }
}
