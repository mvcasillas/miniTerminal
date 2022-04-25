/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ej_b5 {
    public static void main(String[] args) {
        
//        File dic = new File("home\\Docs\\Diccionario");
//        dic.mkdir();
        
        File aLeer = new File("home\\Docs\\diccionario.txt");
        
        for(int i=65;i<91;i++){
            //En  unicode 65 es la letra A y 90 la Z
            //Si conviertes un "caracter" numérico a String se convierte en el caracter unicode correspondiente
            String letra=Character.toString((char)i);
            //System.out.println(letra);
            
            //Creo el archivo a escribir con la ruta y la letra.txt
            File abc= new File("home\\Docs\\Diccionario\\"+letra+".txt");
            
            try{
                FileWriter writerAbc = new FileWriter(abc, true);
                
                Scanner lector = new Scanner(aLeer);
                
                while(lector.hasNext()){
                    String palabra=lector.nextLine();
//                    System.out.println(palabra.substring(0,1));
//                    System.out.println(letra);
//                    System.out.println("-----");
                    if(palabra.substring(0,1).equalsIgnoreCase(letra)){
                        writerAbc.write(palabra+"\n");
                        //System.out.println("bien");
                    }else if(palabra.substring(0,1).equals("-")){
                        //Si comienza con guión compruebo el siguiente caracter al del guión
                        if(palabra.substring(1,2).equalsIgnoreCase(letra)){
                            writerAbc.write(palabra+"\n");
                        }
                    }else{
                        //else if para ver las que tienen acentos que es lo que faltaría
                        //System.out.println("cagaste");
                    }
                    
                }
                
                writerAbc.close();
                lector.close();
                
                
            }catch(Exception e){
                System.err.println("La has cagao");
            }
            
            
            
        }
        
        
        
    }
}
