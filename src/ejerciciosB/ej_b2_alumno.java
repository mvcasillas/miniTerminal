/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosB;


/**
 *
 * @author DAW
 */
public class ej_b2_alumno {

    double media;
    String nombre;

    public ej_b2_alumno(double media, String nombre) {
        this.media = media;
        this.nombre = nombre;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "Nota media de "+nombre+": "+media;
    }
    
    
}
