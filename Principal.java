import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 05/03/2023
 * Clase principal donde el usuario interactua con el programa
 */

public class Principal{

    public static void main(String[] args){

        // Se crea el ArrayList que almacena todas las lineas del archivo
        ArrayList<String> lineasArchivo = new ArrayList<>();

        // Lee el archivo de texto y agrega todas las lineas al ArrayList anterior
        File file = new File("C:/Ejemplos/ListadoProducto.txt"); // Poner aqui la direccion del archivo de texto a utilizar
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(br.ready()) {
                    lineasArchivo.add(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean continuar = false;
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String tipo;

        // El usuario escoge que tipo de map utilizar
        FactoryMap<String,Integer> factory = new FactoryMap<String, Integer>();
        AbstractMap<String,Integer> map;
        System.out.println("\n Escoge que tipo de implementacion de map deseas usar: ");
        System.out.println(" 1) HashMap   2) TreeMap   3) LinkedHashMap ");
        tipo = teclado.nextLine();
        
        map = factory.getMap(tipo);

        // Menu de opciones
        while(continuar == false){

            System.out.println("\n ..:: Menu de opciones ::..  \n");
            System.out.println(" 1. Agregar un producto a la coleccion ");
            System.out.println(" 2. Mostrar categoria de producto ");
            System.out.println(" 3. Mostrar los datos, categoria y cantidad de cada articulo en la coleccion ");
            System.out.println(" 4. Mostrar los datos, categoria y cantidad de cada articulo en la coleccion, ordenada por tipo ");
            System.out.println(" 5. Mostrar el producto y la categoria de todo el inventario ");
            System.out.println(" 6. Mostrar el producto y la categoria existentes, ordenadas por tipo");
            System.out.println(" 7. Visualizar la lista de articulos");
            System.out.println(" 8. Salir ");

            System.out.println("\n Porfavor elige una opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch(opcion){

                case 1:
                    //
                break;

                case 2:
                    //
                break;

                case 3:
                    //
                break;                

                case 4:
                    //
                break;

                case 5:
                    //
                break; 
                
                case 6:
                    //
                break;

                case 7:

                    // Imprime la lista de articulos para que el usuario pueda verla
                    System.out.println("\n ..:: Lista de articulos ::..  \n");
                    for(int i = 0; i < lineasArchivo.size(); i++){
                        System.out.println(lineasArchivo.get(i));
                        if(i == 3 || i == 7 || i == 11 || i == 14 || i == 18 || i == 23 || i == 28){
                            System.out.println("\n");
                        }
                    }

                break;

                case 8:

                    System.out.println(" Gracias por utilizar el programa ");
                    continuar = true;

                break;

                default:
                    System.out.println("Error, tu numero de opcion ingresado no existe, porfavor vuelve a intentarlo \n");
                break;

            }

        }
        
    }

}