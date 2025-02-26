package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testConstructorAndGetters() {
    
        Product product = new Product("Xbox One S", 299.99f, 10, "Electronics");
        
        // Verificamos los setters
        assertEquals("Xbox One S", product.getName(), "El nombre debe ser 'Xbox One S'");
        assertEquals(299.99f, product.getPrice(), "El precio debe ser 299.99");
        assertEquals(10, product.getStockAmount(), "El stock debe ser 10");
        assertEquals("Electronics", product.getCategory(), "La categoría debe ser 'Electronics'");
    }
}
