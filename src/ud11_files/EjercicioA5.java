/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud11_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class EjercicioA5 {
    
    public static boolean borraTodo(File f) throws FileNotFoundException{
        
        if (f.exists()){
            
            if (f.isFile()){
                f.delete();
                return true;
                
            }else{
                //Si es un directorio
                for(File fi: f.listFiles()){
                    //Borra primero todos sus archivos
                    fi.delete();
                }
                //Y después a sí mismo
                f.delete();
                return true;
            }
                        
        }else{
            throw new FileNotFoundException("El archivo no existe");
        }
        
    }
    
    public static boolean borraTodoTodo(File ficheropadre) throws FileNotFoundException{
        
        if (ficheropadre.exists()){
            
            if (ficheropadre.isFile()){
                ficheropadre.delete();
                return true;
                
            }else{
                //Si es un directorio
                for(File ficherohijo: ficheropadre.listFiles()){
                    //Comprobar primero si dentro hay o no hay carpetas
                    borraTodoTodo(ficherohijo);
                }
                //Y después a sí mismo
                ficheropadre.delete();
                return true;
            }
                        
        }else{
            throw new FileNotFoundException("El archivo no existe");
        }
        
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String introducido;
        
        do{
            System.out.println("");
            System.out.println("Introduce la ruta a borrar");
            introducido=leer.nextLine();
            
            if("".equals(introducido)){
                //System.out.println("TU PUTA MADRE SAL HOSTIAS");
            }else{
                try{
                    File archivo = new File(introducido);
                    boolean todocorrecto=borraTodoTodo(archivo);
                    
                    if(todocorrecto){
                        System.out.println("Borrado con éxito");
                    }
                    
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
                                   
        }while(!"".equals(introducido));
        
        System.out.println("Has salido");
        
        
    }
    
}
