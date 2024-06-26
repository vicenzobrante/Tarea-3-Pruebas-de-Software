package tarea3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sala {
	public static Scanner input = new Scanner(System.in);
	public static List<String> salas = new ArrayList<>();
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
}
