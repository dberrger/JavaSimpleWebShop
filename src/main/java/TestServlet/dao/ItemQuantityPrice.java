package TestServlet.dao;

public class ItemQuantityPrice {
    private Product product;
    private int quantity;
    private int price;

    public Product getProduct() {
        return product;
    }

    public ItemQuantityPrice() {

    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemQuantityPrice(Product product, int price,int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
}
