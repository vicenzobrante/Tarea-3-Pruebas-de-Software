package tarea3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static List<String> usuarios = new ArrayList<>();
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
                    Sala.ListaSala();
                    break;
                case "2":
                    Sala.CrearSala();
                    break;
                case "3":
                    Sala.EditarSala();
                    break;
                case "4":
                    Sala.EliminarSala();
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
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
                    Usuario.ListaUsuario(usuarios);
                    break;
                case "2":
                	Usuario.CrearUsuario(input,usuarios);
                    break;
                case "3":
                	Usuario.EditarUsuario(input,usuarios);
                    break;
                case "4":
                	Usuario.EliminarUsuario(input,usuarios);
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
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
                    Reserva.ListaReserva();
                    break;
                case "2":
                	Reserva.CrearReserva();
                    break;
                case "3":
                	Reserva.EditarReserva();
                    break;
                case "4":
                	Reserva.EliminarReserva();
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
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