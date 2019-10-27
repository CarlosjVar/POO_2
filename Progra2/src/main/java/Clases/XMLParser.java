/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
/**
 *
 * @author carlo
 */
public class XMLParser {
    public static final String xmlFilePath = "D:\\Universidad\\XML.xml";
    public static void  GenerarXML(ArrayList <Class> Superclases,Class clase)
    {
        try{
            
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
        Document document = documentBuilder.newDocument();
        
        Element root = document.createElement("Clase");
        Attr name=document.createAttribute("Nombre");
        name.setNodeValue(clase.getSimpleName().toString());
        document.appendChild(root);
        Element superC=document.createElement("SuperClases");
        root.appendChild(superC);
        for (int i = 0; i < Superclases.size(); i++) {
		Element superclase=document.createElement("Clase");
                Attr paquete = document.createAttribute("Package");
                paquete.setValue(Superclases.get(i).getPackage().getName().toString());
                Attr cla=document.createAttribute("Clase");
                cla.setValue(Superclases.get(i).getSimpleName().toString());
                superclase.setAttributeNode(paquete);
                superclase.setAttributeNode(cla);
                superC.appendChild(superclase);
		}
        Class[]  interfaces=clase.getInterfaces();
        Element interF=document.createElement("Interfaces");
        root.appendChild(interF);
        for(int i=0;i<interfaces.length;i++)
        {
            Element inter=document.createElement("Interface");
            Attr nombre=document.createAttribute("Nombre");
            nombre.setNodeValue(interfaces[i].getSimpleName());
            inter.setAttributeNode(nombre);
            interF.appendChild(inter);
            
        }
        Element cons=document.createElement("Constructores");
        Constructor[] constructores=clase.getDeclaredConstructors();
       for (Constructor constructor : constructores)
        {
            Element con=document.createElement("Constructor");
            Attr nombre=document.createAttribute("Nombre");
            nombre.setNodeValue(constructor.getName());
            Element para=document.createElement("Parámetros");
            con.appendChild(para);
            Parameter[] parametros=constructor.getParameters();
            for(Parameter parametro:parametros)
            {               
                Element par=document.createElement("Parámetro");
                Attr nom=document.createAttribute("Nombre");
                nom.setNodeValue(parametro.getName());
                par.setAttributeNode(nom);
                Attr type=document.createAttribute("Tipo");
                type.setNodeValue(parametro.getType().toString());    
                par.setAttributeNode(type);
                para.appendChild(par);
            }           
            con.setAttributeNode(nombre);
            cons.appendChild(con);
            System.out.print("asd");
        }
        Field []fields=clase.getFields();
        Element atributos=document.createElement("Atributos");
        root.appendChild(atributos);
        for(Field eo:fields)
        {
            Element atrib=document.createElement("Atributo");
            Attr nom=document.createAttribute("Nombre");
            nom.setNodeValue(eo.getName());
            atrib.setAttributeNode(nom);
            Attr type=document.createAttribute("Tipo");
            type.setNodeValue(eo.getType().toString());
            atrib.setAttributeNode(type);
            atributos.appendChild(atrib);
        }
        root.appendChild(cons);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
        transformer.transform(domSource, streamResult);
    }
        catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }  
     catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        
    }
}
