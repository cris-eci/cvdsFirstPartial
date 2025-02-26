package edu.eci.cvds.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductsApplication {
    public static void main(String[] args) {
        // Inicia el contexto de Spring Boot
        ApplicationContext context = SpringApplication.run(ProductsApplication.class, args);
        
        // Se obtienen los beans necesarios
        ProductManager manager = context.getBean(ProductManager.class);
        LogAgent logAgent = context.getBean(LogAgent.class);
        WarningAgent warningAgent = context.getBean(WarningAgent.class);
        
        // Registrar los observadores
        manager.addObserver(logAgent);
        manager.addObserver(warningAgent);
        

        // Crear un producto y añadirlo al gestor
        Product product = new Product("xbox one s", 1000, 1000, "Electronics");
        manager.addProduct(product);
        System.out.println("\n\n\nProducto creado: " + product.getName());
        
        // Modificar el stock del producto para que se active el WarningAgent
        System.out.println("---------------------- Modificando el stock del producto... ------------");
        manager.updateStock(product.getName(), 5000);
        manager.updateStock(product.getName(), 3);        
        manager.updateStock(product.getName(), 4);
    }
}
