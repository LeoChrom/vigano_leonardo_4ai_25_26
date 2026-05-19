package com.example.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Random;


public class Negozio {

    private static final String BASE_URL = "https://fakestoreapi.com";
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Codice inatteso " + response);
            }
            ResponseBody body = response.body();
            return (body != null) ? body.string() : "";
        }
    }

    /**
     * Ottiene un singolo prodotto casuale dall'API in modo efficiente.
     */
    public Prodotto getRandomProduct() throws IOException {
        // 20 prodotti
        // TODO valore dinamico
        int totalProducts = 20;

        int randomId = new Random().nextInt(totalProducts) + 1;
        System.out.println("Estraggo il prodotto con ID: " + randomId);

        // ottieni prod
        String productJson = run(BASE_URL + "/products/" + randomId);

        // converti json in oggetto
        return objectMapper.readValue(productJson, Prodotto.class);
    }
}