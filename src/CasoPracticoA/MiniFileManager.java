/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoPracticoA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DAW
 */
public class MiniFileManager {
    
    File ubicacion;

    public MiniFileManager(File ubicacion) throws FileNotFoundException{
        if(ubicacion.exists()){
            this.ubicacion = ubicacion;
        }else{
            throw new FileNotFoundException("El archivo o la ruta no existe");
        }   
    }
 
    public String getPWD(){
        //Devuelve un string con la carpeta actual
        return ubicacion.getAbsolutePath();
    }
    
    public boolean changeDir(String dir) throws FileNotFoundException{
        //Cambia la carpeta actual a dir, devuelve true si se ha hecho correctamente
        File nuevaubicacion;
        if(dir.equalsIgnoreCase("..")){
            nuevaubicacion= new File(ubicacion.getParentFile().getAbsolutePath());
            this.ubicacion=nuevaubicacion;
            return true;
        }else{
            nuevaubicacion= new File(dir);
            if (nuevaubicacion.exists()){
                //Si existe se cambia
                this.ubicacion=nuevaubicacion;
                return true;
            }else{
                throw new FileNotFoundException("El archivo o la ruta no existe");
            }  
        }   
    }
    
    public void printList(boolean info) {
        
        //Separo los files en directorios y ficheros (ambas opciones lo hacen)
        ArrayList<File> directorios = new ArrayList();
        ArrayList<File> ficheros = new ArrayList();
        for (File listFile : ubicacion.listFiles()) {
            if(listFile.isDirectory()){
                directorios.add(listFile);
            }else{
                ficheros.add(listFile);
            }
        }
        
        if(info){
            //LL
            //Compruebo si hay o no directorios para imprimir o no el encabezado
            if (directorios.size()>0){
                System.out.println("Directorios: ");
                for(File d : directorios){
                    System.out.println("Nombre de directorio : " + d.getName());
                    System.out.println("Tamaño del directorio: "+d.length()+" bytes.");
                    Date fecha= new Date(d.lastModified());
                    System.out.println("Fecha de modificación: "+fecha);
                    System.out.println("---------------------");
                }
            }
            
            //Compruebo si hay o no ficheros para imprimir o no el encabezado
            if (ficheros.size()>0){
                System.out.println("\nArchivos:");
                for(File f : ficheros){
                    System.out.println("Nombre de archivo    : " + f.getName());
                    System.out.println("Tamaño del archivo   : "+f.length()+" bytes.");
                    Date fecha= new Date(f.lastModified());
                    System.out.println("Fecha de modificación: "+fecha);
                    System.out.println("---------------------");
                }
            }   
        
        }else{
            //LS
            //Compruebo si hay o no directorios para imprimir o no el encabezado
            if (directorios.size()>0){
                System.out.println("\nDirectorios: ");     
                for (File listFile : directorios) {
                    System.out.println(listFile.getName());
                }
            }
            
            if (ficheros.size()>0){
                System.out.println("\nArchivos:");
                for (File listFile : ficheros) {
                    System.out.println(listFile.getName());
                }
            }
                    
        }
        
    }
    
    public boolean remove(String dir) throws FileNotFoundException{
        File ficheroABorrar = new File(dir);
        
        if (ficheroABorrar.exists()){  
            if (ficheroABorrar.isFile()){
                //Si es un archivo se borra y hale
                ficheroABorrar.delete();
                return true;
            }else{
                //Si es una carpeta vamos a borrar su contenido
                for(File f: ficheroABorrar.listFiles()){
                    //Si son archivos se borran, si son carpetas se imprime el error
                    if (f.isFile()){
                        f.delete();
                    }else{
                        System.err.println("Imposible borrar subcarpeta");
                    }
                }
                //Y después si todo ha ido  bien, a sí mismo (si no se borra devuelve false)
                return ficheroABorrar.delete();
            }
                        
        }else{
            throw new FileNotFoundException("El archivo o la ruta no existe");
        }
    }
    
    public boolean mkdir(String dir){
        File nuevacarpeta = new File(ubicacion.getAbsolutePath()+"/"+dir);
        //Devuelve true si se ha creado bien
        return nuevacarpeta.mkdir();
    }
    
    public boolean mv(String dir1, String dir2){
        File f1=new File(dir1);
        File f2=new File(dir2);
        
        return f1.renameTo(f2);
    }
    
}
