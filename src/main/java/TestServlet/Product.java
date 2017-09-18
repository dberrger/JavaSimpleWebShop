package TestServlet;

import java.io.Serializable;

public class Product implements Serializable{
    //TODO add +2-3 prod param
    private String brandName;
    private String price;
    private DataBase dataBase;

        public DataBase getDataBase() {
            return dataBase;
        }

        public Product(String brandName, String price) {
            this.brandName = brandName;
            this.price = price;
        }

        public Product(){}

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }



