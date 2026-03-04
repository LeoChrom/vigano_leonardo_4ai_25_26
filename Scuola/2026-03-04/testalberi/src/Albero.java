import java.util.ArrayList;
import java.util.List;

public class Albero {
    private Nodo root;
    private int altezza;

    public Albero(int valoreRoot) {
        root = new Nodo(valoreRoot);
        altezza=1;
    }

    public Nodo getRoot() {
        return root;
    }

    // --- Inserimento ---

    /**
     * Inserisce in un albero valori interi, dove i
     * valori minori vanno a sinistra e maggiori a destra.
     */
    public void inserisci(int valore) {
        inserisciRicorsivo(root, valore);
        altezza += 1;
    }

    private void inserisciRicorsivo(Nodo root, int valore) {
        //SE il valore è minore della root
        if (valore < root.getValore()) {

            //Se a sx ho già un nodo collegato, richiamo la funzione
            if (!root.hasSx()) root.addSx(valore);
            else inserisciRicorsivo(root.getSx(), valore);

        }
        //valore maggiore della radice
        else if (valore > root.getValore()) {
            if (!root.hasDx()) root.addDx(valore);
            else inserisciRicorsivo(root.getDx(), valore);
        }
        // TODO gestire la situazione valore == root.getValore()
    }

    // --- Visite ---

    /** Visita in ordine: sx, radice, dx
     * @return la lista con i valori dei nodi secondo l'ordine indicato
     * */
    public List<Integer> inOrder() {
        List<Integer> elementi = new ArrayList<>();
        inOrderRicorsivo(root, elementi);
        return elementi;
    }

    private void inOrderRicorsivo(Nodo nodo, List<Integer> elementi) {

        if (nodo == null) return;
        // tutti gli elementi a sinistra
        inOrderRicorsivo(nodo.getSx(), elementi);

        //aggiunge la radice (relativa!!!)
        elementi.add(nodo.getValore());

        //destra
        inOrderRicorsivo(nodo.getDx(), elementi);

    }

    /** Visita preordine: radice, sx, dx
     * @return la lista con i valori dei nodi secondo l'ordine indicato
     * */
    public List<Integer> preOrder() {
        List<Integer> elementi = new ArrayList<>();
        preOrderRicorsivo(root, elementi);
        return elementi;
    }

    private void preOrderRicorsivo(Nodo nodo, List<Integer> elementi) {

        if (nodo == null) return;

        //aggiunge la radice (relativa!!!)
        elementi.add(nodo.getValore());

        // tutti gli elementi a sinistra
        inOrderRicorsivo(nodo.getSx(), elementi);

        //destra
        inOrderRicorsivo(nodo.getDx(), elementi);

    }

    /** Visita post-order: sx → dx → radice
     * @return la lista con i valori dei nodi secondo l'ordine indicato
     * */
    public List<Integer> postOrder() {
        List<Integer> elementi = new ArrayList<>();
        postOrderRicorsivo(root, elementi);
        return elementi;
    }

    private void postOrderRicorsivo(Nodo nodo, List<Integer> elementi) {

        if (nodo == null) return;

        // tutti gli elementi a sinistra
        inOrderRicorsivo(nodo.getSx(), elementi);

        //destra
        inOrderRicorsivo(nodo.getDx(), elementi);

        //aggiunge la radice (relativa!!!)
        elementi.add(nodo.getValore());

    }

    // -- Ricerca --

    /** cerca un valore nell'albero.
     * @return boolean
     * */
    public boolean contiene(int valore) {
        return cercaRicorsivo(root, valore);
    }

    private boolean cercaRicorsivo(Nodo nodo, int valore) {
        if (nodo == null) return false;
        if (valore == nodo.getValore()) return true;

        //vai a sinistra
        if (valore < nodo.getValore()) return cercaRicorsivo(nodo.getSx(), valore);

        //vai a destra
        return cercaRicorsivo(nodo.getDx(), valore);
    }

    // Informazioni albero

    /** numero totale di nodi nell'albero. */
    public int dimensione() {
        return dimensioneRicorsiva(root);
    }

    private int dimensioneRicorsiva(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + dimensioneRicorsiva(nodo.getSx()) + dimensioneRicorsiva(nodo.getDx());
    }

    /** altezza dell'albero (numero di livelli). */
    public int getAltezza() {
        return altezza;
    }


    @Override
    public String toString() {
        return "Albero{ root = " + root.getValore() +
                ", dimensione = " + dimensione() +
                ", altezza, num livelli = " + altezza + " }";
    }
}
