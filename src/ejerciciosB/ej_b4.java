/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ej_b4 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuántos nombres quieres generar?");
        int cuantos = teclado.nextInt();
        teclado.nextLine();
        
        File aLeerNombre= new File("home\\Docs\\usa_nombres.txt");
        File aLeerApellido= new File("home\\Docs\\usa_apellidos.txt");
        File aEscribir;
        
        System.out.println("Introduce el archivo a escribir");
        String rutaEscribir = teclado.nextLine();
        aEscribir = new File(rutaEscribir);
        
        try{
            Scanner lectorNombre = new Scanner(aLeerNombre);
            Scanner lectorApellido = new Scanner(aLeerApellido);
            FileWriter escritor= new FileWriter(aEscribir, true);
            
            ArrayList<String> nombres = new ArrayList();
            ArrayList<String> apellidos = new ArrayList();
            
            //Guardo en dos arrays los nombres y los apellidos
            while(lectorNombre.hasNext()){
                nombres.add(lectorNombre.nextLine());
            }
            
            while(lectorApellido.hasNext()){
                apellidos.add(lectorApellido.nextLine());
            }
            
            //Creo un rng
            Random r = new Random();
            for(int i=0; i<cuantos;i++){
                //Saco una posición random para nombres, lo escribo y escribo un espacio
                int posicionrandom1 = r.ints(0,(nombres.size()-1)).findFirst().getAsInt();
                escritor.write(nombres.get(posicionrandom1));
                escritor.write(" ");
                
                //Saco una posición random para apellidos, lo escribo y escribo un salto de línea
                int posicionrandom2 = r.ints(0,(apellidos.size()-1)).findFirst().getAsInt();
                escritor.write(apellidos.get(posicionrandom2));
                escritor.write("\n");
            }
 
            lectorNombre.close();
            lectorApellido.close();
            escritor.close();
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }
        
        System.out.println("¡Hecho!");
        
    }
    
}
