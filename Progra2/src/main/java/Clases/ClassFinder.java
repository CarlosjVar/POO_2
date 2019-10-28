/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.lang.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jos
 */
public class ClassFinder {
    
    private static Package[] getAllPackages() {
        return  Package.getPackages();
    }
    
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


