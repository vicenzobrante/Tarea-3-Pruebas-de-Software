package tarea3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reserva {
	public static Scanner input = new Scanner(System.in);
    public static List<String> reservas = new ArrayList<>();
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
        System.out.print("Ingrese la fecha de reserva (formato dd-mm-aaaa): ");
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
        System.out.print("Ingrese la nueva fecha de reserva (formato dd-mm-aaaa): ");
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
        System.out.println("Eliminar: ");
        Boolean flag = true;
        String fecha = "";
        String identificador ="";
        String codigo = "";
        int index_delete = -1;
        while (flag){
            System.out.print("Ingrese el código de la sala: ");
            codigo = input.nextLine();
            System.out.print("Ingrese el identificador del usuario: ");
            identificador = input.nextLine();
            System.out.print("Ingrese la fecha de reserva (formato dd-mm-aaaa): ");
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
}
