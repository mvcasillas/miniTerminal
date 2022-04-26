/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ej_b7 {
    
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        // Crear una lista de mapentries con los elementos del hm
        List<Map.Entry<String, Integer> > lista = new LinkedList<>(hm.entrySet());
 
        // Ordenar la lista
        Collections.sort(lista, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // Meter en un hm nuevo los valores de la lista en orden
        HashMap<String, Integer> ordenado = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : lista) {
            ordenado.put(aa.getKey(), aa.getValue());
        }
        return ordenado;
        
        // Sacado y modificado de: https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/

    }
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File aLeer;

        do{
            System.out.println("Introduce el archivo a leer");
            String rutaLeer = teclado.nextLine();
            //String rutaLeer = "home\\Docs\\Mis cosas\\Lecturas\\lazarillo.txt";      
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
            System.out.println("Líneas: "+lineas);
            lectorlineas.close();
            
            //Cuántas palabras---------------------------------------------------------------
            Scanner lectorpalabras = new Scanner(aLeer);            
            while(lectorpalabras.hasNext()){
                lectorpalabras.next();
                palabras++;
            }
            System.out.println("Palabras: "+palabras);
            lectorpalabras.close();
            
            //Número de caracteres----------------------------------------------------------
            int caracteres=0;
            BufferedReader lectorcaracteres = new BufferedReader(new FileReader(aLeer));
            while(lectorcaracteres.read()!=-1){
                //lectorcaracteres.read();
                caracteres++;
            }
            caracteres=caracteres-((lineas-1)*2);
            System.out.println("Caracteres: "+caracteres);
            lectorcaracteres.close();
            
            
            //10 palabras más comunes-------------------------------------------------------           
            Scanner lectorcomunes = new Scanner(aLeer);
            HashMap<String, Integer> listapalabras = new HashMap<>();
            while(lectorcomunes.hasNext()){
                String leido=lectorcomunes.next().toLowerCase();
                //tolowercase para que considere las que empiezan por mayus y las que no como la misma palabra
                
                //Si no está en el map todavía, se mete
                if(!listapalabras.containsKey(leido)){
                    listapalabras.put(leido,1);
                }else{
                    //Si está  ya en el map se suma uno al valor
                    listapalabras.put(leido, (listapalabras.get(leido)+1));
                }
                
            }
            //Ahora quedaría ordenar el map por valores descendente
            //llama una función que tengo declarada arriba
            HashMap<String, Integer> ordenado = sortByValue(listapalabras);
            int contador=0;
            
            System.out.println("Palabras más usadas: ");
            for (Map.Entry<String, Integer> en : ordenado.entrySet()) {
                System.out.println("* " + en.getKey() +" (" + en.getValue()+" veces)");
                contador++;
                if (contador>=10){
                    break;
                }
            }
            
            lectorcomunes.close();
           
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }
        
        
        
    }

    
}
