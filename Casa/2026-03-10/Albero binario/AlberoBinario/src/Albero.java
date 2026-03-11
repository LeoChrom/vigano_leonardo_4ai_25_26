import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un albero binario di ricerca (BST).
 * Permette l'inserimento di valori interi e la stampa in preorder.
 * --javadoc realizzati con ai--
 */
public class Albero {

    /** Nodo radice dell'albero */
    private Nodo root;

    /**
     * Lista usata per memorizzare l'ordine di visita durante il preorder.
     * Viene riempita ogni volta che si chiama toString().
     */
    private List<Integer> lista;

    /**
     * Costruttore: inizializza un albero vuoto.
     */
    public Albero() {
        this.root = null;
        lista = new ArrayList<>();
    }

    /**
     * Restituisce la radice dell'albero.
     * @return nodo radice
     */
    public Nodo getRoot() {
        return root;
    }

    /**
     * Imposta la radice dell'albero.
     * @param root nuovo nodo radice
     */
    public void setRoot(Nodo root) {
        this.root = root;
    }

    /**
     * Metodo ricorsivo che inserisce un valore all'interno dell'albero.
     *
     * @param valore valore da inserire
     * @param nodo nodo corrente da analizzare
     */
    private void inserisciRicorsivo(int valore, Nodo nodo) {

        // Evita duplicati
        if (nodo.getValore() == valore) return;

        // Se il valore è maggiore, vai a destra
        if (valore > nodo.getValore()) {

            // Se il sottoalbero destro è vuoto, crea nuovo nodo
            if (nodo.getDestro() == null) {
                nodo.setDestro(new Nodo(valore));
            } else {
                // Continua ricorsione
                inserisciRicorsivo(valore, nodo.getDestro());
            }

        } else { // valore < nodo.getValore()

            // Se il sottoalbero sinistro è vuoto, crea nuovo nodo
            if (nodo.getSinistro() == null) {
                nodo.setSinistro(new Nodo(valore));
            } else {
                // Continua ricorsione
                inserisciRicorsivo(valore, nodo.getSinistro());
            }
        }
    }

    /**
     * Inserisce un valore nell'albero.
     * Se la radice è nulla, crea la radice.
     *
     * @param valore valore da inserire
     */
    public void Inserisci(int valore) {
        if (root == null) {
            root = new Nodo(valore);
            return;
        }
        this.inserisciRicorsivo(valore, root);
    }

    /**
     * Visita l'albero in preorder e inserisce i valori nella lista.
     *
     * @param nodo nodo corrente
     */
    private void Preorder(Nodo nodo) {
        if (nodo == null) return;

        // Visita nodo
        lista.add(nodo.getValore());

        // Visita sottoalbero sinistro
        Preorder(nodo.getSinistro());

        // Visita sottoalbero destro
        Preorder(nodo.getDestro());
    }

    /**
     * Restituisce la rappresentazione dell'albero in preorder.
     * @return stringa dei valori visitati
     */
    @Override
    public String toString() {
        lista.clear(); // Evita accumulo visite precedenti
        Preorder(root);
        String stringa = "";

        for (Integer valore : lista) {
            stringa += valore + " ";
        }

        return stringa.trim();
    }
}