package com.example.cf.Model;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility statica per il calcolo del Codice Fiscale italiano.
 * Questa versione è stata revisionata e corretta per aderire agli standard di calcolo.
 */
public final class CodiceFiscaleUtils {

    private CodiceFiscaleUtils() {
        throw new UnsupportedOperationException("Classe utility non istanziabile");
    }

    private static final String VOCALI = "AEIOU";

    private static final Map<Character, Integer> VALORI_DISPARI = new HashMap<>();
    private static final Map<Character, Integer> VALORI_PARI = new HashMap<>();
    private static final Map<String, String> COMUNI = new HashMap<>();

    static {
        // Valori posizione dispari
        VALORI_DISPARI.put('0', 1); VALORI_DISPARI.put('1', 0); VALORI_DISPARI.put('2', 5);
        VALORI_DISPARI.put('3', 7); VALORI_DISPARI.put('4', 9); VALORI_DISPARI.put('5', 13);
        VALORI_DISPARI.put('6', 15); VALORI_DISPARI.put('7', 17); VALORI_DISPARI.put('8', 19);
        VALORI_DISPARI.put('9', 21); VALORI_DISPARI.put('A', 1); VALORI_DISPARI.put('B', 0);
        VALORI_DISPARI.put('C', 5); VALORI_DISPARI.put('D', 7); VALORI_DISPARI.put('E', 9);
        VALORI_DISPARI.put('F', 13); VALORI_DISPARI.put('G', 15); VALORI_DISPARI.put('H', 17);
        VALORI_DISPARI.put('I', 19); VALORI_DISPARI.put('J', 21); VALORI_DISPARI.put('K', 2);
        VALORI_DISPARI.put('L', 4); VALORI_DISPARI.put('M', 18); VALORI_DISPARI.put('N', 20);
        VALORI_DISPARI.put('O', 11); VALORI_DISPARI.put('P', 3); VALORI_DISPARI.put('Q', 6);
        VALORI_DISPARI.put('R', 8); VALORI_DISPARI.put('S', 12); VALORI_DISPARI.put('T', 14);
        VALORI_DISPARI.put('U', 16); VALORI_DISPARI.put('V', 10); VALORI_DISPARI.put('W', 22);
        VALORI_DISPARI.put('X', 25); VALORI_DISPARI.put('Y', 24); VALORI_DISPARI.put('Z', 23);

        // Valori posizione pari (CORRETTI)
        VALORI_PARI.put('0', 0); VALORI_PARI.put('1', 1); VALORI_PARI.put('2', 2);
        VALORI_PARI.put('3', 3); VALORI_PARI.put('4', 4); VALORI_PARI.put('5', 5);
        VALORI_PARI.put('6', 6); VALORI_PARI.put('7', 7); VALORI_PARI.put('8', 8);
        VALORI_PARI.put('9', 9); VALORI_PARI.put('A', 0); VALORI_PARI.put('B', 1);
        VALORI_PARI.put('C', 2); VALORI_PARI.put('D', 3); VALORI_PARI.put('E', 4);
        VALORI_PARI.put('F', 5); VALORI_PARI.put('G', 6); VALORI_PARI.put('H', 7);
        VALORI_PARI.put('I', 8); VALORI_PARI.put('J', 9); VALORI_PARI.put('K', 10);
        VALORI_PARI.put('L', 11); VALORI_PARI.put('M', 12); VALORI_PARI.put('N', 13);
        VALORI_PARI.put('O', 14); VALORI_PARI.put('P', 15); VALORI_PARI.put('Q', 16);
        VALORI_PARI.put('R', 17); VALORI_PARI.put('S', 18); VALORI_PARI.put('T', 19);
        VALORI_PARI.put('U', 20); VALORI_PARI.put('V', 21); VALORI_PARI.put('W', 22);
        VALORI_PARI.put('X', 23); VALORI_PARI.put('Y', 24); VALORI_PARI.put('Z', 25);


        // Dizionario comuni (20 esempi)
        COMUNI.put("ROMA", "H501"); COMUNI.put("MILANO", "F205"); COMUNI.put("TORINO", "L219");
        COMUNI.put("NAPOLI", "F839"); COMUNI.put("FIRENZE", "D612"); COMUNI.put("BOLOGNA", "A944");
        COMUNI.put("GENOVA", "D969"); COMUNI.put("VENEZIA", "L736"); COMUNI.put("VERONA", "L781");
        COMUNI.put("BARI", "A662"); COMUNI.put("PALERMO", "G273"); COMUNI.put("CATANIA", "C351");
        COMUNI.put("CAGLIARI", "B354"); COMUNI.put("PERUGIA", "G478"); COMUNI.put("PISA", "G702");
        COMUNI.put("SIENA", "I726"); COMUNI.put("PARMA", "G337"); COMUNI.put("MODENA", "F257");
        COMUNI.put("TRIESTE", "L424"); COMUNI.put("LECCE", "E506");
    }

    /**
     * Calcola il codice del cognome (3 caratteri)
     */
    public static String calcolaCodiceCognome(String cognome) {
        return calcolaCodiceTestuale(cognome, false);
    }

    /**
     * Calcola il codice del nome (3 caratteri)
     */
    public static String calcolaCodiceNome(String nome) {
        return calcolaCodiceTestuale(nome, true);
    }

    /**
     * Calcola il codice data+sesso (5 caratteri)
     */
    public static String calcolaCodiceData(LocalDate data, char sesso) {
        if (data == null) {
            throw new IllegalArgumentException("La data non può essere null");
        }
        sesso = Character.toUpperCase(sesso);
        if (sesso != 'M' && sesso != 'F') {
            throw new IllegalArgumentException("Il sesso deve essere M oppure F");
        }

        String anno = String.format("%02d", data.getYear() % 100);
        char mese;
        switch (data.getMonthValue()) {
            case 1:
                mese = 'A';
                break;
            case 2:
                mese = 'B';
                break;
            case 3:
                mese = 'C';
                break;
            case 4:
                mese = 'D';
                break;
            case 5:
                mese = 'E';
                break;
            case 6:
                mese = 'H';
                break;
            case 7:
                mese = 'L';
                break;
            case 8:
                mese = 'M';
                break;
            case 9:
                mese = 'P';
                break;
            case 10:
                mese = 'R';
                break;
            case 11:
                mese = 'S';
                break;
            case 12:
                mese = 'T';
                break;
            default:
                throw new IllegalStateException("Mese non valido: " + data.getMonthValue());
        }
        int giorno = data.getDayOfMonth();
        if (sesso == 'F') {
            giorno += 40;
        }
        return anno + mese + String.format("%02d", giorno);
    }

    /**
     * Restituisce il codice catastale del comune. In un'app reale, questo dovrebbe leggere da un DB.
     */
    public static String calcolaCodiceComune(String comune) {
        if (comune == null || comune.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome del comune non può essere vuoto");
        }
        String comuneNorm = normalizza(comune);
        String codice = COMUNI.get(comuneNorm);
        if (codice == null) {
            throw new IllegalArgumentException("Comune non presente nel dizionario di esempio: " + comune);
        }
        return codice;
    }

    /**
     * Calcola il carattere di controllo finale (1 carattere)
     */
    public static char calcolaCodiceControllo(String cf15) {
        if (cf15 == null || cf15.length() != 15) {
            throw new IllegalArgumentException("La base per il codice di controllo deve essere di 15 caratteri");
        }
        cf15 = cf15.toUpperCase();
        int somma = 0;
        for (int i = 0; i < 15; i++) {
            char c = cf15.charAt(i);
            // Le posizioni dispari (1, 3, ..) corrispondono a indici pari (0, 2, ..)
            if ((i + 1) % 2 != 0) { // Posizione dispari
                somma += VALORI_DISPARI.get(c);
            } else { // Posizione pari
                somma += VALORI_PARI.get(c);
            }
        }
        int resto = somma % 26;
        return (char) ('A' + resto);
    }

    /**
     * Calcola il codice fiscale completo di 16 caratteri.
     */
    public static String calcolaCodiceFiscaleCompleto(String nome, String cognome, LocalDate dataNascita, char sesso, String comune) {
        String codiceCognome = calcolaCodiceCognome(cognome);
        String codiceNome = calcolaCodiceNome(nome);
        String codiceData = calcolaCodiceData(dataNascita, sesso);
        String codiceComune = calcolaCodiceComune(comune);

        String parziale = codiceCognome + codiceNome + codiceData + codiceComune;
        char controllo = calcolaCodiceControllo(parziale);

        return parziale + controllo;
    }

    // =========================================================
    // METODI PRIVATI DI SUPPORTO
    // =========================================================

    private static String calcolaCodiceTestuale(String valore, boolean isNome) {
        if (valore == null || valore.trim().isEmpty()) {
            throw new IllegalArgumentException("Il valore (nome/cognome) non può essere vuoto");
        }

        String normalizzato = normalizza(valore);
        StringBuilder consonanti = new StringBuilder();
        StringBuilder vocali = new StringBuilder();

        for (char c : normalizzato.toCharArray()) {
            if (VOCALI.indexOf(c) != -1) {
                vocali.append(c);
            } else {
                consonanti.append(c);
            }
        }

        StringBuilder risultato;
        if (isNome && consonanti.length() >= 4) {
            risultato = new StringBuilder();
            risultato.append(consonanti.charAt(0));
            risultato.append(consonanti.charAt(2));
            risultato.append(consonanti.charAt(3));
        } else {
            risultato = new StringBuilder(consonanti);
        }

        risultato.append(vocali);
        while (risultato.length() < 3) {
            risultato.append('X');
        }

        return risultato.substring(0, 3);
    }

    /**
     * Pulisce e normalizza una stringa per il calcolo: rimuove accenti, apostrofi, spazi e converte in maiuscolo.
     */
    private static String normalizza(String input) {
        String s = input.trim().toUpperCase();
        // Rimuove accenti e caratteri diacritici
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        // Rimuove tutto ciò che non è una lettera (es. apostrofi, spazi)
        s = s.replaceAll("[^A-Z]", "");
        return s;
    }

    // =========================================================
    // ESEMPIO DI UTILIZZO (per test)
    // =========================================================
    public static void main(String[] args) {
        try {
            // Esempio 1: Mario Rossi
            String cfMarioRossi = calcolaCodiceFiscaleCompleto(
                    "Mario",
                    "Rossi",
                    LocalDate.of(1980, 1, 1),
                    'M',
                    "Roma"
            );
            System.out.println("CF Mario Rossi: " + cfMarioRossi); // Atteso: RSSMRA80A01H501U

            // Esempio 2: Maria Bianchi con apostrofo
            String cfMariaBianchi = calcolaCodiceFiscaleCompleto(
                    "Maria",
                    "D'Arienzo",
                    LocalDate.of(1995, 10, 20),
                    'F',
                    "Milano"
            );
            System.out.println("CF Maria D'Arienzo: " + cfMariaBianchi); // Atteso: DRNMRA95R60F205T

        } catch (IllegalArgumentException e) {
            System.err.println("Errore nel calcolo: " + e.getMessage());
        }
    }
}