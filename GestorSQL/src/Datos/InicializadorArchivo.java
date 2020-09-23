/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.GestorArchivo;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class InicializadorArchivo {
    
    public static boolean sobreescribirDatos( String PATH_ARCHIVO) throws IOException {
        
        boolean alreadyExists = new File(PATH_ARCHIVO).exists();
        
        if ( alreadyExists ) {
            
            File ficheroAux = new File(PATH_ARCHIVO);
            System.out.println("ABRIO");
            List<Object[]> tablas = GestorArchivo.crearSalida();
            
            for (int i = 0; i < tablas.size(); i++) {     
                String nombreArchivoTabla = "archivos/" + tablas.get(i)[0].toString() + ".csv";
                File archivo = new File(nombreArchivoTabla);
                archivo.delete();
            }


            CsvReader file= new CsvReader(PATH_ARCHIVO);
            file.close();
            
            ficheroAux.delete();
                
                
            System.out.println("BORRO");
        }
        
        /*File ficheroTablas = new File(PATH_ARCHIVO);
        if ( !ficheroTablas.getParentFile().exists() )
            ficheroTablas.getParentFile().mkdirs();
        ficheroTablas.createNewFile();*/
        
       
        return alreadyExists;
        
    }
    
    public static boolean recuperarDatos(final String PATH_ARCHIVO) throws IOException {
        
        File ficheroTablas = new File(PATH_ARCHIVO);      
        boolean parentAlreadyExists = ficheroTablas.getParentFile().exists();
        boolean alreadyExists = new File(PATH_ARCHIVO).exists();
        
        
        if ( !parentAlreadyExists || !alreadyExists ) {
            ficheroTablas.getParentFile().mkdirs();
            ficheroTablas.createNewFile();
        } else {
            List<Object[]> tablas = GestorArchivo.crearSalida();
            String a= tablas.toString();
            System.out.println(a);
            for (int i = 0; i < tablas.size(); i++) {
                CreadorTabla.getInstancia().addNombreTabla((String) tablas.get(i)[0], tablas.get(i)[2].toString().split(",") );
            }
            
        }
        
        return parentAlreadyExists && alreadyExists;
        
    }
    
}
