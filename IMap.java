public interface IMap<K,V>{

    V put(K key, V value);

    boolean isEmpty();

    int size();

    V get(K key);

    
}