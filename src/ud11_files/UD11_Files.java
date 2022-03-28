/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud11_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

/**
 *
 * @author DAW
 */
public class UD11_Files {

    public static void mostrarRutas(File f){
        System.out.println("getParent()      : "+f.getParent());
        System.out.println("getName()        : "+f.getName());
        System.out.println("getAbsolutePath(): "+f.getAbsolutePath()+"\n");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        File fichero = new File("FicheroEjemplo.txt");
//        
//        if(fichero.exists()){
//            System.out.println("Nombre del archivo "+ fichero.getName());
//            System.out.println("Ruta "+fichero.getPath());
//            System.out.println("Ruta absoluta "+fichero.getAbsolutePath());
//            System.out.println("Se puede leer "+fichero.canRead());
//            System.out.println("Se puede escribir "+fichero.canWrite());
//            System.out.println("Tamaño: "+fichero.length());
//        }
//        
//        try{
//            FileReader reader = new FileReader(fichero);
//            BufferedReader buffer = new BufferedReader(reader);
//            String linea = buffer.readLine();
//            System.out.println("Contenido de la línea: "+linea);
//            
//        }
//        catch(Exception e){
//            
//        }

        File carpetaAbs = new File("E:\\DAW\\Lenguaje de marcas\\1a y 2a eva\\CSS Zen Garden");
        File archivoAbs = new File("E:\\DAW\\Lenguaje de marcas\\1a y 2a eva\\CSS Zen Garden\\index.html");
        
        File carpetaRel = new File("trabajos");
        File ficheroRel = new File("trabajos/documento.txt");
        
        mostrarRutas(carpetaAbs);
        mostrarRutas(archivoAbs);
        mostrarRutas(carpetaRel);
        mostrarRutas(ficheroRel);
        
        System.out.println("¿Existe? "+carpetaAbs.exists());
        System.out.println("¿Existe? "+archivoAbs.exists());
        System.out.println("¿Existe? "+carpetaRel.exists());
        System.out.println("¿Existe? "+ficheroRel.exists());
        System.out.println("");
        
        System.out.println("¿Es archivo? "+carpetaAbs.isFile()
                + " ¿Es carpeta? "+carpetaAbs.isDirectory());
        System.out.println("¿Es archivo? "+archivoAbs.isFile()
                + " ¿Es carpeta? "+archivoAbs.isDirectory());
        System.out.println("¿Es archivo? "+carpetaRel.isFile()
                + " ¿Es carpeta? "+carpetaRel.isDirectory());
        System.out.println("¿Es archivo? "+ficheroRel.isFile()
                + " ¿Es carpeta? "+ficheroRel.isDirectory()); 
        
        
        
//        Date fecha= new Date(archivoAbs.lastModified());
//        System.out.println("");
//        System.out.println("La longitud del archivo es: "+archivoAbs.length()+" bytes");
//        System.out.println("La última modificación fue: "+fecha);
//        
//        System.out.println("----------------");
//        
//        File fotos = new File("E:\\DAW\\Lenguaje de marcas\\8.1\\images");
//        
//        if(fotos.mkdir()){
//            System.out.println("Creada carpeta "+fotos.getName());
//        }
//        else{
//            System.out.println("Borrada carpeta "+fotos.delete());
//        }
        
//        File nuevafotos= new File("E:\\DAW\\Lenguaje de marcas\\8.1\\hola");
//        
//        fotos.renameTo(nuevafotos);
        
        
        
        
    }
    
}
