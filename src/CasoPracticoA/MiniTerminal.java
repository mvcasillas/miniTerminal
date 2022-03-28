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
    
    public static boolean menu(String comando){
        switch(comando){
                case "pwd": //Muestra el directorio actual
                    break;
                case "cd": //Cambia el directorio actual
                    break;
                case "ls": //Muestra directorios y archivos sin info
                    break;
                case "ll": //Muestra directorios y archivos con info
                    break;
                case "mkdir": //MkDir
                    break;
                case "rm": //Borra
                    break;
                case "mv": //Mueve o renombra
                    break;
                case "help": //Imprime ayuda
                    printHelp();
                    break;
                case "exit": //Sale
                    return false;
                default:
                    System.out.println("No se reconoce el comando");
                    break;
            }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        File fileorigen;
        do{
            System.out.println("Introduce una ruta para empezar a trabajar");
            String rutaorigen=leer.nextLine();
            fileorigen = new File(rutaorigen);
            
            try{
                MiniFileManager manager= new MiniFileManager(fileorigen);
            }catch(FileNotFoundException e){
                System.out.println("La ruta introducida no es válida");
            }
            
        }while (!fileorigen.exists());
        
        //Aquí ya empieza el menú
        String comando;
        do{
            System.out.println("Introduce comando:");
            comando=leer.nextLine();
            
        }while(menu(comando));
        
 
    }
    
}
