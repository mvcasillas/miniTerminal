/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud11_files;

import java.io.File;

/**
 *
 * @author DAW
 */
public class EjercicioA4 {
    
    public static void main(String[] args) {
        
        File f1 = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Mis cosas");
        f1.mkdir();
        
        File f2 = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Alfabeto");
        f2.mkdir();
        
        File f3 = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Fotos");
        File f4 = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Lecturas");
        
        File f3n = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Mis cosas\\Fotos");
        File f4n = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Mis cosas\\Lecturas");
        System.out.println(f3.renameTo(f3n));
        System.out.println(f4.renameTo(f4n));
        
        for(int i=65;i<91;i++){
            //En  unicode 65 es la letra A y 90 la Z
            //Si conviertes un "caracter" numérico a String se convierte en el caracter unicode correspondiente
            String letra=Character.toString((char)i);
            //System.out.println(letra);
            File abc= new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Alfabeto\\"+letra);
            abc.mkdir();
        }
        
        
        
        
    }
    
}
