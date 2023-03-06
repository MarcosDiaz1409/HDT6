import java.util.*;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Clase HashMap que utiliza los metodos de la clase abstracta map
 */

public class HashMap<K,V> extends AbstractMap<K,V>{

    private HashMap<K, V> map;

    // Metodo que inserta un valor con su llave al hashmap
    @Override
    public V put(K key, V value){
        return map.put(key, value);
    }

    @Override
    // Metodo que devuelve el valor de una determinada llave
    public V get(K key){
        return map.get(key);
    }

    @Override
    // Metodo que verifica si el hashmap esta vacio
    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    // Metodo que devuelve un valor int con el tamaño del hashmap
    public int size() {
        return map.size();
    }

    // Muestra todos los elementos que contiene el map
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    // Verifica si el valor se encuentra en alguna de las llaves
    @Override
    public boolean containsValue(V value){
        return map.containsValue(value);
    }

}