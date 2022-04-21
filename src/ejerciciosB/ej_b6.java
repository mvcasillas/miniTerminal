/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ej_b6 {
    
//    public static boolean iguala(int tuyo, int leido){
//        
//        
//    }
    

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número entero de la longitud que quieras");
        int numusuario = teclado.nextInt();
        //char[] caracteres = (""+numusuario).toCharArray();
        
        int[] cifras= Integer.toString(numusuario).chars().map(a->a-'0').toArray();
//        for(int i=0;i<cifras.length;i++){
//            System.out.println(cifras[i]);
//        }
        
        
        File pi = new File("\\home\\Docs\\pi-million.txt");
        
        try{
            BufferedReader bReader = new BufferedReader(new FileReader("\\home\\Docs\\pi-million.txt"));
            
            while(el lector tenga algo){
                //Comparar el caracter con el primer caracter de la cifra introducida
                int leido= bReader.read();
                if(cifras[0]==leido){
                    for(int i=0; i<cifras.length;i++){
                           
                    }
                    
                } //Y si no matchea sigue hasta que encuentre el primero
                
            }
            
            
            bReader.close();
            
        }catch(Exception e){
            System.err.println("La has cagao");
        }finally{
            //No me deja cerrarlo fuera de un try catch lmao
            
        }
        
        
    }
    
}
