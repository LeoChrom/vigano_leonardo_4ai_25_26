package com.example.cf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RisultatoActivity extends AppCompatActivity {

    private TextView textViewCodiceFiscale;
    private Button buttonIndietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultato);

        textViewCodiceFiscale = findViewById(R.id.textViewCodiceFiscale);
        buttonIndietro = findViewById(R.id.buttonIndietro);

        // Recupera i dati dall'Intent
        Intent intent = getIntent();
        String cognome = intent.getStringExtra("COGNOME");
        String nome = intent.getStringExtra("NOME");
        String dataNascitaStr = intent.getStringExtra("DATA_NASCITA"); // formato gg/mm/aaaa
        String sessoStr = intent.getStringExtra("SESSO");
        String comune = intent.getStringExtra("COMUNE_NASCITA");

        try {
            // 1. Converti i dati nel formato richiesto da CodiceFiscaleUtils
            LocalDate dataNascita = parseDate(dataNascitaStr);
            char sesso = parseSesso(sessoStr);

            // 2. Chiama il metodo statico della classe di utility per il calcolo
            String cf = com.example.cf.Model.CodiceFiscaleUtils.calcolaCodiceFiscaleCompleto(
                    nome,
                    cognome,
                    dataNascita,
                    sesso,
                    comune
            );

            // 3. Mostra il risultato
            textViewCodiceFiscale.setText(cf);

        } catch (DateTimeParseException e) {
            mostraErrore("Formato data non valido. Usa gg/mm/aaaa.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // Cattura gli errori lanciati da CodiceFiscaleUtils (es. comune non trovato)
            mostraErrore("Errore nei dati: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Cattura qualsiasi altro errore imprevisto
            mostraErrore("Si è verificato un errore inaspettato.");
            e.printStackTrace();
        }

        buttonIndietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Termina questa activity e torna alla MainActivity
                finish();
            }
        });
    }

    /**
     * Converte una stringa di data "gg/mm/aaaa" in un oggetto LocalDate.
     * Richiede API level 26 (Android 8.0) o superiore.
     */
    private LocalDate parseDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * Converte una stringa "Maschio" o "Femmina" nel carattere 'M' o 'F'.
     */
    private char parseSesso(String sessoStr) {
        if (sessoStr != null && sessoStr.equalsIgnoreCase("Femmina")) {
            return 'F';
        }
        return 'M'; // Default a Maschio
    }

    /**
     * Mostra un messaggio di errore sia nel Toast che nella TextView principale.
     */
    private void mostraErrore(String messaggio) {
        Toast.makeText(this, messaggio, Toast.LENGTH_LONG).show();
        textViewCodiceFiscale.setText("CALCOLO FALLITO");
    }
}