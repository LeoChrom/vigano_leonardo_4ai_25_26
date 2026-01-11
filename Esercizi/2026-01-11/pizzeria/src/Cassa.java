import java.util.Arrays;
import java.util.List;

public class Cassa {
    private Tavolo[] tavoli;

    public Cassa() {

    }

    public float getSpesa(int nTavolo){
        float spesa=0.0f;
        Tavolo tavolo = tavoli[nTavolo-1];
        List<Pizza> pizze = tavolo.getOrdini();
        for (int i = 0; i < pizze.size(); i++) {
            spesa += pizze.get(i).getCosto();
        }
        return spesa;
    }

}