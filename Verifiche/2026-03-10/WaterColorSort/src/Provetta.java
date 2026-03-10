import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Classe Provetta.
 */
public class Provetta {

    private int capacita;
    protected Stack<Colore> contenuto;

    /**
     * Crea una nuova provetta.
     * @param capacita Indica quante unità di colore può contenere la provetta.
     */
    public Provetta(int capacita) {
        contenuto= new Stack<>();
        setCapacita(capacita);
    }

    /**
     *
     * @return numero massimo di unità colore contenibili
     */
    public int getCapacita() {
        return capacita;
    }

    /**
     *
     * @param capacita quante unità può contenere la provetta
     */
    private void setCapacita(int capacita) {
        if (capacita>=1) this.capacita = capacita;
        else throw new IllegalArgumentException("! - Capacità provetta di almeno un colore");
    }




    /**
     * Aggiunge una unità di colore.
     * @param colore Indica quale colore viene aggiunto.
     * @throws IllegalArgumentException quando
     */
    public void aggiungi(Colore colore) {
        if (contenuto.size()<capacita) contenuto.add(colore);
        else throw new RuntimeException("! - Capacità massima raggiunta");

    }

    /**
     * Toglie una unità di colore dalla provetta (Quella più in alto).
     * @return Restituisce il colore tolto dalla provetta.
     */
    public Colore rimuovi() {
        return contenuto.pop();
    }

    /**
     * Determina se la provetta è stata riempita con un solo colore.
     * @return Restituisce vero se la provetta è completa, false altrimenti.
     */
    public boolean isCompleta() {
        if (contenuto.isEmpty()) return true;
        if (contenuto.size()!= capacita) return false;

        boolean completo = true;
        Colore[] colori= new Colore[capacita];
        contenuto.copyInto(colori);

        for (int i = 0; i < colori.length; i++) {
            if (i>0) {
                if (colori[i-1] != colori[i]){
                    completo=false;
                    break;
                }
            }
        }

        return completo;
    }

    /**
     * Determina se la provetta è vuota.
     * @return Vero se la provetta è vuota, falso altrimenti.
     */
    public boolean isVuota() {
        return contenuto.isEmpty();
    }

    /**
     * Determina se la provetta è piena.
     * @return Vero se la provetta è piena, falso altrimenti.
     */
    public boolean isPiena() {
        return contenuto.size()==capacita;
    }

    /**
     * Restituisce lo spazio disponibile nella provetta.
     * @return Il numero di unità di colore che la provetta può ricevere.
     */
    public int spazioLibero() {
        return capacita-contenuto.size();
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
        return contenuto.toString();
    }
}