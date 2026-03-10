import java.util.Arrays;

/**
 * Classe che rappresenta il tavolo di gioco dove si trovano le provette.
 */
public class Tavolo {
    private Provetta[] provette;
    private int numProvette;
    private int numProvetteSpecial;
    private int capacitaProvette;


    /**
     * Crea un nuovo tavolo di gioco.
     * @param numProvette Indica il numero di provette.
     * @param capacitaProvette Specifica la capacità in unità di colore per ogni provetta.
     */
    public Tavolo(int numProvette, int capacitaProvette) {
        if (numProvette<1 || capacitaProvette<1) throw new IllegalArgumentException("! - Parametri tavolo non corretti");
        this.numProvette=numProvette;
        this.capacitaProvette=capacitaProvette;
        provette = new Provetta[numProvette];
        for (int i = 0; i < numProvette; i++) {
            provette[i] = new Provetta(capacitaProvette);
        }
        numProvetteSpecial=0;

    }

    /**
     * Crea un nuovo tavolo di gioco dotato di provette standard e special.
     * @param numProvette Indica il numero di provette standard.
     * @param numProvetteSpecial Indica il numero di provette special.
     * @param capacitaProvette Specifica la capacità in unità di colore per ogni provetta.
     */
    public Tavolo(int numProvette, int numProvetteSpecial, int capacitaProvette) {
        if (numProvette<1 || numProvetteSpecial<1 || capacitaProvette<1) throw new IllegalArgumentException("! - Parametri tavolo non corretti");
        this.numProvette=numProvette;
        this.capacitaProvette=capacitaProvette;
        this.numProvetteSpecial=numProvetteSpecial;

        provette = new Provetta[numProvette+numProvetteSpecial];
        for (int i = 0; i < numProvette; i++) {
            provette[i] = new Provetta(capacitaProvette);
        }

        for (int i = numProvette-1; i < numProvetteSpecial; i++) {
            provette[i] = new ProvettaSpecial(capacitaProvette);
        }
    }

    /**
     * Permette di aggiungere del colore ad una provetta.
     * @param posProvetta Indica a quale provetta aggiungere il colore (partendo da 0).
     * @param qtaColore Specifica le unità di colore che si vogliono aggiungere.
     * @param colore Definisce quale colore aggiungere.
     */
    public void riempi(int posProvetta, int qtaColore, Colore colore) {
        for (int i = 0; i < qtaColore; i++) {
            provette[posProvetta].aggiungi(colore);
        }
    }

    /**
     * Permette di travasare del colore da una provetta ad un'altra.
     * @param pSorgente Indica da quale provetta prendere il colore.
     * @param pDestinazione Indica a quale provetta aggiungere il colore.
     * @return Restituisce il numero di unità di colore travasate.
     */
    public int travasa(int pSorgente, int pDestinazione) {
        int n = 1;
        if (pSorgente<0 || pSorgente>numProvetteSpecial+numProvette) throw new IllegalArgumentException("! - Operazione non valida");
        if (pDestinazione<0 || pDestinazione>numProvetteSpecial+numProvette) throw new IllegalArgumentException("! - Operazione non valida");
        if (pSorgente==pDestinazione) throw new IllegalArgumentException("! - Operazione non valida");
        if (provette[pDestinazione].isPiena()) throw new RuntimeException("! - Provetta destinazione piena");

        provette[pDestinazione].aggiungi(provette[pSorgente].rimuovi());
        return n;
    }

    /**
     * Determina se il gioco è finito.
     * @return Restituisce vero se il gioco è terminato oppure false se non è concluso.
     */
    public boolean isFinito() {
        for (Provetta provetta : provette) {
            if (!provetta.isCompleta()) return false;
        }
        return true;
    }

    /**
     * Permette di accedere direttamente alla provetta indicata.
     * @param posizione Indica la posizione della provetta a cui si vuole accedere (partendo da 0).
     * @return
     */
    public Provetta getProvetta(int posizione) {
        //if (posizione>provette.length-1)
        return provette[posizione];
    }

    /**
     * Stampa il tavolo di gioco.
     */
    @Override
    public String toString() {
        String tav = "";
        for (int i = 0; i < provette.length; i++) {
            tav += "Provetta " + i + " -> " + provette[i].toString() + "\n";

        }
        return tav;
    }
}