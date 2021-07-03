/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import java.util.ArrayList;
import paquete2.*;
import paquete3.*;

public class Ejecutor {

    public static void main(String[] args) {

        // nombre del archivo
        String nombreArchivo = "pasajes.data";
        ArrayList<PasajeInterCantonal> pasajes = new ArrayList<>();
        
        PasajeNormal pasajeNormal = new PasajeNormal("Jonathan",
                "12345", "Loja", "Cuenca", 200, 25, 10);
        
        PasajeTerceraEdad pasajeTerceraEdad = new PasajeTerceraEdad("Jossue",
                "987654", "Zamora", "Cariamanga", 80, 20);

        PasajeMenorEdad pasajeMenorEdad = new PasajeMenorEdad("Diego", "1123456",
                "Loja", "Malacatos",30, 10, 20);
        
        PasajeUniversitario pasajeUniversitario = new PasajeUniversitario("Jairo", 
                "12564", "Catamayo",
                "Loja", 45, 3.50, "UTPL");

        pasajes.add(pasajeMenorEdad);
        pasajes.add(pasajeUniversitario);
        pasajes.add(pasajeNormal);
        pasajes.add(pasajeTerceraEdad);
        
        for (int i = 0; i < pasajes.size(); i++) {
            pasajes.get(i).establecerValPasaje();
        }

        
        
        EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(nombreArchivo);

        for (int i = 0; i < pasajes.size(); i++) {
            
            // establecer el valor del atributo registro
            archivo.establecerRegistro(pasajes.get(i));
            // establecer en el archivo el atributo del registro
            archivo.establecerSalida();
        }

        archivo.cerrarArchivo();

        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerListaPasajes();
        System.out.println(lectura);
        lectura.cerrarArchivo();
    }
}
