package Metodos_Http;

import java.io.IOException;
// Para APIs
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Records.API_ExChange_CCD;
import Records.API_ExChange_CD;
import Records.API_ExChange_VTC;

public class API_ExCH {

    public static String API_key = "API_KEY_AQUÍ";

    // Para obtener todas las tasas de cambio de la divisa
    public static API_ExChange_VTC Get_API_VTC(String divisa) throws Exception, IOException, InterruptedException {
        
        String URL_VTC = "https://v6.exchangerate-api.com/v6/" + API_key + "/latest/" + divisa;
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_VTC)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        API_ExChange_VTC get_tasasDeCambio = gson.fromJson(json, API_ExChange_VTC.class);

        return get_tasasDeCambio;
                
    }

    // Para obtener el resultado de la conversión
    public static API_ExChange_CD Get_API_CD(String divisa_origen, String divisa_objetivo, String cantidad) throws Exception, IOException, InterruptedException {
        
        String URL_CD = "https://v6.exchangerate-api.com/v6/" + API_key + "/pair/" + divisa_origen + "/" + divisa_objetivo + "/" + cantidad;
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_CD)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        API_ExChange_CD pair_resultado = gson.fromJson(json, API_ExChange_CD.class);

        return pair_resultado;
                
    }

    // Para obtener los códigos de las divisas
    public static API_ExChange_CCD Get_API_CCD() throws Exception, IOException, InterruptedException {
        
        String URL_CCD = "https://v6.exchangerate-api.com/v6/" + API_key + "/codes"; 
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_CCD)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        API_ExChange_CCD codes = gson.fromJson(json, API_ExChange_CCD.class);

        return codes;
                
    }

}

