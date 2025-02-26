package edu.eci.cvds.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductManager {

    private List<Product> products = new ArrayList<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public void updateStock(String productName, int newStock) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setStockAmount(newStock);
                notifyObservers(product);
                break;
            }
        }
    }

    private void notifyObservers(Product product) {
        for (StockObserver observer : observers) {
            observer.update(product);
        }
    }

}
