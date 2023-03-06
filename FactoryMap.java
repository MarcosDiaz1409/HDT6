/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Clase Factory de Map que se utilizara para instanciar el map deseado por el usuario
 */

public class FactoryMap<K,V>{
    
    // Metodo que obtiene un map segun se haya indicado
    public AbstractMap<K,V> getMap(String tipo){

        if (tipo == null){
            return null;
        }
        if(tipo.equalsIgnoreCase("HashMap")){
            return new HashMap<K,V>();
        }
        if(tipo.equalsIgnoreCase("TreeMap")){
            return new TreeMap<K,V>();
        }
        if(tipo.equalsIgnoreCase("LinkedHashMap")){
            return new LinkedHashMap<K,V>();
        }

        return null;

    }

}