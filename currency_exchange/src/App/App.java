package App;
import java.util.InputMismatchException;
// Uso general
import java.util.Scanner;
import java.io.IOException;
import java.net.ConnectException;

// Módulos
import Excepciones.Console_cmd;
import Historico_data.Historico_data_file;
import Metodos_Http.API_ExCH;
import Modulos.Menus;
import Records.API_ExChange_CCD;
import Records.API_ExChange_CD;
import Records.API_ExChange_VTC;

public class App {

    public static void main(String[] args) throws Exception, IOException, InterruptedException {
        
        var lectura = new Scanner(System.in);
        String ANSI_Reset = "\u001B[0m";  // Reinicia el color
        String ANSI_Rojo = "\u001B[31m";    
        String ANSI_Verde = "\u001B[32m";  
        String ANSI_Amarillo = "\u001B[93m";
        String ANSI_Morado = "\u001B[95;1m";
        
        Console_cmd.Clear_cmd();
        // Do-While global 
        do {

            Menus.menu_ppal();

            System.out.println(ANSI_Amarillo + "\nEscriba el número de opción o escriba 'salir' para finalizar:" + ANSI_Reset);
            String opcion_usuario = lectura.nextLine();
            opcion_usuario = opcion_usuario.trim();
             
            if (opcion_usuario.equalsIgnoreCase("salir")) {
                break;
            }

            switch (opcion_usuario) {
                case "1":
                    // llamada al módulo "Tasa de cambio"             
                    do {
                        
                        Console_cmd.Clear_cmd();
                        Menus.menu_VTC_A();    
                        // Esperar opcion de usuario consultar nueva moneda o salir

                        String opcion_VTC_A = "";
                        System.out.println(ANSI_Amarillo + "\nIngrese el código de la divisa que desea consultar o 'salir' para ir al menú: " + ANSI_Reset);
                        do {
                            try {
                                opcion_VTC_A = lectura.nextLine();
                            } finally {
                                if (opcion_VTC_A.matches("[A-Za-z]{3}") || opcion_VTC_A.equalsIgnoreCase("salir")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Introduce únicamente tres letras en este campo o 'salir' para ir al menú. ¡Inténtalo de nuevo!" + ANSI_Reset);
                                }
                            }
                        } while (true);

                        opcion_VTC_A = opcion_VTC_A.trim().toUpperCase();
                        
                        if (opcion_VTC_A.equalsIgnoreCase("salir")) {
                            break;
                        }
                        
                        // Enviar moneda para consultar información de tasas
                        API_ExChange_VTC info_API_VTC = null;

                        try {

                            info_API_VTC = API_ExCH.Get_API_VTC(opcion_VTC_A);
        
                            if (info_API_VTC.result().equalsIgnoreCase("error")) {
                                System.err.println(ANSI_Rojo + "No se pudo obtener respuesta del servidor. \nVerifique la información ingresada o Intente más tarde.\n" + ANSI_Reset);
                                System.err.println(ANSI_Rojo + "Código de error servidor: " + info_API_VTC.error_Type() + ANSI_Reset + ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();   
                            } else {
                                Console_cmd.Clear_cmd();
                                Menus.menu_VTC_B(info_API_VTC);
                                System.out.println(ANSI_Amarillo + "\nPresione 'Enter' para iniciar otra consulta..." + ANSI_Reset);
                                lectura.nextLine();
                            }    

                        } catch (ConnectException e) {
                            System.err.println(ANSI_Rojo + "Error de conexión: No se pudo conectar al servidor. \nMensaje: " + "Error al intentar conectar la app a una dirección remota y un puerto. \nNormalmente, la conexión fue rechazada o no tiene acceso a internet." + ANSI_Reset);
                            //e.printStackTrace(); permite llamar todas las líneas de codigo donde se generaron errores. Buena opción adicional para log de errores
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();
                            
                        } catch (IOException e) {
                            System.err.println(ANSI_Rojo + "Error de entrada/salida: " + e.getMessage() + ANSI_Reset);
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();
                            
                        } catch (Exception e) {
                            System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();
                        } 
                        
                    } while (true);                                                      
                    break;
                
                case "2":
                    // llamada al módulo "convertir divisas"
                    do {

                        Console_cmd.Clear_cmd();
                        Menus.menu_CD();

                        // Esperar cantidad
                        int cantidad = 0;
                        System.out.println(ANSI_Verde + "\nIngrese la cantidad de dinero: " + ANSI_Reset);
                        do {
                            try {
                                cantidad = lectura.nextInt();
                                lectura.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_Rojo + "Introduce únicamente números en este campo. ¡Inténtalo de nuevo!" + ANSI_Reset);
                                lectura.nextLine();
                            } catch (Exception e) {
                                System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();
                            } finally {
                                if (cantidad != 0) {
                                    break;
                                }   
                            }
                        } while (true);
                        
                        // Envio cantidad y publico en menú
                        Console_cmd.Clear_cmd();
                        Menus.menu_CD_A(String.valueOf(cantidad), "***", "***", "***", " ");
                        
                        // Espero divisa de origen
                        String divisa_origen = "";
                        System.out.println(ANSI_Verde + "\nIngrese el código de la divisa de origen: " + ANSI_Reset);
                        do {
                            try {
                                divisa_origen = lectura.nextLine();
                            } catch (Exception e) {
                                System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine(); 
                            } finally {
                                if (divisa_origen.matches("[A-Za-z]{3}")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Introduce únicamente tres letras en este campo. ¡Inténtalo de nuevo!" + ANSI_Reset);
                                }
                            }
                        } while (true);
                        
                        // Envio divisa origen y publico en menú
                        Console_cmd.Clear_cmd();
                        Menus.menu_CD_A(String.valueOf(cantidad), divisa_origen, "***", "***", " ");
                       
                        // Espero divisa objetivo
                        String divisa_objetivo = "";
                        System.out.println(ANSI_Morado + "\nIngrese el código de la divisa objetivo: " + ANSI_Reset);
                        do {
                            try {
                                divisa_objetivo = lectura.nextLine();
                            } catch (Exception e) {
                                System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine(); 
                            } finally {
                                if (divisa_objetivo.matches("[A-Za-z]{3}")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Introduce únicamente tres letras en este campo. ¡Inténtalo de nuevo!" + ANSI_Reset);
                                }
                            }
                        } while (true);

                        // Envio divisa objetivo y publico en menú
                        Console_cmd.Clear_cmd();
                        Menus.menu_CD_A(String.valueOf(cantidad), divisa_origen, divisa_objetivo, "***", " ");

                        System.out.println(ANSI_Amarillo + "\nVerifique la información ingresada. ¿Desea continuar con la conversión? (si/no)" + ANSI_Reset);
                        String consulta_ok = "";
                        
                        do {
                            consulta_ok = lectura.nextLine();
                            if (consulta_ok.equalsIgnoreCase("si") || consulta_ok.equalsIgnoreCase("no") ) {
                                break;
                            } else {
                                System.out.println(ANSI_Rojo + "Introduce únicamente si/no en este campo." + ANSI_Reset);
                            }

                        } while (true);
                        
                    
                        if (consulta_ok.equalsIgnoreCase("si")) {
        
                            API_ExChange_CD resultado_CD = null;
                            try {
                                resultado_CD = API_ExCH.Get_API_CD(divisa_origen.toUpperCase(), divisa_objetivo.toUpperCase(), String.valueOf(cantidad));

                                if (resultado_CD.result().equalsIgnoreCase("error")) {
                                    System.err.println(ANSI_Rojo + "No se pudo obtener respuesta del servidor. \nVerifique la información ingresada o Intente más tarde.");
                                    System.err.println("\nCódigo de error servidor: " + resultado_CD.error_Type() + ANSI_Reset + ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                    lectura.nextLine();
                                } else {
                                    Console_cmd.Clear_cmd();
                                    Menus.menu_CD_A(String.valueOf(cantidad), divisa_origen, divisa_objetivo, resultado_CD.conversion_result(), resultado_CD.target_code());
                                    Historico_data_file.Save_data(divisa_origen,String.valueOf(cantidad), divisa_objetivo, resultado_CD.conversion_result());
                                }
                    
                            } catch (ConnectException e) {
                                System.err.println(ANSI_Rojo + "Error de conexión: No se pudo conectar al servidor. \nMensaje: " + "Error al intentar conectar la app a una dirección remota y un puerto. \nNormalmente, la conexión fue rechazada o no tiene acceso a internet." + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();
                            } catch (IOException e) {
                                System.err.println(ANSI_Rojo + "Error de entrada/salida: " + e.getMessage() + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();   
                            } catch (Exception e) {
                                System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                                System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();
                            } 
                            
                        } else {
                            cantidad = 0;
                            divisa_origen = "";
                            divisa_objetivo = "";
                            break;
                        }

                        System.out.println(ANSI_Amarillo + "\nPresione 'Enter' para realizar otra conversión o escriba 'salir' para ir al menú..." + ANSI_Reset);
                        String consulta_salir = lectura.nextLine();

                        if (consulta_salir.equalsIgnoreCase("salir")) {
                            break;
                        }

                    } while (true);
                    break;
                
                case "3":
                    // llamada al módulo "historial de transacciones"
                    do {

                        String historico = Historico_data_file.Ver_data();
                        String consulta_salir = "";

                        if (historico == null) {
                            Console_cmd.Clear_cmd();
                            Menus.menu_H();
                            System.out.println(ANSI_Amarillo + "\nEscriba 'salir' para ir al menú..." + ANSI_Reset);
                            do {
                                consulta_salir = lectura.nextLine();
                                if (consulta_salir.equalsIgnoreCase("salir")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Opción válida 'salir'..." + ANSI_Reset);
                                }
                            } while (true);

                        } else {
                            Console_cmd.Clear_cmd();
                            Menus.menu_H_A(historico);
                            System.out.println(ANSI_Amarillo + "\nEscriba 'salir' para ir al menú o escriba " + ANSI_Rojo + "'borrar'" + ANSI_Reset + ANSI_Amarillo + " para eliminar el historial..." + ANSI_Reset);
                            do {
                                consulta_salir = lectura.nextLine();
                                if (consulta_salir.equalsIgnoreCase("salir") || consulta_salir.equalsIgnoreCase("borrar") ) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Opciones válidas 'salir' o 'borrar'..." + ANSI_Reset);
                                }
                            } while (true);
                        }
                     
                        if (consulta_salir.equalsIgnoreCase("salir")) {
                            break;
                        } else if (consulta_salir.equalsIgnoreCase("borrar") && historico != null) {

                            System.out.println(ANSI_Rojo + "\nEstá a punto de borrar el historial. ¿Desea continuar? (si/no)" + ANSI_Reset);
                            String consulta_borrar = "";

                            do {
                                consulta_borrar = lectura.nextLine();
                                if (consulta_borrar.equalsIgnoreCase("si") || consulta_borrar.equalsIgnoreCase("no") ) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Introduce únicamente si/no en este campo." + ANSI_Reset);
                                }
    
                            } while (true);

                            if (consulta_borrar.equalsIgnoreCase("si")) {

                                Historico_data_file.Borra_data();
                                System.out.println(ANSI_Amarillo + "\nEl historial ha sido eliminado. Presione 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine();

                            } else {
                                break;
                            }

                        }

                    } while (true);
                    break;
               
                case "4":
                    
                    do {
                        // llamada al módulo "Consultar códigos"
                        Console_cmd.Clear_cmd();
                        Menus.menu_CCD_A();
                        // Hago consulta API
                        API_ExChange_CCD codes_API = null;
                        try {
                            codes_API = API_ExCH.Get_API_CCD();
                            if (codes_API.result().equalsIgnoreCase("error")) {
                                System.out.println(ANSI_Rojo + "No se pudo obtener respuesta del servidor. Intente más tarde.");
                                System.out.println("\nCódigo de error servidor: " + codes_API.error_Type() + ANSI_Reset + ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                                lectura.nextLine(); 
                            } else {
                                Console_cmd.Clear_cmd();
                                Menus.menu_CCD_B(codes_API);    
                            }    
                        } catch (ConnectException e) {
                            System.err.println(ANSI_Rojo + "Error de conexión: No se pudo conectar al servidor. \nMensaje: " + "Error al intentar conectar la app a una dirección remota y un puerto. \nNormalmente, la conexión fue rechazada o no tiene acceso a internet." + ANSI_Reset);
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();
                        } catch (IOException e) {
                            System.err.println(ANSI_Rojo + "Error de entrada/salida: " + e.getMessage() + ANSI_Reset);
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();   
                        } catch (Exception e) {
                            System.err.println(ANSI_Rojo + "Error inesperado: " + e.getMessage() + ANSI_Reset);
                            System.out.println(ANSI_Amarillo + "\n\nPresione tecla 'Enter' para continuar..." + ANSI_Reset);
                            lectura.nextLine();
                        }

                        // Espero opción persistete de salir de usuario 
                        System.out.println(ANSI_Amarillo + "\nEscriba 'salir' para ir al menú:" + ANSI_Reset);
                        String consulta_salir = "";
                        do {
                            try {
                               consulta_salir = lectura.nextLine(); 
                            } finally {
                                if (consulta_salir.equalsIgnoreCase("salir")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_Rojo + "Opción válida 'salir'..." + ANSI_Reset);
                                }
                            }
                        } while (true);

                        if (consulta_salir.equalsIgnoreCase("salir")) {
                            break;
                        }
                
                    } while (true);

                    break;                    

                default:
                    System.out.println(ANSI_Rojo + "¡Seleccione una opción válida!");
                    System.out.println("\nPresione 'Enter' e inténtelo de nuevo..." + ANSI_Reset);
                    lectura.nextLine();
                    break;
            }

            Console_cmd.Clear_cmd();

        } while (true);
        
        lectura.close();
    
    }

}
