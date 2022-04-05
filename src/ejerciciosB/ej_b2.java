/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosB;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class ej_b2 {
    
    public static void main(String[] args) {
        
        try{
            File f = new File("home/Docs/alumnos_notas.txt");
            Scanner lector = new Scanner(f);
            
            while(lector.hasNext()){
                String[] notas = lector.nextLine().split(" ");
                String nombre= notas[0]+" "+notas[1];
                int suma=0;
                int contadorNotas=0;
                
                for(int i=2;i<notas.length;i++){
                    suma+=Integer.parseInt(notas[i]);
                    contadorNotas++;
                }
                double media = (double)suma/contadorNotas;
                
                System.out.format("Nota media de "+nombre+": %.2f\n",media);
                
            }
            
            lector.close();
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }
        
    }
    
}
