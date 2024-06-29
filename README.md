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
| Nombre | Función Relacionada | Inputs | Resultado Esperado | Resultado |
|---|---|---|---|---|
| testListaReserva() | Reserva.ListaReserva(reservas) | reservas.add("0;0;25-06-2024;Reunion")<br>reservas.add("1;0;25-06-2024;Conferencia") | "Ok" | "Ok" |
| testListaReserva_lista_vacia() | Reserva.ListaReserva(reservas_empty) | reservas_empty = [] | "Ok" | "Ok" |
| testCrearReserva() | Reserva.CrearReserva(input,reservas_create) | Mockito.when(input.nextLine()).thenReturn("0").thenReturn("0")<br>.thenReturn("25-06-2024").thenReturn("Conferencia"); | "Reserva creada exitosamente" | "Reserva creada exitosamente" |
| testCrearReserva_campos_vacios() | Reserva.CrearReserva(input,reservas_create) | Mockito.when(input.nextLine()).thenReturn("")<br>.thenReturn("").thenReturn("")<br>.thenReturn("").thenReturn("0").thenReturn("0")<br>.thenReturn("25-06-2024").thenReturn("Conferencia"); | "Reserva creada exitosamente" | "Reserva creada exitosamente" |
| testEditarReserva() | Reserva.EditarReserva(input, reservas_edit) | reservas_edit.add("0;0;24-06-2023;Reunion");<br>Mockito.when(input.nextLine()).thenReturn("0")<br>.thenReturn("0").thenReturn("24-06-2023")<br>.thenReturn("0").thenReturn("1")<br>.thenReturn("30-10-2023").thenReturn("Reunion del equipo"); | "Reserva editada exitosamente" | "Reserva editada exitosamente" |
| testEditarReserva_campos_vacios() | Reserva.EditarReserva(input, reservas_edit_2) | reservas_edit_2.add("0;0;24-06-2023;Reunion");<br>Mockito.when(input.nextLine())<br>.thenReturn("").thenReturn("")<br>.thenReturn("").thenReturn("0")<br>.thenReturn("0").thenReturn("24-06-2023")<br>.thenReturn("").thenReturn("")<br>.thenReturn("").thenReturn("").thenReturn("0")<br>.thenReturn("1").thenReturn("30-10-2023")<br>.thenReturn("Reunion del equipo"); | "Reserva editada exitosamente" | "Reserva editada exitosamente" |
| testEditarReserva_lista_vacia() | Reserva.EditarReserva(input, reservas_empty) | reservas_empty = [] | "No hay reservas" | "No hay reservas" |
| testEliminarReserva() | Reserva.EliminarReserva(input, reservas_delete) | reservas_delete.add("0;0;24-06-2023;Reunion");<br>reservas_delete.add("1;0;25-06-2024;Conferencia");<br>Mockito.when(input.nextLine()).thenReturn("0")<br>.thenReturn("0").thenReturn("24-06-2023"); | "Reserva eliminada exitosamente" | "Reserva eliminada exitosamente" |
| testEliminarReserva_lista_vacia() | Reserva.EliminarReserva(input, reservas_empty) | reservas_empty = [] | "No hay reservas" | "No hay reservas" |
| testEliminarReserva_campos_erroneos() | Reserva.EliminarReserva(input, reservas_delete_2) | reservas_delete_2.add("0;0;24-06-2023;Reunion");<br>reservas_delete_2.add("1;0;25-06-2024;Conferencia");<br>Mockito.when(input.nextLine()).thenReturn("0")<br>.thenReturn("1").thenReturn("24-06-2023"); | "No hay una reserva con esos datos" | "No hay una reserva con esos datos" |
| testListaSala() | Sala.ListaSala(salas) | salas.add("0;Sala 1;Piso 1");<br>salas.add("1;Sala 2;Piso 1"); | "Ok" | "Ok" |
| testListaSala_lista_vacia() | Sala.ListaSala(salas_empty) | salas_empty = []; | "Ok" | "Ok" |
| testCrearSala() | Sala.CrearSala(input,salas_create) | salas_create = [];<br>Mockito.when(input.nextLine()).thenReturn("Sala 1")<br>.thenReturn("Piso 1"); | "Sala creada con nombre Sala 1 exitosamente" | "Sala creada con nombre Sala 1 exitosamente" |
| testCrearSala_campos_vacios() | Sala.CrearSala(input,salas_create) | salas_create = [];<br>Mockito.when(input.nextLine()).thenReturn("")<br>.thenReturn("").thenReturn("Sala 1")<br>.thenReturn("Piso 1"); | "Sala creada con nombre Sala 1 exitosamente" | "Sala creada con nombre Sala 1 exitosamente" |
| testEditarSala() | Sala.EditarSala(input, salas_edit) | salas_edit.add("0;Sala 1;Piso 1");<br>salas_edit.add("1;Sala 2;Piso 1");<br>Mockito.when(input.nextLine())<br>.thenReturn("0").thenReturn("Sala 3")<br>.thenReturn("Piso 2"); | "Sala con código 0 editada exitosamente" | "Sala con código 0 editada exitosamente" |
| testEditarSala_campos_vacios() | Sala.EditarSala(input, salas_edit_2) | salas_edit_2.add("0;Sala 1;Piso 1");<br>salas_edit_2.add("1;Sala 2;Piso 1");<br>Mockito.when(input.nextLine())<br>.thenReturn("").thenReturn("0")<br>.thenReturn("Sala 3")<br>.thenReturn("Piso 2"); | "Sala con código 0 editada exitosamente" | "Sala con código 0 editada exitosamente" |
| testEditarSala_lista_vacia() | Sala.EditarSala(input, salas_empty) | salas_empty = []; | "No hay salas registradas" | "No hay salas registradas" |
| testEliminarSala() | Sala.EliminarSala(input, salas_delete) | salas_delete.add("0;Sala 1;Piso 1");<br>salas_delete.add("1;Sala 2;Piso 1");<br>Mockito.when(input.nextLine())<br>.thenReturn("0"); | "Sala eliminada exitosamente" | "Sala eliminada exitosamente" |
| testEliminarSala_lista_vacia() | Sala.EliminarSala(input, salas_empty) | salas_empty = []; | "No hay salas registradas" | "No hay salas registradas" |
| testEliminarSala_campos_erroneos() | Sala.EliminarSala(input, salas_delete_2) | salas_delete_2.add("0;Sala 1;Piso 1");<br>salas_delete_2.add("1;Sala 2;Piso 1");<br>Mockito.when(input.nextLine())<br>.thenReturn("").thenReturn("0"); | "No hay una sala con ese código" | "No hay una sala con ese código" |
| testListaUsuario() | Usuario.ListaUsuario(usuarios) | usuarios.add("0;TestUser;TestDepartamento;TestDescripcion"); | "Ok" | "Ok" |
| testListaUsuario_lista_vacia() | Usuario.ListaUsuario(usuarios_empty) | usuarios_empty = []; | "Ok" | "Ok" |
| testCrearUsuario() | Usuario.CrearUsuario(input,usuarios_create) | Mockito.when(input.nextLine())<br>.thenReturn("Test 1").thenReturn("Test 2").<br>thenReturn("Test 3"); | "Usuario Test 1 fue creado exitosamente" | "Usuario Test 1 fue creado exitosamente" |
| testCrearUsuario_campos_vacios() | Usuario.CrearUsuario(input,usuarios_create) | Mockito.when(input.nextLine())<br>.thenReturn("").thenReturn("")<br>.thenReturn("").thenReturn("Test 1")<br>.thenReturn("Test 2").thenReturn("Test 3"); | "Usuario Test 1 fue creado exitosamente" | "Usuario Test 1 fue creado exitosamente" |
| testEditarUsuario() | Usuario.EditarUsuario(input, usuarios_edit) | usuarios_edit.add("0;TestUser;TestDepartamento;TestDescripcion");<br>Mockito.when(input.nextLine()).thenReturn("0")<br>.thenReturn("TestModificado")<br>.thenReturn("DepartamentoModificado")<br>.thenReturn("DescripcionModificada"); | "Usuario 0 editado exitosamente" | "Usuario 0 editado exitosamente" |
| testEditarUsuario_campos_vacios() | Usuario.EditarUsuario(input, usuarios_edit_2) | usuarios_edit_2.add("0;TestUser2;TestDepartamento2;TestDescripcion2");<br>Mockito.when(input.nextLine()).thenReturn("0").thenReturn("")<br>.thenReturn("").thenReturn("").thenReturn("TestModificado")<br>.thenReturn("DepartamentoModificado").thenReturn("DescripcionModificada"); | "Usuario 0 editado exitosamente" | "Usuario 0 editado exitosamente" |
| testEditarUsuario_lista_vacia() | Usuario.EditarUsuario(input, usuarios_empty) | usuarios_empty = []; | "No hay usuarios" | "No hay usuarios" |
| testEliminarUsuario() | Usuario.EliminarUsuario(input, usuarios_delete) | usuarios_delete.add("0;TestUser;TestDepartamento;TestDescripcion");<br>usuarios_delete.add("1;TestUser2;TestDepartamento2;TestDescripcion2");<br>Mockito.when(input.nextLine()).thenReturn("0"); | "Usuario 0 eliminado exitosamente" | "Usuario 0 eliminado exitosamente" |
| testEliminarUsuario_campo_erroneo() | Usuario.EliminarUsuario(input, usuarios_delete_2) | usuarios_delete_2.add("0;TestUser;TestDepartamento;TestDescripcion");<br>usuarios_delete_2.add("1;TestUser2;TestDepartamento2;TestDescripcion2"); | Mockito.when(input.nextLine()).thenReturn("2"); | "No hay un usuario con ese identificador" |
| testEliminarUsuario_lista_vacia() | Usuario.EliminarUsuario(input, usuarios_empty) | usuarios_empty = []; | "No hay usuarios" | "No hay usuarios" |


