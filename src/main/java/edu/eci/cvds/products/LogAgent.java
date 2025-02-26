package edu.eci.cvds.products;

import org.springframework.stereotype.Component;

@Component
public class LogAgent implements StockObserver {
private boolean active = false; 


public boolean isActive() {
    return active;
}
@Override
public void update(Product product) {
    System.out.println( "Producto: " + product.getName() + " -> " + product.getStockAmount() + " unidades disponibles");
    active = true;
    }
}
