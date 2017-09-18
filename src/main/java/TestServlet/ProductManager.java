package TestServlet;

import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductManager implements Serializable {
    private DataBase products;

    public ProductManager() {
        products = new DataBase();
    }

    public DataBase getProducts() {

        return products;
    }

    public void setProducts(DataBase products) {
        this.products = products;
    }


    //TODO rework filter (+add another)
    public  ArrayList<Product> Filter(String s){
        int f = Integer.parseInt(s);
        ArrayList<Product> filted = new ArrayList<Product>();
        for(int i = 0; i<products.getProductsBase().size(); i++){
           if(Integer.parseInt(products.getProductsBase().get(i).getPrice()) > f ){
               filted.add(products.getProductsBase().get(i));
           }
        }
        return filted;
    }

    public JSONObject currentFilterToJSON(ArrayList<Product> obj){
        JSONObject jsonObject = new JSONObject();
        for(int i = 0; i<obj.size(); i++){
           jsonObject.put(i,obj.get(i).getBrandName());
        }
        return jsonObject;
    }
}
