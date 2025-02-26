package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testConstructorAndGetters() {
        
        Product product = new Product("Xbox One S", 299.99f, 10, "Electronics");
        
        // Verificamos getters
        assertEquals("Xbox One S", product.getName(), "El nombre debe ser 'Xbox One S'");
        assertEquals(299.99f, product.getPrice(), "El precio debe ser 299.99");
        assertEquals(10, product.getStockAmount(), "El stock debe ser 10");
        assertEquals("Electronics", product.getCategory(), "La categoría debe ser 'Electronics'");
    }
    
    @Test
    public void testSetters() {
        
        Product product = new Product("PlayStation 5", 499.99f, 5, "Gaming");
        
        // Verificamos setters
        product.setName("PlayStation 5 Digital Edition");
        product.setPrice(399.99f);
        product.setStockAmount(8);
        product.setCategory("Gaming Consoles");
        
        
        assertEquals("PlayStation 5 Digital Edition", product.getName(), "El nombre debe actualizarse correctamente");
        assertEquals(399.99f, product.getPrice(), "El precio debe actualizarse correctamente");
        assertEquals(8, product.getStockAmount(), "El stock debe actualizarse correctamente");
        assertEquals("Gaming Consoles", product.getCategory(), "La categoría debe actualizarse correctamente");
    }
}
