package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    // Creamos un observador para verificar la notificación.
    class DummyObserver implements StockObserver {
        boolean notified = false;
        Product notifiedProduct = null;
        
        @Override
        public void update(Product product) {
            notified = true;
            notifiedProduct = product;
        }
    }
    
    @Test
    public void testUpdateStockNotifiesObserversAndUpdatesProduct() {
        // Instanciamos el ProductManager y creamos un producto
        ProductManager pm = new ProductManager();
        Product product = new Product("Test Product", 10.0f, 10, "Test Category");
        pm.addProduct(product);
        
        // Agregamos un observador de prueba para capturar la notificación
        DummyObserver observer = new DummyObserver();
        pm.addObserver(observer);
        
        // Actualizamos el stock del producto a 5
        pm.updateStock("Test Product", 5);
        
        // Verificamos que el stock del producto se haya actualizado correctamente
        assertEquals(5, product.getStockAmount(), "El stock del producto debe actualizarse a 5");
        
        // Verificamos que el observador fue notificado
        assertTrue(observer.notified, "El observador debe ser notificado al actualizar el stock");
        assertNotNull(observer.notifiedProduct, "El producto notificado no debe ser null");
        assertEquals("Test Product", observer.notifiedProduct.getName(), "El nombre del producto notificado debe coincidir");
        assertEquals(5, observer.notifiedProduct.getStockAmount(), "El stock notificado debe ser 5");
    }
    
    @Test
    public void testRemoveObserverDoesNotNotify() {
        // Instanciamos el ProductManager y creamos un producto
        ProductManager pm = new ProductManager();
        Product product = new Product("Test Product", 10.0f, 10, "Test Category");
        pm.addProduct(product);
        
        // Creamos y agregamos un observador dummy
        DummyObserver observer = new DummyObserver();
        pm.addObserver(observer);
        
        // Removemos el observador
        pm.removeObserver(observer);
        
        // Actualizamos el stock y el observador no debería ser notificado
        pm.updateStock("Test Product", 5);
        
        // Verificamos que el observador no fue notificado
        assertFalse(observer.notified, "El observador no debe ser notificado después de haber sido removido");
    }
}
