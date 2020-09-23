/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author jeffer
 */
public class Campos {
    private String camp;
    private int valor;
    private int resta;
    private String nombre;
    private int totalCam;

    public Campos(String camp, int valor, int resta, String nombre, int totalCam) {
        this.camp = camp;
        this.valor = valor;
        this.resta = resta;
        this.nombre = nombre;
        this.totalCam = totalCam;
    }

    public int getTotalCam() {
        return totalCam;
    }

    public void setTotalCam(int totalCam) {
        this.totalCam = totalCam;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
       
    public void setCamp(String camp) {
        this.camp = camp;
    }

    public void setResta(int resta) {
        this.resta = resta;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }

    public int getResta() {
        return resta;
    }


    public String getCamp() {
        return camp;
    }

}
