package edu.eci.cvds.products;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogAgentTest {

    @Autowired
    private LogAgent logAgent;
    
    @Test
    public void testActiveAfterUpdate() {
        
        Product product = new Product("Test Product", 100.0f, 50, "Test Category");
        
        
        logAgent.update(product);
        
        
        assertTrue(logAgent.isActive(), "LogAgent debe estar activo luego de llamar a update");
    }
}
