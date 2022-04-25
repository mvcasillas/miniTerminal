/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosB;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class ej_b3 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        File aLeer;
        File aEscribir;
        
        do{
            System.out.println("Introduce el archivo a leer");
            String rutaLeer = teclado.nextLine();       
            aLeer = new File(rutaLeer);
        
            if(!aLeer.exists()){
                System.out.println("El archivo que has introducido no existe");
            }
            
        }while(!aLeer.exists());
        
        System.out.println("Introduce el archivo a escribir");
        String rutaEscribir = teclado.nextLine();
        aEscribir = new File(rutaEscribir);
        
        
        try{
            Scanner lector = new Scanner(aLeer);
            FileWriter escritor= new FileWriter(aEscribir);
            
            ArrayList<String> personas = new ArrayList();
            
            while(lector.hasNext()){
                personas.add(lector.nextLine());
            }
            
            Collections.sort(personas);
            
            for(String s:personas){
                //System.out.println(s.toString());
                escritor.write(s+"\n");
            }    
            
            lector.close();
            escritor.close();
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }
        
        System.out.println("¡Hecho!");
        
               
    }

    
}
