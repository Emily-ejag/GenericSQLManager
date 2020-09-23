/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author emily
 */
public class Registros {
    private String nombreTabla;
    private String nombreCampo[];
    private int longitud;

    public Registros(String nombreTabla, String[] nombreCampo, int longitud) {
        this.nombreTabla = nombreTabla;
        this.longitud = longitud;
        this.nombreCampo = new String[longitud];
        
    }

    public String[] getNombreCampo() {
        return nombreCampo;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setNombreCampo(String[] nombreCampo) {
        this.nombreCampo = nombreCampo;
    }
    


    
    public String getNombreTabla() {
        return nombreTabla;
    }

    
    

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }
    
}
