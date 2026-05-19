package com.example.mystore;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.model.Prodotto;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.model.Negozio;
import com.example.model.Prodotto;
import com.bumptech.glide.Glide;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ImageView imgProd;
    private TextView nomeProd, categoriaProd, prezzoProd, descrizioneProd;
    private Button loadProductButton;
    private ProgressBar progressBar;
    private Negozio negozioClient;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Collega gli elementi dell'interfaccia usando i nuovi ID
        imgProd = findViewById(R.id.imgProd);
        nomeProd = findViewById(R.id.nomeProd);
        categoriaProd = findViewById(R.id.categoriaProd);
        prezzoProd = findViewById(R.id.prezzoProd);
        descrizioneProd = findViewById(R.id.descrizioneProd);
        loadProductButton = findViewById(R.id.loadProductButton);
        progressBar = findViewById(R.id.progressBar);

        // client API
        negozioClient = new Negozio();

        // listner bottone
        loadProductButton.setOnClickListener(v -> {
            fetchRandomProduct();
        });

        // temp: carica prodotto all'avvio
        fetchRandomProduct();
    }

    private void fetchRandomProduct() {
        // mostra caricamento
        progressBar.setVisibility(View.VISIBLE);
        loadProductButton.setEnabled(false);
        // Nascondi i dettagli del prodotto mentre si carica
        setProductDetailsVisibility(View.INVISIBLE);

        executor.execute(() -> {
            try {
                final Prodotto prodotto = negozioClient.getRandomProduct();
                handler.post(() -> updateUiWithProduct(prodotto));
            } catch (IOException e) {
                e.printStackTrace();
                handler.post(() -> showError("Impossibile caricare il prodotto. Controlla la connessione."));
            }
        });
    }

    private void updateUiWithProduct(Prodotto prodotto) {
        // abilita btn e togli loading
        progressBar.setVisibility(View.GONE);
        loadProductButton.setEnabled(true);

        if (prodotto != null) {
            // riempi txtview con info prodotto
            nomeProd.setText(prodotto.getTitle());
            prezzoProd.setText(String.format("%.2f €", prodotto.getPrice())); //formato prezzo
            categoriaProd.setText(prodotto.getCategory());
            descrizioneProd.setText(prodotto.getDescription());

            // glide per importare img da url
            Glide.with(this) // this = main activity
                    .load(prodotto.getImage()) // ottieni url
                    .into(imgProd); // imgvw destinazione

            setProductDetailsVisibility(View.VISIBLE);
        } else {
            showError("Prodotto non trovato.");
        }
    }

    private void showError(String message) { //mostra toast per errori
        progressBar.setVisibility(View.GONE);
        loadProductButton.setEnabled(true);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // imposta visibilità rapidamente
    private void setProductDetailsVisibility(int visibility) {
        imgProd.setVisibility(visibility);
        nomeProd.setVisibility(visibility);
        categoriaProd.setVisibility(visibility);
        prezzoProd.setVisibility(visibility);
        descrizioneProd.setVisibility(visibility);
    }
}