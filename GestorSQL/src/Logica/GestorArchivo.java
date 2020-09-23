/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Campos;
import Datos.CreadorTabla;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author paul
 */
public class GestorArchivo {
    private static String nombres[];
    private static final String PATH_ARCHIVO = "archivos/META_BD.csv";
    public static LinkedList<Campos> LongitudesCampos = new LinkedList<Campos>();
    public static boolean crearTabla(String text) {
        System.out.println("CREAR TABLA: "+text);
        try {
            
            File ficheroTabla = new File(PATH_ARCHIVO);
            
            FileWriter archivo = new FileWriter(ficheroTabla, true);
            CsvWriter csvOutput = new CsvWriter(archivo, ',');
            
            String nombreTabla;
            
            boolean campos = text.contains(" CAMPOS ");
            if ( campos ) {
                csvOutput.setDelimiter(',');
                int inicio = text.indexOf(" CAMPOS ");
                nombreTabla = text.substring(0, inicio);
                String tablas[] = text.substring(inicio + 8, text.length()).split(",");
                nombres = new String[tablas.length];
                for(int i=0;i<tablas.length;i++){
                    separarLongitud(tablas[i],i,nombreTabla,tablas.length);
                    
                }
                
                
                if ( CreadorTabla.getInstancia().addNombreTabla(nombreTabla, nombres) ) {
                    return true;
                } else {
                    csvOutput.write("0");
                    csvOutput.write(nombreTabla);
                    csvOutput.write("0");
                    csvOutput.write(nombres[0]);
                    csvOutput.setDelimiter(';');
                    
                    for (int i = 1; i<nombres.length; i++) {
                        
                        csvOutput.write(nombres[i]);
                    }
                    csvOutput.setDelimiter(' ');
                    csvOutput.write("\n");
                    csvOutput.endRecord();
                }              
            }

            csvOutput.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static List<Object[]> crearSalida() throws FileNotFoundException, IOException {  
        boolean alreadyExists = new File(PATH_ARCHIVO).exists();
        if(alreadyExists){

            CsvReader tablas_import = new CsvReader("archivos/META_BD.csv");
            List<Object[]> tabla = new ArrayList<Object[]>();

            while ( tablas_import.readRecord() ) {           
                Object tablas[] = tablas_import.getValues();
                if ( tablas[0].equals("0") ) {
                    tablas[3] = tablas[3].toString().replace(";", ",");
                    tabla.add(Arrays.copyOfRange(tablas, 1, tablas.length));  
                }

                for(int i=0; i<tablas.length; i++) {
                    System.out.println(tablas[i]);
                }               
            }
            tablas_import.close();
            return tabla;
        }
        else{
            System.out.println("no hay");
        }
        return null;
    }
    public static void separarLongitud(String palabras, int val,String nombre,int cantidad){
        
        int valor=0;
        int resta;
        String camp="";
        System.out.println(palabras.indexOf(0));
        System.out.println(palabras.indexOf("=")-1);
        if(palabras.contains("=")){
            valor = Integer.parseInt((String) palabras.subSequence(palabras.indexOf("=")+1, palabras.length()));
            camp = (String) palabras.subSequence(0, palabras.indexOf("="));
            resta= valor - camp.length();
            Campos agregar= new Campos(camp,valor,resta,nombre,cantidad);
            
            LongitudesCampos.add(agregar);
            nombres[val]=camp;
//LongitudesCampos.add([camp,valor]);
        }
    }
    
}
