package edu.eci.cvds.products;

import org.springframework.stereotype.Component;

@Component
public class WarningAgent implements StockObserver {

    private boolean active = false;

    public boolean isActive() {
        return active;
    }

    @Override
    public void update(Product product) {
        if (product.getStockAmount() < 5) {
            System.out.println("ALERTA!!! El stock del Producto: " + product.getName() + " es muy bajo, solo quedan "
                    + product.getStockAmount() + " unidades");
            active = true;
        } else{
            active = false;
        }
    }
}
