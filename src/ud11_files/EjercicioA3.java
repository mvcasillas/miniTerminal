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
public class EjercicioA3 {
    
    public static void main(String[] args) {
        File documentos = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Documentos");
        File fotografias = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Fotografias");
        File libros = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Libros");
        
        File docs = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs");
        File fotos = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Fotos");
        File lecturas = new File("E:\\DAW\\Programacion\\Java\\UD11_Files\\Docs\\Lecturas");
        
//        documentos.renameTo(docs);
//        fotografias.renameTo(fotos);
//        libros.renameTo(lecturas);
        
        for(int i=0;i<fotografias.listFiles().length;i++){
            File f1=fotografias.listFiles()[i];
            File f2=new File(f1.getParent()+"\\"+f1.getName().split("\\.")[0]);
            //Eran jpg
            
            
            //System.out.println(f2.getAbsolutePath());
            f1.renameTo(f2);
            //System.out.println(fotografias.listFiles()[i].getParent()+"\\"+fotografias.listFiles()[i].getName());
            
        }
        
        for(int i=0;i<libros.listFiles().length;i++){
            File f1=libros.listFiles()[i];
            File f2=new File(f1.getParent()+"\\"+f1.getName().split("\\.")[0]);
            //Eran txt
            
            
            //System.out.println(f2.getAbsolutePath());
            f1.renameTo(f2);
            //System.out.println(fotografias.listFiles()[i].getParent()+"\\"+fotografias.listFiles()[i].getName());
            
        }
        
        
        
        
        
    }
    
}
