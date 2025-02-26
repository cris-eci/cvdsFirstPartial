package edu.eci.cvds.products;

public class Product {

    private String name;
    private float price;
    private int stockAmount;
    private String category;

    public Product(String name, float price, int stockAmount, String category)
    {
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
