/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ej_b7 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File aLeer;

        do{
            System.out.println("Introduce el archivo a leer");
            //String rutaLeer = teclado.nextLine();
            String rutaLeer = "home\\Docs\\Mis cosas\\Lecturas\\pruebita.txt";      
            aLeer = new File(rutaLeer);
        
            if(!aLeer.exists()){
                System.out.println("El archivo que has introducido no existe");
            }
            
        }while(!aLeer.exists());
                
        try{
            Scanner lectorlineas = new Scanner(aLeer);
           
            //Cuántas líneas ----------------------------------------------------------------
            int lineas=0;
            int palabras=0;
            while(lectorlineas.hasNext()){
                lectorlineas.nextLine();
                lineas++;
            }
            System.out.println("lineas: "+lineas);
            lectorlineas.close();
            
            //Cuántas palabras---------------------------------------------------------------
            Scanner lectorpalabras = new Scanner(aLeer);            
            while(lectorpalabras.hasNext()){
                lectorpalabras.next();
                palabras++;
            }
            System.out.println("palabras: "+palabras);
            lectorpalabras.close();
            
            //Número de caracteres----------------------------------------------------------
            int caracteres=0;
            BufferedReader lectorcaracteres = new BufferedReader(new FileReader(aLeer));
            while(lectorcaracteres.read()!=-1){
                //lectorcaracteres.read();
                caracteres++;
            }
            caracteres=caracteres-((lineas-1)*2);
            System.out.println("caracteres: "+caracteres);
            lectorcaracteres.close();
            
            
            //10 palabras más comunes-------------------------------------------------------           
            Scanner lectorcomunes = new Scanner(aLeer);
            HashMap<String, Integer> listapalabras = new HashMap<>();
            while(lectorcomunes.hasNext()){
                String leido=lectorcomunes.next();
                
                //Si no está en el map todavía, se mete
                if(!listapalabras.containsKey(leido)){
                    listapalabras.put(leido,1);
                }else{
                    //Si está  ya en el map se suma uno al valor
                    listapalabras.put(leido, (listapalabras.get(leido)+1));
                }
                
            }
            //Ahora quedaría ordenar el map por valores descendente
            List<Entry<String, Integer>> list = new LinkedList<Entry<String,Integer>>(listapalabras.entrySet());
            list.sort(new Comparator<Entry<String, Integer>>(){
                public int compare(int valor1, int valor2){
                    if(valor1>0)return -1;
                    if (valor1<0)return 1;
                    return 0;
                }
                
            });
            
            
            lectorcomunes.close();
           
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }
        
        
        
    }

    
}
