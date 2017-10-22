package TestServlet.service;

import TestServlet.dao.DataBase;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderBean implements Serializable {

    final static Logger logger = Logger.getLogger(OrderBean.class);

    private ItemQuantityPrice itemQuantityPrice;
    private ArrayList<ItemQuantityPrice> listOfItemQuantityPrice = new ArrayList<ItemQuantityPrice>();

    public ItemQuantityPrice getItemQuantityPrice() {
        return itemQuantityPrice;
    }

    public void setItemQuantityPrice(ItemQuantityPrice itemQuantityPrice) {
        this.itemQuantityPrice = itemQuantityPrice;
    }

    public ArrayList<ItemQuantityPrice> getListOfItemQuantityPrice() {
        return listOfItemQuantityPrice;
    }

    public void setListOfItemQuantityPrice(ArrayList<ItemQuantityPrice> listOfItemQuantityPrice) {
        this.listOfItemQuantityPrice = listOfItemQuantityPrice;
    }

    public OrderBean() {    }

    public ArrayList<ItemQuantityPrice> addListOfItemQuantityPrice(int productID) {
        logger.info("Adding product with ID = "+productID+" to list of IQP ");
        int qty;
        DataBase db = new DataBase();
        logger.info("Creating IQO object and set params to him ");
        itemQuantityPrice = new ItemQuantityPrice();
        itemQuantityPrice.setPrice(db.getProductsBase().get(productID).getPrice());
        itemQuantityPrice.setQuantity(1);
        itemQuantityPrice.setProduct(db.getProductsBase().get(productID));
        logger.info("Creating IQO object and set params to him ->Success! ");
        //--------------------------------------------------------------------------------
        if (isContain(listOfItemQuantityPrice, itemQuantityPrice)) {
            //TODO rewrite!
            for (ItemQuantityPrice aListOfItemQuantityPrice : listOfItemQuantityPrice) {
                if (aListOfItemQuantityPrice.getProduct().getId() == itemQuantityPrice.getProduct().getId()) {
                    qty = aListOfItemQuantityPrice.getQuantity();
                    qty++;
                    aListOfItemQuantityPrice.setQuantity(qty);
                    aListOfItemQuantityPrice.setPrice(sumOfProduct(aListOfItemQuantityPrice));
                }
            }
        } else  {
            listOfItemQuantityPrice.add(itemQuantityPrice);
        }
        logger.info("Product was added to the cart. Current cart size = "+ listOfItemQuantityPrice.size());
        return listOfItemQuantityPrice;
    }

    public int sumOfProduct(ItemQuantityPrice item) {
        logger.info("calculating the current sum of item in cart");
        int result = item.getProduct().getPrice() * item.getQuantity();
        return result;
    }

    public int sumOfCard(ArrayList<ItemQuantityPrice> list) {
        logger.info("calculating the current sum of cart");
        int totalCardCost = 0;
        for (int j = 0; j < list.size(); j++) {
            totalCardCost += list.get(j).getPrice();
        }
        return totalCardCost;
    }

    public boolean isContain(ArrayList<ItemQuantityPrice> list,ItemQuantityPrice item){

        if (list.isEmpty()) return false;
        else{
        for (int i=0;i<list.size();i++){
            System.out.println("check for non empty list "+list.get(i).getProduct().getId());
            System.out.println("item . non empty list "+item.getProduct().getId());
            if(list.get(i).getProduct().getAlbum().equals(item.getProduct().getAlbum()))return true;
        }
        return false;
    }
    }

}
