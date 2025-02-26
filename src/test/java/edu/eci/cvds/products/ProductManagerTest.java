package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    
    @Test
    public void testUpdateStockNotifiesObserversAndUpdatesProduct() {
        // Instanciamos el ProductManager y creamos un producto
        ProductManager pm = new ProductManager();
        Product product = new Product("Test Product", 10.0f, 10, "Test Category");
        pm.addProduct(product);
        // Actualizamos el stock del producto a 5
        pm.updateStock("Test Product", 5);
        
        // Verificamos que el stock del producto se haya actualizado correctamente
        assertEquals(5, product.getStockAmount(), "El stock del producto debe actualizarse a 5");
        
    }
}
