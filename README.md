# Tarea-3-Pruebas-de-Software

## Diseño del programa

El programa funciona a través de la línea de comandos, se maneja a través de menus para acceder a las opciones para gestionar salas, usuarios y reservas, cada una de estas tiene las opciones de crear, listar, editar y eliminar cualquiera de los datos registrados, los objetos (salas, usuarios y reservas) existen solo en memoria, o sea, los objetos solo existen cuando se ejecuta el programa, por lo que, si se cierra el programa se pierden los datos, cuando se requiere rellenar campos para editar o crear, si existe algun error o campo vacío el programa indicará que hay errores y pedirá que se vuelvan a escribir los atributos. 

## Detalles de ejecución

## Requisitos

[Java SDK](https://www.oracle.com/java/technologies/downloads/#jdk22-windows)

[Eclipse IDE](https://www.eclipse.org/downloads/)

## Instrucciones de ejecución de la aplicación

### Utilizando archivo App.jar

Si se desea ejecutar el programa utilizando el archivo App.jar se debe:

* Abrir terminal dentro del directorio donde se encuentra el archivo.
* Ingresar dentro de la terminal `java -jar App.jar`.

### Utilizando Eclipse IDE

Si se desea utilizar Eclipse IDE se debe:

* Abrir la aplicación Eclipse IDE.
* Seleccionar la opción de importar un proyecto.
* Seleccionar la carpeta App.
* Cuando se encuentre abierto el proyecto seleccionar la opción `Run as Java Application` o hacer click derecho en el archivo Main.java dentro de la carpeta `src/main/java/tarea3/` y seleccionar la opción `Run as Java Application`.

### Ejecutar los tests

Para ejecutar los tests se debe:

* Abrir la aplicación Eclipse IDE.
* Seleccionar la opción de importar un proyecto.
* Seleccionar la carpeta App.
* Cuando se encuentre abierto el proyecto seleccionar la opción hacer click derecho en el archivo UsuarioTest.java, SalaTest.java, ReservaTest.java dentro de la carpeta `src/test/java/tarea3/` y seleccionar la opción `Run as JUnit Test` utilizando JUnit 4.

## Resultado Pruebas unitarias



