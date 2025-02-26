# First partial

# Creamos la estructura del proyecto con maven y Spring boot
![alt text](image.png)

# Diseño
Para el diseño se contemplara la implementación de el patrón TDD y el patrón observer. Esto con el objetivo de hacer que los dos agentes implementen la interfaz StockObserver y estén atentos a la actualización que occure en ProdcutManager con respecto a las modificaciónes de stock.

### Patrón observer - elegido
Se eligió este patrón dado que el requerimiento funcional nos exige implementar dos agentes que esten a la espera de los cambios que acontecen en el stock. 

Este patrón se amolda a la perfección dado que podemos crear una interfaz que contenga el método core de la actualización, que en este caso será update, de acuerdo a el update que ocurra en ProductManager, cada uno de los agentes que se crearan como clases independientes, hará override de update, dado  que ambos implementan la interfaz StockObserver y harán lo que cada uno debe hacer. 

### Inyección de dependecias. 
La inyección se resolvio añadiendo @Component a las clases que las necesitaban con Spring boot, ademas que los métodos reciben por inyección las dependendias que necesitan.  

Como por ejemplo, si ProductManager necesita un producto, lo recibe como dependencia mediante inyección. 

![alt text](image-1.png)

# Implementamos TDD para el desarrollo de la app. 

1. Dado que ya tenemos el diseño, implementamos las clases espejo test y a cada una vamos a crear el código mínimo de pruebas unitarias para que la prueba falle de acuerdo a TDD. 

## First enough test code fail the test

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

* StockObserver
![alt text](image-8.png)

* Product
![alt text](image-9.png)
* WarningAgent
![alt text](image-12.png)
* LogAgent
![alt text](image-10.png)
* ProductManager

![alt text](image-13.png)
* ProductApplication
![alt text](image-11.png)

Ahora, si compilamos, todo estará ok 
![alt text](image-14.png)

Y cuando ejecutemos la pruebas, ahora si pasarán.
![alt text](image-15.png) 

Ahora vamos a configurar el Pom.xml para poder utilizar Jacoco y poder ver el estado actual de la cobertura. 

![alt text](image-16.png)

Hamemos un maven clean package
![alt text](image-17.png)
Como nos dimos cuenta, las pruebas aún no cumplen lo requerido
 Hacemos mvn clean test para generar el site de jacoco

![alt text](image-20.png)
 ![alt text](image-18.png)
 ![alt text](image-19.png)


### Refactor the test 
Ahora, refactorizamos las pruebas para poder hacer el cubrimiento requerido en los requerimientos.

Por poder terminar el parcial en su totalidad, el refactor de todas las pruebas queda en la versión definitiva del proyecto. 

Ahora volvemos a ejecutar mvn clean package, mvn clean test, generamos el reporte con Jacoco y nos daremos cuenta que la cobertura supera ampliamente la requerida. En este caso tenemos una  cobertura buena.
![alt text](image-21.png)
Despues del refactor las pruebas pasan
![alt text](image-22.png)

Cobertura nueva
![alt text](image-23.png)
![alt text](image-24.png)


# Bono
Dado que el profe ya había dicho, ya había credo cuenta con github en sonarcloud. Asi que nos registramos. 


Hacemos nuestro repo publico. 

![alt text](image-25.png)

Nos loggeamos en sonarcloud
![alt text](image-26.png)

Creamos una nueva organización
![alt text](image-27.png)
![alt text](image-28.png)
![alt text](image-29.png)
![alt text](image-30.png)

![alt text](image-31.png)

Creamos un toke de seguridad

![alt text](image-32.png)


![alt text](image-33.png)

Ejecutamos el comando de configuración en mvn para añadir el proyecto en donde tenemos que decir
* El origen que es sonnarcloud
* la organización
* la organization key
* y el token
![alt text](image-34.png)
Y listo

![alt text](image-35.png)
Como se puede ver, en sonarcloud se muestra la cobertura que la que había mostrado Jacoco.

![alt text](image-36.png)
![alt text](image-37.png)
# Cómo ejecutar la app
La app tiene un desarrollo bastante influencia a los servcios, como se nos enseñó. Por ello, la clase controladora es ProductsApplication, allí se hizo en la main la prueba de aceptación. 

![alt text](image-38.png)

Y los resultados, como indica el requerimiento, se muestra en consola de acuerdo a lo que debe pasar. Este enfoque permite desarrolla los controladores rest y conectar un cliente front. 

Para ejecutar solo se necesita escribir 
```bash
spring-boot:run
```

En la raíz del proyecto. 

Al ejecutar, queda así

![alt text](image-39.png)
![alt text](image-40.png)
![alt text](image-41.png)

