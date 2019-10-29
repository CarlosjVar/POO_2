package Clases;
import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Clase encargada de buscar clases en el ámbito de ejecucion
 * @author Jos
 */
public class ClassFinder {
    
    /**
    * Metodo que obtiene todos los paquetes disponibles 
    * @return Un array de los paquetes obtenidos
    */
    private static Package[] getAllPackages() {
        return  Package.getPackages();
    }
    
    /**
    * Metodo que genera un ArrayList con todas las clases del ambito de ejecucion cuyo nombre coincide con el string dado 
    * @return Un ArrayList de las clases obtenidas
    * @param pNombre el nombre por el cual buscar las clases
    */
    public static ArrayList <Class> findClassesInPackages(String pNombre) {
        ArrayList <Class> result = new ArrayList();
        Package x;
        Package [] paquetes =  getAllPackages();
        for (Package paquete : paquetes) {
            x = paquete;
            try {
                Class cls = Class.forName(x.getName()+"."+pNombre);
                if (!cls.isInterface())
                    result.add(cls);
            }
            catch(ClassNotFoundException e){
            }
            catch (NoClassDefFoundError e){
            }
        }
       return result;
    }
    
}


