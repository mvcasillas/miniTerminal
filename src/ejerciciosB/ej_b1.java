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
public class ej_b1 {
    

    public static void main(String[] args) {
        
        try{
            File documento = new File("home/Docs/numeros.txt");
            Scanner lectorDocumento = new Scanner(documento);
            long menor = 999999999;
            long mayor = 0;
            
            while(lectorDocumento.hasNext()){
                long leido=lectorDocumento.nextInt();
                if(leido>mayor){
                    mayor=leido;
                }
                if(leido<menor){
                    menor=leido;
                }
            }
            lectorDocumento.close();
            
            System.out.println("El mayor es "+mayor);
            System.out.println("El menor es "+menor);
            
        }catch (Exception e){
            System.err.println("Errorsito");
        }finally{
            //No me está dejando poner el close aquí, ver por qué
        }
        
    }
    
}
