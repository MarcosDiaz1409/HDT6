/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Interface que contiene todos los metodos que utiliza un hashmap (en este caso especificamente)
 */

public interface IMap<K,V>{

    // Metodo que inserta un valor con su llave al hashmap
    V put(K key, V value);

    // Metodo que verifica si el hashmap esta vacio
    boolean isEmpty();

    // Metodo que devuelve un valor int con el tamaño del hashmap
    int size();

    // Metodo que devuelve el valor de una determinada llave
    V get(K key);
    
}