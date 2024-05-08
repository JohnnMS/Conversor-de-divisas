package Modulos;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import Records.API_ExChange_CCD;
import Records.API_ExChange_VTC;

public class Menus {
    // Menú general
    public static void menu_ppal() {
        String menu_ppal = """
                        ---------------------------------------------------------------------------
                        |                          Currency Exchange App                          |
                        ---------------------------------------------------------------------------
                        |>>>  Bienvenido a la app que realiza conversión de divisas.           <<<|
                        ---------------------------------------------------------------------------
                        |                                                                         |
                        |     1. Ver tasas de cambio.                                             |
                        |     2. Convertir divisas.                                               |
                        |     3. Historial de conversiones.                                       |
                        |     4. Consultar códigos de divisas.                                    |
                        |                                                                         |
                        |     Salir                                                               |
                        |                                                                         |
                        ---------------------------------------------------------------------------""";
        System.out.println(menu_ppal);
    }
    // Ver Tasas de Cambio menú tipo A
    public static void menu_VTC_A() {
        String menu_VTC_A = """
                        -------------------------------------------------------------------------------------
                        |                               Currency Exchange App                               |
                        -------------------------------------------------------------------------------------
                        |                                                                                   |
                        |     >>> Tasas de cambio.                                                          |
                        |                                                                                   |
                        |     Salir                                                                         |
                        |                                                                                   |
                        -------------------------------------------------------------------------------------           
                        """;
        System.out.println(menu_VTC_A);
    }
    // Ver Tasas de Cambio menú tipo B
    public static void menu_VTC_B(API_ExChange_VTC info_menu) {

        String ANSI_Reset = "\u001B[0m";  // Reiniciar el color
        String ANSI_Magenta = "\u001B[95;1m";  

        String menu_VTC_B = """
                        -------------------------------------------------------------------------------------
                        |                               Currency Exchange App                               |
                        -------------------------------------------------------------------------------------
                        |                                                                                   |
                        |     >>> Tasas de cambio para divisa %s.                                          |
                        |                                                                                   |
                        |     Salir                                                                         |
                        |                                                                                   |
                        -------------------------------------------------------------------------------------
                        """;
        System.out.printf(menu_VTC_B, ANSI_Magenta + info_menu.base_code() + ANSI_Reset);

        String info_VTC = info_menu.conversion_rates().toString();
        String code = info_menu.base_code();

        String[] pares_divisas = info_VTC.replaceAll("[{} ]", "").split(",");
                
        // Crear un Map para almacenar las tasas de cambio
        Map<String, Double> tasasDeCambio = new HashMap<>();

        // Iterar sobre los pares y agregar al Map
        for (String par : pares_divisas) {
            String[] claveValor = par.split("=");
            String moneda = claveValor[0];
            Double tasa = Double.parseDouble(claveValor[1]);
            tasasDeCambio.put(moneda, tasa);
        }

        // Crear un TreeMap para ordenar las claves
        Map<String, Double> tasasOrdenadas = new TreeMap<>(tasasDeCambio);

        // Mostrar las tasas de cambio ordenadas alfabéticamente
        int i = 0;
        // Imprimo en columnas las divisas
        for (Map.Entry<String, Double> entry : tasasOrdenadas.entrySet()) {
            // Imprime de corrido 
            System.out.printf("| " + code + " -> " + "%-2s: %10.3f    ", entry.getKey(), entry.getValue()); 
            i++;
            // Cada 3 conteos baja
            if (i % 3 == 0) {
                System.out.println("|\n-------------------------------------------------------------------------------------");
            }

        }
    }
    // Convertir Divisas menú inicial
    public static void menu_CD() {
        
        String ANSI_Reset = "\u001B[0m";  // Reiniciar el color
        String ANSI_Morado = "\u001B[95;1m";    
        String ANSI_Verde = "\u001B[32m";  
        
        String menu_CD = """
                        ---------------------------------------------------------------------------
                        |                          Currency Exchange App                          |
                        ---------------------------------------------------------------------------
                        |                                                                         |
                        |     >>> Cantidad y código de la divisa de origen:                       |
                        |         Cantidad:  %s                                                  |
                        |         Divisa:    %s                                                  |
                        |                                                                         |
                        |     >>> Código de la divisa objetivo:                                   |
                        |         Divisa:    %s                                                  |
                        |                                                                         |
                        |     >>> Resultado: %s                                                  |
                        |                                                                         | 
                        |     Salir                                                               |
                        |                                                                         |
                        ---------------------------------------------------------------------------
                        """;
        System.out.printf(menu_CD, ANSI_Verde + "***" + ANSI_Reset, ANSI_Verde + "***" + ANSI_Reset, ANSI_Morado + "***" + ANSI_Reset, ANSI_Morado + "***" + ANSI_Reset);
    }
    // Convertir Divisas menú tipo A
    public static void menu_CD_A(String cantidad, String divisa_origen, String divisa_objetivo, String resultado, String moneda) {
        
        String ANSI_Reset = "\u001B[0m";  // Reiniciar el color
        String ANSI_Morado = "\u001B[95;1m";    
        String ANSI_Verde = "\u001B[32m";          
        
        String menu_CD_A = """
                        ---------------------------------------------------------------------------
                        |                          Currency Exchange App                          |
                        ---------------------------------------------------------------------------
                        |                                                                         |
                        |     >>> Cantidad y código de la divisa de origen:                       |
                        |         Cantidad:  %s                                                    
                        |         Divisa:    %s                                                  | 
                        |                                                                         |
                        |     >>> Código de la divisa objetivo:                                   |
                        |         Divisa:    %s                                                  |
                        |                                                                         |
                        |     >>> Resultado: %s %s
                        |                                                                         |
                        |     Salir                                                               |
                        |                                                                         |
                        ---------------------------------------------------------------------------
                        """;                      
        System.out.printf(menu_CD_A, ANSI_Verde + cantidad + ANSI_Reset, ANSI_Verde + divisa_origen.toUpperCase() + ANSI_Reset, ANSI_Morado + divisa_objetivo.toUpperCase() + ANSI_Reset, "$ "+ ANSI_Morado + resultado + ANSI_Reset, ANSI_Morado + moneda + ANSI_Reset);
    }
    // Historial de Transacciones
    public static void menu_H() {
        String menu_H = """
                        ---------------------------------------------------------------------------
                        |                          Currency Exchange App                          |
                        ---------------------------------------------------------------------------
                        |                                                                         |
                        |     >>> Historial de conversiones.                                      |
                        |                                                                         |
                        |     Borrar                                                              |
                        |     Salir                                                               |
                        |                                                                         |
                        ---------------------------------------------------------------------------
                        |     ¡No hay historial disponible!                                       |
                        ---------------------------------------------------------------------------""";
        System.out.println(menu_H);
    }
    // Historial de Transacciones tipo A, con contenido   
    public static void menu_H_A(String historico) {
        String menu_H_A = """
                        ---------------------------------------------------------------------------
                        |                          Currency Exchange App                          |
                        ---------------------------------------------------------------------------
                        |                                                                         |
                        |     >>> Historial de conversiones.                                      |
                        |                                                                         |
                        |     Borrar                                                              |
                        |     Salir                                                               |
                        |                                                                         |
                        ---------------------------------------------------------------------------""";
        System.out.println(menu_H_A);

        String[] Array = historico.split("\n");
        
        String margen = "";
        String caracter_esp = " ";  
        int delta_espacios = 0;
        int letras_iniciales = 0;

        for (String entry : Array) {
            
            letras_iniciales = entry.length();
            delta_espacios = 68 - letras_iniciales;
            margen = caracter_esp.repeat(delta_espacios);
            System.out.printf("|     %s" + margen + "|", entry);
            System.out.println("\n---------------------------------------------------------------------------");

        }

    }
    // Consultar Códigos de Divisas tipo A
    public static void menu_CCD_A() {
        String menu_CCD_A = """
                        -------------------------------------------------------------------------------------
                        |                               Currency Exchange App                               |
                        -------------------------------------------------------------------------------------
                        |                                                                                   |
                        |     >>> Códigos de divisas disponibles.                                           |
                        |                                                                                   |
                        |     Salir                                                                         |
                        |                                                                                   |
                        -------------------------------------------------------------------------------------
                        """;
        System.out.println(menu_CCD_A);
    }
    // Consultar Códigos de Divisas tipo B
    public static void menu_CCD_B(API_ExChange_CCD codes) {
        String menu_CCD_B = """
                        -------------------------------------------------------------------------------------
                        |                               Currency Exchange App                               |
                        -------------------------------------------------------------------------------------
                        |                                                                                   |
                        |     >>> Códigos de divisas disponibles.                                           |
                        |                                                                                   |
                        |     Salir                                                                         |
                        |                                                                                   |
                        -------------------------------------------------------------------------------------""";
        System.out.println(menu_CCD_B);

        String codes_menu = codes.supported_codes().toString();
       
        codes_menu = codes_menu.replaceAll("\\[", "");
        codes_menu = codes_menu.replaceAll("]]", "],");
        codes_menu = codes_menu.replaceAll(" ", "");  

        String[] Array_codes = codes_menu.split("],");
        
        Map<String, String> Map_codes = new HashMap<>();
        
        for (String par : Array_codes) {
            String[] claveValor = par.split(",");
            String moneda = claveValor[0];
            String name = claveValor[1];
            Map_codes.put(moneda, name); 
        }

        Map<String, String> Map_codes_ordenado = new TreeMap<>(Map_codes);

        String margen = "";
        String caracter_esp = " ";
        String nombre_divisa = "";
        int delta_espacios = 0;
        int letras_iniciales = 0; 

        for (Map.Entry<String, String> entry : Map_codes_ordenado.entrySet()) {

            nombre_divisa = entry.getValue();
            letras_iniciales = nombre_divisa.length();
            delta_espacios = 70 - letras_iniciales;
            margen = caracter_esp.repeat(delta_espacios);

            System.out.printf("|     %s -> %s." + margen + "|", entry.getKey(), entry.getValue());
            System.out.println("\n-------------------------------------------------------------------------------------");
            
        }

    }

}
