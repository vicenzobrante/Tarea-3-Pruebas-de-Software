package tarea3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    
	public static String ListaUsuario(List<String> usuarios){
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

    public static String CrearUsuario(Scanner input, List<String> usuarios){
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
        return  String.format("Usuario %1$s fue creado exitosamente",nombre);
    }

    public static String EditarUsuario(Scanner input,List<String> usuarios){
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados");
            return "No hay usuarios";
        }
        ListaUsuario(usuarios);
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

    public static String EliminarUsuario(Scanner input,List<String> usuarios){
        if (usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados");
            return "No hay usuarios";
        }
        ListaUsuario(usuarios);
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
}
