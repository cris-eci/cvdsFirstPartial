# First partial

# Creamos la estructura del proyecto con maven y Spring boot
![alt text](image.png)

# Diseño
Para el diseño se contemplara la implementación de el patrón TDD y el patrón observer. Esto con el objetivo de hacer que los dos agentes implementen la interfaz StockObserver y estén atentos a la actualización que occure en ProdcutManager con respecto a las modificaciónes de stock.

![alt text](image-1.png)

# Implementamos TDD para el desarrollo de la app. 

1. Dado que ya tenemos el diseño, implementamos las clases espejo test y a cada una vamos a crear el código mínimo de pruebas unitarias para que la prueba falle de acuerdo a TDD. 

## First enough test code

* LogAgent

![alt text](image-2.png)

* WarningAgent

![alt text](image-3.png)

* Product
![alt text](image-4.png)

* ProductManager
![alt text](image-5.png)

* ProductApplication
En este caso, dado que esta es la capa de interacción con el cliente, no la testeamos.

* StockObserver
Al ser una interfaz, no la testeamos

Al compilar, no hay problema
![alt text](image-6.png)

Pero al revisar los tests, veremos que no corren

![alt text](image-7.png)

# Now, production code to pass the test

