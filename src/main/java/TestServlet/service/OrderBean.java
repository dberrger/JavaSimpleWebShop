package TestServlet.service;

import TestServlet.dao.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderBean implements Serializable {
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
        int qty;
        DataBase db = new DataBase();

        itemQuantityPrice = new ItemQuantityPrice();
        itemQuantityPrice.setPrice(db.getProductsBase().get(productID).getPrice());
        itemQuantityPrice.setQuantity(1);
        itemQuantityPrice.setProduct(db.getProductsBase().get(productID));
        //--------------------------------------------------------------------------------
        if (isContain(listOfItemQuantityPrice, itemQuantityPrice)) {
            System.out.println("contains");
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
            System.out.println("not contains");
            listOfItemQuantityPrice.add(itemQuantityPrice);
        }
        System.out.println("ListOd I Q P: " + listOfItemQuantityPrice.size());
        return listOfItemQuantityPrice;
    }

    public int sumOfProduct(ItemQuantityPrice item) {
        int result = item.getProduct().getPrice() * item.getQuantity();
        return result;
    }

    public int sumOfCard(ArrayList<ItemQuantityPrice> list) {
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
