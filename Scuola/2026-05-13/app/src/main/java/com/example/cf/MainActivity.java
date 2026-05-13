package com.example.cf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Dichiarazione delle View
    private TextInputEditText editTextCognome, editTextNome, editTextDataNascita;
    private AutoCompleteTextView autoCompleteComune;
    private RadioGroup radioGroupSesso;
    private Button buttonCalcola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inizializzazione delle View
        editTextCognome = findViewById(R.id.editTextCognome);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataNascita = findViewById(R.id.editTextDataNascita);
        autoCompleteComune = findViewById(R.id.autoCompleteComune);
        radioGroupSesso = findViewById(R.id.radioGroupSesso);
        buttonCalcola = findViewById(R.id.buttonCalcola);

        // Setup del DatePickerDialog per la data di nascita
        setupDatePicker();

        // Setup dell'AutoCompleteTextView per i comuni (con dati di esempio)
        setupComuniAutoComplete();

        // Imposta il listener per il pulsante di calcolo
        buttonCalcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avviaCalcolo();
            }
        });
    }

    private void setupDatePicker() {
        editTextDataNascita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ottieni la data corrente come default per il picker
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Il mese restituito è da 0 a 11, quindi aggiungi 1
                                String dataSelezionata = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year);
                                editTextDataNascita.setText(dataSelezionata);
                            }
                        }, year, month, day);

                // Imposta la data massima al giorno corrente per evitare date future
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    private void setupComuniAutoComplete() {
        // NOTA: In un'app reale, questa lista dovrebbe essere caricata da un database o un file.
        // Qui usiamo un array di esempio per la dimostrazione.
        String[] comuni = {"Roma", "Milano", "Napoli", "Torino", "Bologna", "Firenze", "Genova"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, comuni);
        autoCompleteComune.setAdapter(adapter);
    }

    private void avviaCalcolo() {
        // Recupera i dati dai campi
        String cognome = editTextCognome.getText().toString().trim();
        String nome = editTextNome.getText().toString().trim();
        String dataNascita = editTextDataNascita.getText().toString().trim();
        String comune = autoCompleteComune.getText().toString().trim();

        // Controlla che i campi non siano vuoti
        if (cognome.isEmpty() || nome.isEmpty() || dataNascita.isEmpty() || comune.isEmpty()) {
            Toast.makeText(this, "Per favore, compila tutti i campi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Recupera il sesso selezionato
        int selectedSessoId = radioGroupSesso.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedSessoId);
        String sesso = selectedRadioButton.getText().toString(); // "Maschio" o "Femmina"

        // Crea un Intent per avviare ResultActivity
        Intent intent = new Intent(MainActivity.this, RisultatoActivity.class);

        // Inserisci i dati come "extra" nell'Intent
        intent.putExtra("COGNOME", cognome);
        intent.putExtra("NOME", nome);
        intent.putExtra("DATA_NASCITA", dataNascita);
        intent.putExtra("SESSO", sesso);
        intent.putExtra("COMUNE_NASCITA", comune);

        // Avvia la nuova activity
        startActivity(intent);
    }
}