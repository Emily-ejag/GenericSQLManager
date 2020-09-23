/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class CreadorTabla {

    private List<String> nombresTablas;
    private static CreadorTabla instancia = null;
    
    
    private CreadorTabla() { 
        nombresTablas = new ArrayList<String>();      
    }
    
    public static CreadorTabla getInstancia() {
        if (instancia == null)
            instancia = new CreadorTabla();       
        return instancia;   
    }
    
    public boolean addNombreTabla(String nombre, String[] campos) throws IOException {
        
        
        if (nombresTablas.contains(nombre))
            return true;
        else {
            nombresTablas.add(nombre);
            
            crearArchivoTabla(nombre,campos);
            return false;
        }
    }
    
    public void removeNombreTabla(String nombre) {
        nombresTablas.remove(nombre);
    }
    
    public void setNombresTablas(List<String> nombresTablas) {
        this.nombresTablas = nombresTablas;
    }
    
    private void crearArchivoTabla(String nombre, String[] campos) throws IOException {
        String archivo = "archivos/" + nombre + ".csv";
        File ficheroTabla = new File(archivo);
        String a= Arrays.toString(campos);
        
        if (!ficheroTabla.getParentFile().exists())
            ficheroTabla.getParentFile().mkdirs();
        ficheroTabla.createNewFile();
                        
        FileWriter archivoWriter = new FileWriter(ficheroTabla);
        CsvWriter csvOutput = new CsvWriter(archivoWriter, ',');
        
        for (int i = 0; i<campos.length; i++) {
            //separarLongitud(campos[i]);
            csvOutput.write(campos[i]);
        }
        
        csvOutput.endRecord();
        csvOutput.flush();
        csvOutput.close();
    }
    
}
