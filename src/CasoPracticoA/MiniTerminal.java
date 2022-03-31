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
                        System.err.println("La ruta introducida no existe");
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
                        System.out.println("No se ha podido crear el directorio.");
                    }
                    break;
                case "rm": //Borrar archivo  ESTE LANZA EXCEPCIÓN
                    try{
                        fm.remove(dir1);
                    }catch(FileNotFoundException e){
                        System.err.println("La ruta introducida no existe");
                    }
                    break;
                case "mv": //Mover o renombrar archivo
                    if(fm.mv(dir1, dir2)){
                        System.out.println("Operación realizada correctamente");
                    }else{
                        System.out.println("No se ha podido realizar la operación.");
                    }
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
    
    //Me disculpo de antemano con quien tenga que corregir esto 
    //porque de un día para otro lo dejo de entender yo también
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
                        //Si hay espacios separo primero la orden y luego los directorios
                        //La orden sería hasta el primer espacio y lo siguiente los directorios
                        String orden = comando.substring(0, comando.indexOf(" "));
                        String dir1 = comando.substring(comando.indexOf(" ")+1);
                        String dir2;
                        //mv es el único que recibe dos rutas así que si es move hay que separar el dir2 también
                        if(orden.equals("mv")){  
                            String[] dirsArray=dir1.split(" ");
                            
                            if(dirsArray.length>2){
                                int indexSegundaRuta=0;
                                //Empieza a mirar el array desde el 1 para saltarse el inicio de la primera ruta
                                //Con este for saco la última posición del array que empieza por letra, dos puntos
                                //Si hay más de una letra, dos puntos la ruta va a estar mal y ya el comando se encarga
                                //de lanzar el error
                                for(int i=1;i<dirsArray.length;i++){
                                    if(dirsArray[i].matches("[A-Z]:")){
                                        indexSegundaRuta=i;
                                    }
                                }

                                dir2=dirsArray[indexSegundaRuta];
                                //Con este if y for cojo desde el index hasta el final del array y lo meto todo en dir2
                                //Si luego la ruta no está bien escrita se encarga el comando de lanzar el error
                                if(indexSegundaRuta!=(dirsArray.length-1)){                                   
                                    for(int i=indexSegundaRuta+1;i<dirsArray.length;i++)
                                    dir2=dir2+dirsArray[i];
                                }
                                
                            }else{
                                //Este sería el caso de que las dos rutas no tuvieran espacios y todo fuera maravilloso
                                dir1=dirsArray[0];
                                dir2=dirsArray[1]; 
                            }  
                            
                        }else{
                            //Si la orden no es mv dir2 debería ir vacío porque solo recibe una ruta
                            //Si son varias rutas entonces el comando está mal y ya se encarga el file manager de lanzar el error
                            dir2="";
                        }   
                        
                        continuar= menu(orden, manager, dir1, dir2);
                    }
                    
                }while(continuar);
            
            }catch(FileNotFoundException e){
                System.err.println("La ruta no es válida");
            }
            //cUIDADO QUE SI COGE EXCEPCIÓN PROBABLEMENTE REINICIE LA UBICACIÓN, VER SI SE PUEDE MANTENER DE ALGUNA MANERA
            //Intentar hacer un catch de la excepción antes de que llegue aquí a ver si así
            
        }while(continuar);
        
        System.out.println("Gracias por usar el miniTerminal");
        
 
    }
    
}
