/**
 * Classe che rappresenta il tavolo di gioco dove si trovano le provette.
 */
public class Tavolo {


    /**
     * Crea un nuovo tavolo di gioco.
     * @param numProvette Indica il numero di provette.
     * @param capacitaProvette Specifica la capacità in unità di colore per ogni provetta.
     */
    public Tavolo(int numProvette, int capacitaProvette) {

    }

    /**
     * Crea un nuovo tavolo di gioco dotato di provette standard e special.
     * @param numProvette Indica il numero di provette standard.
     * @param numProvetteSpecial Indica il numero di provette special.
     * @param capacitaProvette Specifica la capacità in unità di colore per ogni provetta.
     */
    public Tavolo(int numProvette, int numProvetteSpecial, int capacitaProvette) {
    }

    /**
     * Permette di aggiungere del colore ad una provetta.
     * @param posProvetta Indica a quale provetta aggiungere il colore (partendo da 0).
     * @param qtaColore Specifica le unità di colore che si vogliono aggiungere.
     * @param colore Definisce quale colore aggiungere.
     */
    public void riempi(int posProvetta, int qtaColore, Colore colore) {
    }

    /**
     * Permette di travasare del colore da una provetta ad un'altra.
     * @param pSorgente Indica da quale provetta prendere il colore.
     * @param pDestinazione Indica a quale provetta aggiungere il colore.
     * @return Restituisce il numero di unità di colore travasate.
     */
    public int travasa(int pSorgente, int pDestinazione) {
        return 0;
    }

    /**
     * Determina se il gioco è finito.
     * @return Restituisce vero se il gioco è terminato oppure false se non è concluso.
     */
    public boolean isFinito() {
        return true;
    }

    /**
     * Permette di accedere direttamente alla provetta indicata.
     * @param posizione Indica la posizione della provetta a cui si vuole accedere (partendo da 0).
     * @return
     */
    public Provetta getProvetta(int posizione) {
        Provetta a = null;
        return a;
    }

    /**
     * Stampa il tavolo di gioco.
     */
    @Override
    public String toString() {
        return "";
    }
}