package Historico_data;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.File;

public class Historico_data_file {

    public static void Save_data(String divisa_origen, String cantidad, String divisa_objetivo, String resultado) throws IOException {

        // Consulto fecha
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");
        String fechaHoraFormateada = fechaHoraActual.format(formato);
        String fecha_guardar = "[" + fechaHoraFormateada + "]";
        
        try {
            
            File archivo = new File("Historico.txt");
            Scanner scanner = new Scanner(archivo);
            String lectura = scanner.useDelimiter("\\Z").next();
            String linea = String.format(lectura + "\n%s  >>>  %s %-10s -> %s %-12s\n", fecha_guardar, divisa_origen.toUpperCase(), cantidad, divisa_objetivo.toUpperCase(), resultado);
            FileWriter historico = new FileWriter("Historico.txt");
            historico.write(linea);
            historico.close();
            scanner.close();
            
        } catch (Exception e) {
            
            FileWriter historico = new FileWriter("Historico.txt");
            String linea = String.format("%s  >>>  %s %-10s -> %s %-12s\n", fecha_guardar, divisa_origen.toUpperCase(), cantidad, divisa_objetivo.toUpperCase(), resultado);
            historico.write(linea);
            historico.close();

        }
           
    }

    public static String Ver_data() throws IOException {

        try {
            
            File archivo = new File("Historico.txt");
            Scanner scanner = new Scanner(archivo);
            String lectura = scanner.useDelimiter("\\Z").next();
            scanner.close();

            return lectura;

        } catch (Exception e) {
            
            System.out.println("No se encontró historial de conversiones...");
            
            return null;

        }
        
    }

    public static void Borra_data() throws IOException {

        FileWriter historico = new FileWriter("Historico.txt");
        historico.write("");
        historico.close();

    }

}
