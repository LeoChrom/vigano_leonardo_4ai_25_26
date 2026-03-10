/**
 * Classe Provetta.
 */
public class Provetta {

    /**
     * Crea una nuova provetta.
     * @param capacita Indica quante unità di colore può contenere la provetta.
     */
    public Provetta() {
    }

    /**
     * Aggiunge una unità di colore.
     * @param colore Indica quale colore viene aggiunto.
     */
    public void aggiungi(Colore colore) {
    }

    /**
     * Toglie una unità di colore dalla provetta (Quella più in alto).
     * @return Restituisce il colore tolto dalla provetta.
     */
    public Colore rimuovi() {
        return Colore.BIANCO;
    }

    /**
     * Determina se la provetta è stata riempita con un solo colore.
     * @return Restituisce vero se la provetta è completa, false altrimenti.
     */
    public boolean isCompleta() {
        return true;
    }

    /**
     * Determina se la provetta è vuota.
     * @return Vero se la provetta è vuota, falso altrimenti.
     */
    public boolean isVuota() {
        return true;
    }

    /**
     * Determina se la provetta è piena.
     * @return Vero se la provetta è piena, falso altrimenti.
     */
    public boolean isPiena() {
        return true;
    }

    /**
     * Restituisce lo spazio disponibile nella provetta.
     * @return Il numero di unità di colore che la provetta può ricevere.
     */
    public int spazioLibero() {
        return 0;
    }

    /**
     * Determina il numero di unità dello stesso colore presenti nella parte alta della provetta.
     * @return Il numero di unità di colore.
     */
    public int contaColoreInCima() {
        return 0;
    }

    /**
     * Stampa il contenuto della provetta.
     */
    @Override
    public String toString() {
        return "";
    }
}