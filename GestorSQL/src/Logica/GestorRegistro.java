/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Campos;
import Datos.CreadorTabla;
import Datos.Registros;
import static Logica.GestorArchivo.LongitudesCampos;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author emily
 */
public class GestorRegistro {

    public static LinkedList<Registros> LongitudesRegistros = new LinkedList<Registros>();

    public static void crearTabla(String text, String nombreArchivo) throws IOException {
        //System.out.println("CREAR : "+text);

        File ficheroTabla = new File("archivos/" + nombreArchivo + ".csv");

        FileWriter archivo = new FileWriter(ficheroTabla, true);
        CsvWriter csvOutput = new CsvWriter(archivo, ',');

        boolean campo = text.contains(" VALOR ");
        int cont = 0;
        int cont2 = 0;
        int cont3 = 0;
        boolean ban = false;
        if (campo) {
            csvOutput.setDelimiter(',');
            int inicio = text.indexOf(" VALOR ");
            String campos[] = text.substring(inicio + 7, text.length()).split(",");
            System.out.println("campos del la tabla " + nombreArchivo + " : " + text.substring(inicio + 7, text.length()));
            for (int i = 0; i < LongitudesCampos.size() ; i++) {
                if ((LongitudesCampos.get(i).getNombre().equals(nombreArchivo)) && (LongitudesCampos.get(i).getTotalCam() == campos.length)&& ban != true) {
                    cont2 = LongitudesCampos.get(i).getTotalCam();
                    for (int j = 0; j < LongitudesCampos.size(); j++) {
                        if ((LongitudesCampos.get(i).getNombre().equals(nombreArchivo))) {
                            cont = j;
                            for (int z = 0; z < campos.length; z++) {
                               
                                
                                if (LongitudesCampos.get(cont).getValor() >= campos[z].length()) {
                                    System.out.println("Long: "+LongitudesCampos.get(cont).getValor()+"Nom:"+LongitudesCampos.get(cont).getCamp());
                                    System.out.println("Vector Long: "+campos[z].length()+" Valor: "+campos[z]);
                                    cont++;
                                    cont3++;
                                    ban = true;
                                }
                            }
                            System.out.println(cont);
                        }
                        break;
                    }

                }

            }

            if (cont3 == cont2) {
                System.out.println("entro");
                separarLongitud(campos, nombreArchivo, campos.length);

            } else {
                JOptionPane.showMessageDialog(null, "Unos sus campos ha sobrepasado la longitud especificada");
            }
        }

    }

    public static void separarLongitud(String palabras[], String nombre, int cantidad) {
        Registros reg = new Registros(nombre, palabras, cantidad);
        LongitudesRegistros.add(reg);

    }

}
