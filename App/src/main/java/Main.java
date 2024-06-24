import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static List<String> salas = new ArrayList<>();
    public static List<String> usuarios = new ArrayList<>();
    public static List<String> reservas = new ArrayList<>();
    //Salas
    public static void menu_salas(){
        boolean flag = true;
        while (flag) {
            System.out.println("Menu de gestión de salas");
            System.out.println("Opciones:\n1.Ver Lista\n2.Crear\n3.Editar\n4.Eliminar\n5.Salir");
            System.out.print("Ingrese su elección: ");
            String opcion = input.nextLine();
            switch (opcion) {
                case "1":
                    ListaSala();
                    break;
                case "2":
                    CrearSala();
                    break;
                case "3":
                    EditarSala();
                    break;
                case "4":
                    EliminarSala();
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
    }

    public static String ListaSala(){
        System.out.println("Lista: ");
        for (int i = 0; i < salas.size(); i++){
            String[] data = salas.get(i).split(";");
            String out = String.format("Código: %1$s  Nombre: %2$s  Ubicación: %3$s",data[0],data[1],data[2]);
            System.out.println(out);
        }
        if (salas.isEmpty()){
            System.out.println("No hay salas registradas.");
        }
        return "Ok";

    }

    public static String CrearSala(){
        System.out.println("Crear: ");
        List<Integer> ids = new ArrayList<>();
        int codigo = 0;
        if (!salas.isEmpty()){
            for (int i = 0; i < salas.size(); i++){
                String[] data = salas.get(i).split(";");
                ids.add(Integer.parseInt(data[0]));
            }
            Collections.sort(ids);
            int last_codigo = ids.get(ids.size()-1);
            codigo = last_codigo + 1;
        }
        System.out.println("Ingrese el nombre de la sala: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese la ubicación de la sala: ");
        String ubicacion = input.nextLine();

        String data = String.format("%1$s;%2$s;%3$s",codigo,nombre,ubicacion);
        salas.add(data);
        return  "Sala creada exitosamente";
    }

    public static String EditarSala(){
        if (salas.isEmpty()){
            System.out.println("No hay salas registradas");
        }
        ListaSala();
        System.out.println("Editar: ");
        boolean flag = true;
        int index_replace = -1;
        String codigo = "";
        while (flag){
            System.out.print("Ingrese el código de la sala que quiere editar: ");
            codigo = input.nextLine();
            for (int i = 0;i < salas.size(); i++){
                String[] data = salas.get(i).split(";");
                if (data[0].contentEquals(codigo)){
                    index_replace = i;
                    flag = false;
                }
            }
            if (index_replace == -1){
                System.out.println("No existe una sala con ese codigo");
            }
        }

        System.out.print("Ingrese el nuevo nombre de la sala: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese la nueva ubicación de la sala: ");
        String ubicacion = input.nextLine();
        String sala_editada = String.format("%1$s;%2$s;%3$s",codigo,nombre,ubicacion);
        salas.set(index_replace, sala_editada);
        return "Sala editado exitosamente";
    }

    public static String EliminarSala(){
        if (salas.isEmpty()){
            System.out.println("No hay salas registradas");
        }
        ListaSala();
        System.out.println("Eliminar: ");
        boolean flag = true;
        int index_delete = -1;
        String codigo = "";
        while (flag){
            System.out.print("Ingrese el código de la sala que quiere eliminar: ");
            codigo = input.nextLine();
            for (int i = 0;i < salas.size(); i++){
                String[] data = salas.get(i).split(";");
                if (data[0].contentEquals(codigo)){
                    index_delete = i;
                    flag = false;
                }
            }
            if (index_delete == -1){
                System.out.println("No existe una sala con ese codigo");
            }
        }

        String sala_eliminada = salas.get(index_delete);
        salas.remove(sala_eliminada);
        return "Sala eliminada exitosamente";
    }


    //Usuarios
    public static void menu_usuarios(){

        Boolean flag = true;
        while (flag) {
            System.out.println("Menu de gestión de usuarios");
            System.out.println("Opciones:\n1.Ver Lista\n2.Crear\n3.Editar\n4.Eliminar\n5.Salir");
            System.out.print("Ingrese su elección: ");
            String opcion = input.nextLine();
            switch (opcion) {
                case "1":
                    ListaUsuario();
                    break;
                case "2":
                    CrearUsuario();
                    break;
                case "3":
                    EditarUsuario();
                    break;
                case "4":
                    EliminarUsuario();
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
    }

    public static String ListaUsuario(){
        System.out.println("Lista: ");
        for (int i = 0; i < usuarios.size(); i++){
            String[] data = usuarios.get(i).split(";");
            String out = String.format("Identificador: %1$s  Nombre: %2$s  Departamento: %3$s  Descripción: %4$s",data[0],data[1],data[2],data[3]);
            System.out.println(out);
        }
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        }
        return "Ok";

    }

    public static String CrearUsuario(){
        System.out.println("Crear: ");
        List<Integer> ids = new ArrayList<>();
        int identificador = 0;
        if (!usuarios.isEmpty()){
            for (int i = 0; i < usuarios.size(); i++){
                String[] data = usuarios.get(i).split(";");
                ids.add(Integer.parseInt(data[0]));
            }
            Collections.sort(ids);
            int last_codigo = ids.get(ids.size()-1);
           identificador = last_codigo + 1;
        }
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese el departamento del usuario: ");
        String departamento = input.nextLine();
        System.out.print("Ingrese la descripción del usuario: ");
        String descripcion = input.nextLine();

        String data = String.format("%1$s;%2$s;%3$s;%4$s",identificador,nombre,departamento,descripcion);
        usuarios.add(data);
        return  "Usuario creado exitosamente";
    }

    public static String EditarUsuario(){
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados");
            return "No hay usuarios";
        }
        ListaUsuario();
        System.out.println("Editar: ");
        boolean flag = true;
        int index_replace = -1;
        String identificador = "";
        while (flag){
            System.out.print("Ingrese el identificador del usuario que quiere editar: ");
            identificador = input.nextLine();
            for (int i = 0;i < usuarios.size(); i++){
                String[] data = usuarios.get(i).split(";");
                if (data[0].contentEquals(identificador)){
                    index_replace = i;
                    flag = false;
                }
            }
            if (index_replace == -1){
                System.out.println("No existe un usuario con ese identificador");
            }
        }

        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese el departamento del usuario: ");
        String departamento = input.nextLine();
        System.out.print("Ingrese la descripción del usuario: ");
        String descripcion = input.nextLine();

        String usuario_editado = String.format("%1$s;%2$s;%3$s;%4$s",identificador,nombre,departamento,descripcion);
        usuarios.set(index_replace, usuario_editado);
        return "Usuario editado exitosamente";
    }

    public static String EliminarUsuario(){
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados");
            return "No hay usuarios";
        }
        ListaUsuario();
        System.out.println("Eliminar: ");
        boolean flag = true;
        int index_delete = -1;
        String identificador = "";
        while (flag){
            System.out.print("Ingrese el identificador de usuario que quiere eliminar: ");
            identificador = input.nextLine();
            for (int i = 0;i < usuarios.size(); i++){
                String[] data = usuarios.get(i).split(";");
                if (data[0].contentEquals(identificador)){
                    index_delete = i;
                    flag = false;
                }
            }
            if (index_delete == -1){
                System.out.println("No existe una usuario con ese identificador");
            }
        }

        String usuario_eliminado = usuarios.get(index_delete);
        usuarios.remove(usuario_eliminado);
        return "Usuario eliminado exitosamente";
    }

    //Reservas
    public static void menu_reservas(){
        boolean flag = true;
        while (flag) {
            System.out.println("Menu de gestión de reservas");
            System.out.println("Opciones:\n1.Ver Lista\n2.Crear\n3.Editar\n4.Eliminar\n5.Salir");
            System.out.print("Ingrese su elección: ");
            String opcion = input.nextLine();
            switch (opcion) {
                case "1":
                    ListaReserva();
                    break;
                case "2":
                    CrearReserva();
                    break;
                case "3":
                    EditarReserva();
                    break;
                case "4":
                    EliminarReserva();
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
    }

    public static String ListaReserva(){
        System.out.println("Lista: ");
        for (int i = 0; i < reservas.size(); i++){
            String[] data = reservas.get(i).split(";");
            String out = String.format("Sala: %1$s  Usuario: %2$s  Fecha: %3$s  Detalle: %4$s",data[0],data[1],data[2],data[3]);
            System.out.println(out);
        }
        if (reservas.isEmpty()){
            System.out.println("No hay reservas registradas.");
        }
        return "Ok";

    }

    public static String CrearReserva(){
        System.out.println("Crear: ");
        System.out.print("Ingrese el código de la sala: ");
        String codigo = input.nextLine();
        System.out.print("Ingrese el identificador del usuario: ");
        String identificador = input.nextLine();
        System.out.print("Ingrese la fecha de reserva (formato dd-mm-aa): ");
        String fecha = input.nextLine();
        System.out.print("Ingrese el detalle de la reserva: ");
        String detalle = input.nextLine();

        String data = String.format("%1$s;%2$s;%3$s;%4$s",codigo,identificador,fecha,detalle);
        reservas.add(data);
        return  "Reserva creada exitosamente";
    }

    public static String EditarReserva(){
        if (reservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return "No hay reservas";
        }
        ListaReserva();
        System.out.println("Editar: ");
        Boolean flag = true;
        int index_replace = -1;
        String fecha = "";
        String identificador ="";
        String codigo = "";
        while (flag){
            System.out.print("Ingrese el código de la sala: ");
            codigo = input.nextLine();
            System.out.print("Ingrese el identificador del usuario: ");
            identificador = input.nextLine();
            System.out.print("Ingrese la fecha de reserva: ");
            fecha = input.nextLine();
            for (int i = 0;i < reservas.size(); i++){
                String[] data = reservas.get(i).split(";");
                if (data[0].contentEquals(codigo) && data[1].contentEquals(identificador) && data[2].contentEquals(fecha)){
                    index_replace = i;
                    flag = false;
                }
            }
            if (index_replace == -1){
                System.out.println("No existe un reserva con esos datos");
            }
        }
        System.out.print("Ingrese el nuevo código de la sala: ");
        codigo = input.nextLine();
        System.out.print("Ingrese el nuevo identificador del usuario: ");
        identificador = input.nextLine();
        System.out.print("Ingrese la nueva fecha de reserva (formato dd-mm-aa): ");
        fecha = input.nextLine();
        System.out.print("Ingrese el nuevo detalle de la reserva: ");
        String detalle = input.nextLine();

        String reserva_editada = String.format("%1$s;%2$s;%3$s;%4$s",codigo,identificador,fecha,detalle);
        reservas.set(index_replace, reserva_editada);
        return "Reserva editada exitosamente";
    }

    public static String EliminarReserva(){
        if (reservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return "No hay reservas";
        }
        ListaReserva();
        System.out.println("Editar: ");
        Boolean flag = true;
        int index_replace = -1;
        String fecha = "";
        String identificador ="";
        String codigo = "";
        int index_delete = -1;
        while (flag){
            System.out.print("Ingrese el código de la sala: ");
            codigo = input.nextLine();
            System.out.print("Ingrese el identificador del usuario: ");
            identificador = input.nextLine();
            System.out.print("Ingrese la fecha de reserva: ");
            fecha = input.nextLine();
            for (int i = 0;i < reservas.size(); i++){
                String[] data = reservas.get(i).split(";");
                if (data[0].contentEquals(codigo) && data[1].contentEquals(identificador) && data[2].contentEquals(fecha)){
                    index_delete = i;
                    flag = false;
                }
            }
            if (index_delete == -1){
                System.out.println("No existe una usuario con ese identificador");
            }
        }

        String reserva_eliminada = reservas.get(index_delete);
        reservas.remove(reserva_eliminada);
        return "Reserva eliminada exitosamente";
    }


    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión");
        boolean flag = true;
        while (flag){
            System.out.println("Menu Principal");
            System.out.println("Opciones:\n1.Salas\n2.Usuarios\n3.Reservas\n4.Salir");
            System.out.print("Ingrese su elección: ");
            String opcion = input.nextLine();
            switch (opcion){
                case "1":
                    menu_salas();
                    break;
                case "2":
                    menu_usuarios();
                    break;
                case "3":
                    menu_reservas();
                    break;
                case "4":
                    flag = false;
                    break;
            }
        }

    }
}