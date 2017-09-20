package TestServlet;

import org.json.simple.JSONArray;
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
    public  ArrayList<Product> FilterByPriceRange(String lowerBound, String upperBound){
        int lb = Integer.parseInt(lowerBound);
        int ub = Integer.parseInt(upperBound);
        ArrayList<Product> filtered_products = new ArrayList<Product>();
        for(int i = 0; i<products.getProductsBase().size(); i++){
           if(products.getProductsBase().get(i).getPrice() >lb && products.getProductsBase().get(i).getPrice() <ub ){
               filtered_products.add(products.getProductsBase().get(i));
           }
        }
        return filtered_products;
    }

    public JSONObject currentFilterToJSON(ArrayList<Product> obj){
        JSONObject jsonObject = new JSONObject();


        for(int i = 0; i<obj.size(); i++){
            JSONArray jsonArray = new JSONArray();
                jsonArray.add(obj.get(i).getArtist());
                jsonArray.add(obj.get(i).getAlbum());
                jsonArray.add(obj.get(i).getYear());
                jsonArray.add(obj.get(i).getCountry());
                jsonArray.add(obj.get(i).getGenre());
                jsonArray.add(obj.get(i).getPrice());
                jsonArray.add(obj.get(i).getAlbum_cover());
            System.out.println(jsonArray);
            jsonObject.put(i,jsonArray);
        }
        return jsonObject;
    }
}
