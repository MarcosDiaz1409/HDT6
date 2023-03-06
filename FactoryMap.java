import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #6
 * 04/03/2023
 * Clase Factory de Map que se utilizara para instanciar el map deseado por el usuario
 */

public class FactoryMap<K,V>{

    // Metodo que obtiene un map segun se haya indicado
    public Map<String, List<String>> getMap(String tipo){

        if (tipo == null){
            return null;
        }
        if(tipo.equalsIgnoreCase("HashMap")){
            return new HashMap<>();
        }   
        if(tipo.equalsIgnoreCase("TreeMap")){
            return new TreeMap<>();
        }
        if(tipo.equalsIgnoreCase("LinkedHashMap")){
            return new LinkedHashMap<>();
        }

        return null;

    }

}