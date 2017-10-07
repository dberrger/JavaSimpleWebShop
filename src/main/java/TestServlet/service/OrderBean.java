package TestServlet.service;

import TestServlet.dao.DataBase;
import TestServlet.dao.ItemQuantityPrice;
import TestServlet.dao.Order;
import TestServlet.dao.Product;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class OrderBean implements Serializable {
    private Order order;
    private OrdersManager ordersManager;
    private int quantity;
    private ItemQuantityPrice itemQuantityPrice;
    //TODO delete
    private ArrayList<Product> listOfProducts = new ArrayList<Product>();

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

    public OrderBean() {
    }

    public Order getOrder() {
        return order;
    }

    public OrderBean(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrdersManager getOrdersManager() {
        return ordersManager;
    }

    public void setOrdersManager(OrdersManager ordersManager) {
        this.ordersManager = ordersManager;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void createOrder() {
        if (order == null) {
            order = new Order();
        }
    }

    public ArrayList<Product> addProduct(int productID) {
        // ordersManager = new OrdersManager();
        //ordersManager.addToOrder(productID, order,1);
        System.out.println("HelloFrom OrderBEan addProduct.. productId is " + productID);


        ProductManager productManager = new ProductManager();
        DataBase db = new DataBase();
        listOfProducts.add(db.getProductsBase().get(productID));
        return listOfProducts;

    }

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
