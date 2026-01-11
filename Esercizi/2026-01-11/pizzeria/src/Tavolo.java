import java.util.ArrayList;
import java.util.List;

public class Tavolo {
    public static final int MAX_POS = 10;
    private final int nTavolo;
    private List<Pizza> ordini;

    public Tavolo(int nTavolo) {
        if (nTavolo < 1) {
            throw new IllegalArgumentException("ID tavolo deve essere almeno 1");
        }
        this.nTavolo = nTavolo;
        this.ordini = new ArrayList<>();
    }

    public List<Pizza> getOrdini() {
        return ordini;
    }
}
