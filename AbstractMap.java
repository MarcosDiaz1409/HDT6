import java.util.*;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Clase abstracta de un map que contiene todo los metodos de un map y los hereda a tres implementaciones de HashMap
 */


public abstract class AbstractMap<K,V> implements IMap<K,V>{

    // Instancia la clase de AbstractMap
    public AbstractMap(){

    }

    // Metodo que inserta un valor con su llave al hashmap
    @Override
    public abstract V put(K key, V value);

    // Metodo que verifica si el hashmap esta vacio
    @Override
    public abstract boolean isEmpty();

    // Metodo que devuelve un valor int con el tamaño del hashmap
    @Override
	public abstract int size();

    // Metodo que devuelve el valor de una determinada llave
    @Override
    public abstract V get(K key);

    // Muestra todos los elementos que contiene el map
    @Override
    public abstract Set<Map.Entry<K,V>> entrySet();

}