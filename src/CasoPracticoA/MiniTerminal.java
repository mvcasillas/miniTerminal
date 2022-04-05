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
 * @author MariaC
 */
public class MiniTerminal {
    
    /**
     * Imprime por pantalla los comandos disponibles
     */
    public static void printHelp(){
        System.out.println("Comandos disponibles:"
                + "\npwd           Muestra la carpeta actual"
                + "\ninfo <file>   Muestra el tamaño y la fecha de modificación del <file>"
                + "\ncd <dir>      Cambia la carpeta actual a <dir>"
                + "\nls            Muestra directorios y archivos de la carpeta actual"
                + "\nll            Muestra directorios, carpetas y su tamaño y fecha de modificación"
                + "\nmkdir <dir>   Crea la carpeta <dir> en el directorio actual"
                + "\nrm <file>     Borra <file>"
                + "\nmv <f1> <f2>  Mueve o renombra <f1> a <f2>"
                + "\nhelp          Muestra esta lista de comandos"
                + "\nexit          Termina el programa");
        
    }
    
    /**
     * Menú funcional del terminal que se pone en contacto con el MiniFileManager
     * 
     * @param orden - String con el comando a ejecutar ya separado del resto (si aplica)
     * @param fm - el objeto MiniFileManager instanciado en el main con el que se realizan las operaciones
     * @param dir1 - String con el primer directorio (si aplica) para ejecutar el comando
     * @param dir2 - String con el segundo directorio (si aplica) para ejecutar el comando
     * @return - true para seguir repitiendo el menú, false para salir y terminar el programa
     */
    public static boolean menu(String orden, MiniFileManager fm, String dir1, String dir2){
        
            switch(orden){
                case "pwd": //Muestra el directorio actual
                    System.out.println(fm.getPWD());
                    break;
                case "cd": //Cambiar directorio actual   ESTE LANZA EXCEPCIÓN
                    try{
                        fm.changeDir(dir1);
                        //Si no salta excepción es que es true y que se ha podido hacer así que no necesita if
                    }catch(FileNotFoundException e){
                        System.err.println(e.toString());
                    }
                    break;
                case "ls": //Muestra directorios y archivos sin info
                    fm.printList(false);
                    break;
                case "ll": //Muestra directorios y archivos con info
                    fm.printList(true);
                    break;
                case "mkdir": //MKdir
                    if(fm.mkdir(dir1)){
                        System.out.println("Directorio creado con éxito.");
                    }else{
                        System.err.println("No se ha podido crear el directorio.");
                    }
                    break;
                case "rm": //Borrar archivo  ESTE LANZA EXCEPCIÓN
                    try{
                        fm.remove(dir1);
                    }catch(FileNotFoundException e){
                        System.err.println(e.toString());
                    }
                    break;
                case "mv": //Mover o renombrar archivo
                    if(fm.mv(dir1, dir2)){
                        System.out.println("Operación realizada correctamente");
                    }else{
                        System.err.println("No se ha podido realizar la operación.");
                    }
                    break;
                case "help": //Imprime ayuda
                    printHelp();
                    break;
                case "info": //Muestra tamaño en bytes y megas y fecha de modificación de un file
                    try{
                        fm.info(dir1);
                    }catch(FileNotFoundException e){
                        System.err.println(e.toString());
                    }
                    break;
                case "exit": //Sale
                    return false;
                default:
                    System.err.println("No se reconoce el comando");
                    break;
            }

        return true;
    }
    
    //Me disculpo de antemano con quien tenga que corregir esto 
    //porque de un día para otro lo dejo de entender yo también
    
    /**
     * Main
     * @param args 
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        //Por defecto el programa se inicia en la carpeta home, donde está el proyecto
        File fileorigen= new File("home");
        MiniFileManager manager;
        boolean continuar = true;
              
        do{
            try{
                manager= new MiniFileManager(fileorigen);
                String comando;
                    
                do{
                    //Bucle del menú
                    System.out.println("");
                    System.out.print("user@machine:~ $ ");
                    comando=leer.nextLine();
                    
                    //If/else para separar la línea de comando leída en orden y directorios (si aplica)
                    if(!comando.contains(" ")){
                        //Si no hay espacios dir y dir2 se mandan vacíos
                        continuar= menu(comando, manager, "", "");
                    }else{
                        //Si hay espacios separo primero la orden y luego los directorios
                        //La orden sería hasta el primer espacio y lo siguiente los directorios
                        String orden = comando.substring(0, comando.indexOf(" "));
                        String dir1 = comando.substring(comando.indexOf(" ")+1);
                        String dir2;
                        //mv es el único que recibe dos rutas así que si es move hay que separar el dir2 también
                        //Sólo va a funcionar con rutas absolutas porque toma [A-Z]: como el inicio de la segunda ruta
                        if(orden.equals("mv")){  
                            String[] dirsArray=dir1.split(" ");
                            File primera = new File(manager.getPWD(),dirsArray[0]);
                          if(!primera.exists()){
                              if(dirsArray.length>2){
                                int indexSegundaRuta=0;
                                //Empieza a mirar el array desde el 1 para saltarse el inicio de la primera ruta
                                //Con este for saco la última posición del array que empieza por letra, dos puntos
                                //Si hay más de una letra, dos puntos la ruta va a estar mal y ya el comando se encarga
                                //de lanzar el error
                                for(int i=1;i<dirsArray.length;i++){
                                    if(dirsArray[i].matches("[A-Z]:.*")){
                                        indexSegundaRuta=i;
                                    }
                                }
                                
                                //Dejamos en dir1 solo la primera ruta con sus espacios y todo
                                dir1=dirsArray[0];
                                for(int i=1;i<indexSegundaRuta;i++){
                                    dir1=dir1+" "+dirsArray[i];
                                    //+" " (más espacio antes de dirsArray[i] porque el split lo ha quitado así que hay que devolverlo
                                }                               
                                
                                dir2=dirsArray[indexSegundaRuta];
                                //Con este if y for cojo desde el index hasta el final del array y lo meto todo en dir2
                                //Si luego la ruta no está bien escrita se encarga el comando de lanzar el error
                                if(indexSegundaRuta!=(dirsArray.length-1)){                                   
                                    for(int i=indexSegundaRuta+1;i<dirsArray.length;i++){
                                        dir2=dir2+" "+dirsArray[i];
                                        //+" " (más espacio antes de dirsArray[i] porque el split lo ha quitado así que hay que devolverlo
                                    }    
                                }
                                
                            }else{
                                //Este sería el caso de que las dos rutas fueran absolutas, no tuvieran espacios y todo fuera maravilloso
                                dir1=dirsArray[0];
                                dir2=dirsArray[1]; 
                            }  
                          }else{
                              //Esto convierte en ruta absoluta los strings dir1 y dir2 si la primera es relativa y existe y el array es de dimensión 2
                              dir1=manager.getPWD()+"/"+dirsArray[0];
                              dir2=manager.getPWD()+"/"+dirsArray[1];
                          }                          
                            
                        }else{
                            //Si la orden no es mv dir2 debería ir vacío porque solo recibe una ruta
                            //Si son varias rutas entonces el comando está mal y ya se encarga el file manager de lanzar el error
                            dir2="";
                        }   
                        
                        //Llama al menú con los parámetros separados y lo guarda en una variable 
                        //Se guarda la variable y no se llama en el while para poder consultarla en el bucle siguiente
                        continuar= menu(orden, manager, dir1, dir2);
                    }
                    
                }while(continuar);
            
            }catch(FileNotFoundException e){
                System.err.println(e.toString());
            }

            
        }while(continuar);
        
        System.out.println("Gracias por usar el miniTerminal");
        //Fin del programa.
 
    }
    
}
