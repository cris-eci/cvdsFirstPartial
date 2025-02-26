package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WarningAgentTest {

    @Autowired
    private WarningAgent warningAgent;

    @Test
    public void testWarningAgentActiveWhenStockLow() {
        // Crear un producto con stock < 5 (por ejemplo, 4)
        Product product = new Product("Test Product", 50.0f, 4, "Test Category");

        warningAgent.update(product);
        
        // Verificar que el WarningAgent se active (active = true)
        assertTrue(warningAgent.isActive(), "WarningAgent debe estar activo cuando el stock es menor a 5");
    }

    @Test
    public void testWarningAgentNotActiveWhenStockHigh() {
        // Crear un producto con stock alto (por ejemplo, 10000)
        Product product = new Product("Test Product", 50.0f, 10000, "Test Category");
        warningAgent.update(product);
        
        // Verificar que el WarningAgent no se active (active = false)
        assertEquals(false, warningAgent.isActive(), "WarningAgent no debe activarse cuando el stock es alto");
    }
}
