package TestServlet.dao;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    private String artist;
    private String album;
    private String year;
    private String country;
    private String genre;
    private int price;
    private String album_cover;

    private ArrayList<ProductInOrder> productInOrders;

    private DataBase dataBase;

    public DataBase getDataBase() {
        return dataBase;
    }

    public Product() {
    }

    public Product(String artist, String album, String year, String country, String genre, int price, String album_cover) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.price = price;
        this.album_cover = album_cover;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbum_cover() {
        return album_cover;
    }

    public void setAlbum_cover(String album_cover) {
        this.album_cover = album_cover;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public ArrayList<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(ArrayList<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }
}



