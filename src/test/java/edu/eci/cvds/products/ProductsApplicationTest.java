package edu.eci.cvds.products;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductsApplicationTest {

    @Test
    public void testMainOutput() {
        // Capturar el System.out origina
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Invocar el métod main 
        ProductsApplication.main(new String[]{});
        
        // Restaurar el System.out original
        System.setOut(originalOut);
        
        // Obtener la salida como String
        String output = outContent.toString();
        
        // Verificar que la salida saliente sea correcta para crea
        assertTrue(output.contains("Producto creado: xbox one s"), 
                   "Debe imprimirse el mensaje de creación del producto");
    
    }
}
