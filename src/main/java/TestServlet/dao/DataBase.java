package TestServlet.dao;

import TestServlet.service.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {
    final static Logger logger = Logger.getLogger(DataBase.class);
    public DataBase() {

    }
//TODO temp storage
    private ArrayList<Product> productsBase = new ArrayList<Product>(Arrays.asList(
            new Product("Linkin park", "Hybrid Theory", "2000","USA","Alternative rock",100,"1",0),
            new Product("Linkin park1", "Meteora", "2003","USA","Alternative rock",110,"2",1),
            new Product("Linkin park2", "Minutes to Midnight", "2007","USA","Alternative rock",90,"3",2),
            new Product("Linkin park3", "A Thousand Suns", "2010","USA","Alternative rock",120,"4",3),
            new Product("Linkin park4", "Living Things", "2012","USA","Alternative rock",130,"5",4),
            new Product("Linkin park5", "The Hunting Party", "2014","USA","Alternative rock",140,"6",5),
            new Product("Linkin park6", "One More Light", "2017","USA","Alternative rock",150,"7",6)

    ));


    public ArrayList<Product> getProductsBase() {
        logger.info("get all products from DB");
        return productsBase;
    }

    public Product getElementByID(int productID){

        if(productsBase.get(productID)!=null){
        return productsBase.get(productID);}
        else{
           return null;
        }
    }

}
