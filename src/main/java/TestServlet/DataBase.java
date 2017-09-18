package TestServlet;

import TestServlet.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {
    public DataBase() {

    }
//TODO temp storage
    private ArrayList<Product> productsBase = new ArrayList<Product>(Arrays.asList(
            new Product("Sergei", "15"),
            new Product("Ivan", "5"),
            new Product("Harry", "10"),
            new Product("Sam", "40"),
            new Product("Rodion", "30"),
            new Product("Alina", "20")
    ));


    public ArrayList<Product> getProductsBase() {
        return productsBase;
    }
}
