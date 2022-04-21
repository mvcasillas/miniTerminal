/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosB;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class ej_b2 {
    
    public static void main(String[] args) {
        Scanner lector=null;
        try{
            File f = new File("home/Docs/alumnos_notas.txt");
            lector = new Scanner(f);
            ArrayList<ej_b2_alumno> medias = new ArrayList(); 
            
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
                
                ej_b2_alumno a1 = new ej_b2_alumno(media, nombre);
                medias.add(a1);
                
            }
            
            System.out.println("-----------------------------");
            
            //ÉCHALE UN OJO AL COMPARATOR
            medias.sort(new Comparator<ej_b2_alumno>(){
                public int compare(ej_b2_alumno a1, ej_b2_alumno a2){
                    if (a1.getMedia()>a2.getMedia())return -1;
                    if (a1.getMedia()<a2.getMedia())return 1;
                    return 0;
                }
            });
            
            for(ej_b2_alumno a:medias){
                System.out.format("Nota media de "+a.getNombre()+": %.2f\n",a.getMedia());
            }
            
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }finally{
            lector.close();
        }
        
    }
    
}
