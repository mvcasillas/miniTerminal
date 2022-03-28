/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoPracticoA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MiniTerminal {
    
    public static void printHelp(){
        System.out.println("Comandos disponibles:"
                + "\npwd           Muestra la carpeta actual"
                + "\ncd <dir>      Cambia la carpeta actual a <dir>"
                + "\nls            Muestra directorios y archivos de la carpeta actual"
                + "\nll            Muestra directorios, carpetas y su tamaño y fecha de modificación"
                + "\nmkdir <dir>   Crea la carpeta <dir> en el directorio actual"
                + "\nrm <file>     Borra <file>"
                + "\nmv <f1> <f2>  Mueve o renombra <f1> a <f2>"
                + "\nhelp          Muestra esta lista de comandos"
                + "\nexit          Termina el programa");
        
    }
    
    public static boolean menu(String orden, MiniFileManager fm, String dir, String dir2){
        
            switch(orden){
                case "pwd": //Muestra el directorio actual
                    System.out.println(fm.getPWD());
                    break;
                case "cd": //Cambiar directorio actual   
                    break;
                case "ls": //Muestra directorios y archivos sin info
                    fm.printList(false);
                    break;
                case "ll": //Muestra directorios y archivos con info
                    fm.printList(true);
                    break;
                case "mkdir": //MKdir
                    if(fm.mkdir(dir)){
                        System.out.println("Directorio creado con éxito.");
                    }else{
                        System.out.println("No se ha podido crear el directorio.");
                    }
                    break;
                case "rm": //Borrar archivo
                    
                    //OJO CUIDAO QUE ESTE LANZA EXCEPCIÓN
                    
                    break;
                case "mv": //Mover o renombrar archivo
                    break;
                case "help": //Imprime ayuda
                    printHelp();
                    break;
                case "exit": //Sale
                    return false;
                default:
                    System.err.println("No se reconoce el comando");
                    break;
            }

        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        File fileorigen= new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\home");
        MiniFileManager manager;
        boolean continuar = true;
              
        do{
            try{
                manager= new MiniFileManager(fileorigen);
                String comando;
                    
                do{
                    //Aquí ya empieza el menú
                    System.out.println("> ");
                    comando=leer.nextLine();
                    
                    if(!comando.contains(" ")){
                        //Si no hay espacios dir y dir2 se mandan vacíos
                        continuar= menu(comando, manager, "", "");
                    }else{
                        //Si hay espacios separo primero la orden y luego los directorios (revisar para separar el segundo)
                        //Quizás un regex que reconozca [A-Z]: 
                        String orden = comando.substring(0, comando.indexOf(" "));
                        String dir1 = comando.substring(comando.indexOf(" "));
                        String dir2="";
                        
                        continuar= menu(orden, manager, dir1, dir2);
                    }
                    
                }while(continuar);
            
            }catch(FileNotFoundException e){
                System.err.println("La ruta no es válida");
            }
            //cUIDADO QUE SI COGE EXCEPCIÓN PROBABLEMENTE REINICIE LA UBICACIÓN, VER SI SE PUEDE MANTENER DE ALGUNA MANERA
            
        }while(continuar);
        
        System.out.println("Gracias por usar el miniTerminal");
        
 
    }
    
}
