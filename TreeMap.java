import java.util.*;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Clase TreeMap que utiliza los metodos de la clase abstracta map
 */

public class TreeMap<K,V> extends AbstractMap<K,V>{

    private TreeMap<K, V> map;

    // Metodo que inserta un valor con su llave al TreeMap
    @Override
    public V put(K key, V value){
        return map.put(key, value);
    }
 
    // Metodo que devuelve el valor de una determinada llave
    public V get(K key){
        return map.get(key);
    }
 
    // Metodo que verifica si el hashmap esta vacio
    public boolean isEmpty(){
        return map.isEmpty();
    }
 
    // Metodo que devuelve un valor int con el tamaño del TreeMap
    public int size() {
        return map.size();
    }
 
    // Muestra todos los elementos que contiene el map
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

}