import java.util.*;

import javax.print.DocFlavor.INPUT_STREAM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 06/03/2023
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
        FactoryMap<String, ArrayList<String>> factory = new FactoryMap<String, ArrayList<String>>();
        Map<String, List<String>> myCollection;
        Map<String, List<String>> Inventario;

        System.out.println("\nEscoge que tipo de implementacion de map deseas usar: ");
        System.out.println("NOTA: Escribe tu tipo de implementacion deseada tal como aparece en el siguiente mensaje ");
        System.out.println("1) HashMap   2) TreeMap   3) LinkedHashMap ");
        tipo = teclado.nextLine();
        
        myCollection = factory.getMap(tipo);
        Inventario = factory.getMap(tipo);

        //  Se crea el inventario
        List<String> muebles = new ArrayList<>();
        muebles.add("Mesas de jardin");
        muebles.add("Sillas de jardin");
        muebles.add("Conjuntos mesas y sillas de jardin");
        muebles.add("Mesas de Ping Pong exteriores");
        Inventario.put("Mueble de terraza", muebles);
        
        List<String> sillones = new ArrayList<>();
        sillones.add("Cojines y colchonetas de masaje");
        sillones.add("Sillones relax y sofas de masajes");
        sillones.add("Sillones de masajes avanzados");
        sillones.add("Sofas camas");
        Inventario.put("Sillones de masaje", sillones);

        List<String> bebidas = new ArrayList<>();
        bebidas.add("Cerveza tibetana Barley");
        bebidas.add("Te frio");
        bebidas.add("Coca cola 1 litro");
        bebidas.add("Coca cola 2 litros");
        Inventario.put("Bebidas", bebidas);

        List<String> condimentos = new ArrayList<>();
        condimentos.add("Sirope de regaliz");
        condimentos.add("Especies Cajun del chef");
        condimentos.add("Mezcla Gumbo del chef");
        Inventario.put("Condimentos", condimentos);

        List<String> frutas = new ArrayList<>();
        frutas.add("Peras secas");
        frutas.add("Pasas");
        frutas.add("Manzana roja");
        frutas.add("Manzana verde");
        Inventario.put("Frutas", frutas);

        List<String> carnes = new ArrayList<>();
        carnes.add("Res");
        carnes.add("Pollo");
        carnes.add("Cerdo");
        carnes.add("Camarones");
        carnes.add("Pescados");
        Inventario.put("Carnes", carnes);

        List<String> lacteos = new ArrayList<>();
        lacteos.add("Queso de cabra");
        lacteos.add("Queso Manchego");
        lacteos.add("Leche descremada");
        lacteos.add("Leche deslactosada");
        lacteos.add("Leche entera");
        Inventario.put("Lacteos", lacteos);

        // Menu de opciones
        while(continuar == false){

            System.out.println("\n ..:: Menu de opciones ::..  \n");
            System.out.println(" 1. Agregar un producto a la coleccion ");
            System.out.println(" 2. Mostrar categoria de producto ");
            System.out.println(" 3. Mostrar los datos, categoria y cantidad de cada articulo en la coleccion ");
            System.out.println(" 4. Mostrar los datos, categoria y cantidad de cada articulo en la coleccion, ordenada por tipo ");
            System.out.println(" 5. Mostrar el producto y la categoria de todo el inventario ");
            System.out.println(" 6. Mostrar el producto y la categoria existentes, ordenadas por tipo");
            System.out.println(" 7. Salir ");

            System.out.println("\n Porfavor elige una opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch(opcion){

                case 1:

                    // Agrega un producto al carrito o coleccion del usuario
                    System.out.println("Ingresa el nombre de la categoria: ");
                    String categoria = teclado.nextLine();
                    if(Inventario.containsKey(categoria)){

                        System.out.println("Ingresa el nombre del producto que deseas agregar: ");
                        String prod = teclado.nextLine();

                        String busqueda = prod;
                        for (Map.Entry<String, List<String>> entry : Inventario.entrySet()) {
                            List<String> values = entry.getValue();
                            if (values.contains(busqueda)) {

                                myCollection.putIfAbsent(categoria, new ArrayList<String>());
                                myCollection.get(categoria).add(prod);    
                                System.out.println("Producto agregado al carrito");
                                    

                            }
                        }
                        
                    }
                    else{
                        System.out.println(" Error, la categoria no existe ");
                    }

                break;

                case 2:
                    // Busca la categoria del producto ingresado
                    
                    System.out.println(" Ingresa el nombre del producto: ");
                    String prod = teclado.nextLine();
                    String isfound = null;

                    for(String key : Inventario.keySet()){

                        List<String> values = Inventario.get(key);

                        if(values.contains(prod)){
                            isfound = key;
                            break;
                        }

                    }

                    if(isfound != null){
                        System.out.println("El producto pertenece a la categoria " + isfound);
                    }else{
                        System.out.println("La categoria no existe");
                    }

                break;

                case 3:

                    //Muestra el carrito del usuario
                    System.out.println("\n");

                    System.out.println(" Informacion del carrito actual ");
                    for (Map.Entry<String, List<String>> entry : myCollection.entrySet()) {
                        String llave = entry.getKey();
                        List<String> valores = entry.getValue();
                        System.out.println("\nCategoria: " + llave);

                        Map<String, Integer> myProducts = new HashMap<>();
                        for (String valor : valores) {
                            int cant = myProducts.getOrDefault(valor, 0);
                            myProducts.put(valor, cant + 1);
                        }

                        for (Map.Entry<String, Integer> values : myProducts.entrySet()) {
                            String valor = values.getKey();
                            int cant = values.getValue();
                            System.out.println("  Producto: " + valor + "\nCantidad: " + cant);
                        }
                    }


                break;                

                case 4:
                    
                    //Muestra el carrito del usuario pero ordenado segun la categoria
                    System.out.println("\n");

                    System.out.println(" Informacion del carrito actual ");

                    List<Map.Entry<String, List<String>>> orderedCollection = new ArrayList<>(myCollection.entrySet());
                    orderedCollection.sort(Comparator.comparing(Map.Entry::getKey));

                    for (Map.Entry<String, List<String>> entry : orderedCollection) {

                        String llave = entry.getKey();
                        List<String> valores = entry.getValue();
                        System.out.println("\nCategoria: " + llave);

                        Map<String, Integer> myProducts = new HashMap<>();
                        for (String valor : valores) {
                            int cant = myProducts.getOrDefault(valor, 0);
                            myProducts.put(valor, cant + 1);
                        }
                        List<Map.Entry<String, Integer>> orderedProducts = new ArrayList<>(myProducts.entrySet());
                        orderedProducts.sort(Comparator.comparing(Map.Entry::getKey));

                        for (Map.Entry<String, Integer> values : orderedProducts) {
                            String valor = values.getKey();
                            int cant = values.getValue();
                            System.out.println("  Producto: " + valor + "\nCantidad: " + cant);
                        }
                    }

                break;

                case 5:
                    
                for (Map.Entry<String, List<String>> entry : Inventario.entrySet()) {
		            System.out.println(entry.getKey()+" : "+entry.getValue());
		        }

                break; 
                
                case 6:
                    // Muestras todas las categorias del inventario ordenadas por orden alfabetico
                    if(Inventario instanceof HashMap){

                        Map<String, List<String>> InventarioOrdenado = new TreeMap<String, List<String>>(Inventario);
                        for (Map.Entry<String, List<String>> entry : InventarioOrdenado.entrySet()) {
                            System.out.println(entry.getKey()+" : "+entry.getValue());
                        }

                    }else if(Inventario instanceof TreeMap){

                        for (Map.Entry<String, List<String>> entry : Inventario.entrySet()) {
                            System.out.println(entry.getKey()+" : "+entry.getValue());
                        }

                    }else if(Inventario instanceof LinkedHashMap){

                        Map<String, List<String>> InventarioOrdenado = new TreeMap<String, List<String>>(Inventario);
                        for (Map.Entry<String, List<String>> entry : InventarioOrdenado.entrySet()) {
                            System.out.println(entry.getKey()+" : "+entry.getValue());
                        }

                    }

                break;

                case 7:
 
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
