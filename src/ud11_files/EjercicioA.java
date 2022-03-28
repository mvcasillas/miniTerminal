/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud11_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class EjercicioA {
    
    
    public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException{
        
        if(ruta.exists()){
            
            if(info){
                
                if(ruta.isFile()){
                    System.out.println("Nombre de archivo    : "+ruta.getName());
                    System.out.println("Tamaño del archivo   : "+ruta.length()+" bytes.");
                    Date fecha= new Date(ruta.lastModified());
                    System.out.println("Fecha de modificación: "+fecha);
                }else if(ruta.isDirectory()){
                    System.out.println("Nombre del directorio: "+ruta.getName());
                    System.out.println("Contiene:\nDirectorios: ");
                    
                    for (File listFile : ruta.listFiles()) {
                        if (listFile.isDirectory()) {
                            System.out.println("Nombre de directorio : " + listFile.getName());
                            System.out.println("Tamaño del directorio: "+ruta.length()+" bytes.");
                            Date fecha= new Date(ruta.lastModified());
                            System.out.println("Fecha de modificación: "+fecha);
                            System.out.println("---------------------");
                        }
                    }
                    System.out.println("\nFicheros:");
                    for (File listFile : ruta.listFiles()) {
                        if (listFile.isFile()) {
                            System.out.println("Nombre de archivo    : " + listFile.getName());
                            System.out.println("Tamaño del archivo   : "+ruta.length()+" bytes.");
                            Date fecha= new Date(ruta.lastModified());
                            System.out.println("Fecha de modificación: "+fecha);
                            System.out.println("---------------------");
                        } 
                    }
                }
                
            }else{
                if(ruta.isFile()){
                    System.out.println("Nombre de archivo: "+ruta.getName());
                }else if(ruta.isDirectory()){
                    System.out.println("Nombre del directorio: "+ruta.getName());
                    System.out.println("Contiene:\nDirectorios: ");
                    
                            
                    for (File listFile : ruta.listFiles()) {
                        if (listFile.isDirectory()) {
                            System.out.println(listFile.getName());
                        }
                    }
                    System.out.println("\nFicheros:");
                    for (File listFile : ruta.listFiles()) {
                        if (listFile.isFile()) {
                            System.out.println(listFile.getName());
                        } 
                    }
                }
            }
            
            
        }else{
            throw new FileNotFoundException("La ruta especificada no existe.");
        }
        
        
    }
    
    public static void muestraInfoRuta2(File ruta, boolean info) throws FileNotFoundException
    {
        
        if(ruta.exists()){
            
            if(info){
                
                if(ruta.isFile()){
                    System.out.println("Nombre de archivo    : "+ruta.getName());
                    System.out.println("Tamaño del archivo   : "+ruta.length()+" bytes.");
                    Date fecha= new Date(ruta.lastModified());
                    System.out.println("Fecha de modificación: "+fecha);
                }else if(ruta.isDirectory()){              
                    System.out.println("Nombre del directorio: "+ruta.getName());
                    System.out.println("Contiene:\n");
                    
                    // ---------------------------- DESORDENO DIRECTORIOOOOOOOOOOOOOOS ---------------------------
                    //Me hago un arrayList de directorios
                    ArrayList<File> directorios = new ArrayList();
                    for (File f : ruta.listFiles()) {
                        if (f.isDirectory()) {
                            directorios.add(f);
                        }
                    }
                    
                    Random r = new Random();
                    //Me hago un array de Files donde voy a guardar los directorios desordenados at random
                    File[] dDesordenados= new File[directorios.size()];
                    for(int i=0;i<directorios.size();i++){
                        //Me genero una posición random en dentro del rango del array. 
                        //Me aseguro de que el tamaño es mayor de 1 porque si no el random da error
                        int posicion;
                        if(directorios.size()!=1){
                            posicion = r.ints(0,(directorios.size()-1)).findFirst().getAsInt();
                        }
                        else{
                            posicion=0;
                        }
                        
                        
                        //Si está vacío lo guardo
                        if(dDesordenados[posicion]==null){
                            dDesordenados[posicion]=directorios.get(i);
                            //System.out.println("¿Lo guarda?");
                        }else{
                            //Si no está vacío avanza posición y se repite hasta que metido sea true (hasta que se meta)
                            boolean metido=false;
                            do{
                                //Para no salirme del array, si se va a pasar de la longitud lo llevo a cero
                                if((posicion+1)<dDesordenados.length){
                                    posicion++;
                                }else{
                                    posicion=0;
                                }
                                
                                //Vuelvo a intentar meterlo
                                if(dDesordenados[posicion]==null){
                                    dDesordenados[posicion]=directorios.get(i);
                                    metido=true;
                                }
                            
                            }while(!metido);
                            

                        }
                        
                    }
                      
                    //-------------------- DESORDENO FICHEROOOOOOOOOOOOOS ----------------------------------------
                    //Me hago un arrayList de ficheros
                    ArrayList<File> ficheros = new ArrayList();
                    for (File f : ruta.listFiles()) {
                        if (f.isFile()) {
                            ficheros.add(f);
                        }
                    }    

                    //Me hago un array de Files donde voy a guardar los ficheros desordenados at random
                    File[] fDesordenados= new File[ficheros.size()];
                    for(int i=0;i<ficheros.size();i++){
                        //Me genero una posición random en dentro del rango del array
                        //Me aseguro de que el tamaño es mayor de 1 porque si no el random da error
                        int posicion;
                        if(directorios.size()!=1){
                            posicion = r.ints(0,(directorios.size()-1)).findFirst().getAsInt();
                        }
                        else{
                            posicion=0;
                        }
                    
                        if(fDesordenados[posicion]==null){
                            fDesordenados[posicion]=ficheros.get(i);
                            //System.out.println("¿Lo guarda?");
                        }else{
                            //Si no está vacío avanza posición y se repite hasta que metido sea true (hasta que se meta)
                            boolean metido=false;
                            do{
                                //Para no salirme del array, si se va a pasar de la longitud lo llevo a cero
                                if((posicion+1)<fDesordenados.length){
                                    posicion++;
                                }else{
                                    posicion=0;
                                }
                                
                                //Vuelvo a intentar meterlo
                                if(fDesordenados[posicion]==null){
                                    fDesordenados[posicion]=ficheros.get(i);
                                    metido=true;
                                }
                            
                            }while(!metido);
                            

                        }

                        
                    }
                    
                    //----------------------------- IMPRIMO AMBOS ----------------------------------
                    
                    System.out.println("Directorios desordenados:");
                    for (File d : dDesordenados) {
                        System.out.println(d.getName());
                    }
                    
                    System.out.println("\nFicheros desordenados:");
                    for (File f : fDesordenados) {
                        System.out.println(f.getName());
                    }    
  
                }
                
            }else{
                if(ruta.isFile()){
                    System.out.println("Nombre de archivo: "+ruta.getName());
                }else if(ruta.isDirectory()){
                    System.out.println("Nombre del directorio: "+ruta.getName());
                    System.out.println("Contiene:\nDirectorios: ");
                    
                            
                    for (File f : ruta.listFiles()) {
                        if (f.isDirectory()) {
                            System.out.println(f.getName());
                        }
                    }
                    System.out.println("\nFicheros:");
                    for (File f : ruta.listFiles()) {
                        if (f.isFile()) {
                            System.out.println(f.getName());
                        } 
                    }
                }
            }
            
            
        }else{
            throw new FileNotFoundException("La ruta especificada no existe.");
        }
        
        
    }
    
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String introducido;
        
        do{
            System.out.println("");
            System.out.println("Introduce una ruta");
            introducido=leer.nextLine();
            
            if("".equals(introducido)){
                //System.out.println("TU PUTA MADRE SAL HOSTIAS");
            }else{
                try{
                    File archivo = new File(introducido);
                    muestraInfoRuta2(archivo,true);
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
                                   
        }while(!"".equals(introducido));
        
        System.out.println("Has salido");
        
        
    }
}
