import java.sql.Timestamp;
import java.util.*;

public class Gestore {
    private Queue<String> codaNormali;
    private Queue<String> codaPrioritari;
    private int progressivoNormali;
    private int progressivoPrioritari;
    private int CCN;
    LogChiamate logChiamate;

    public Gestore(LogChiamate l){
        codaNormali = new LinkedList<>();
        codaPrioritari = new LinkedList<>();
        progressivoNormali = 0;
        progressivoPrioritari = 0;
        CCN = 0;
        logChiamate = l;
    }

    public void emettiBigliettoNormale(){
        codaNormali.add("N"+Integer.toString(progressivoNormali));
        progressivoNormali+=1;
    }

    public void emettiBigliettoPrioritario(){
        codaPrioritari.add("P"+Integer.toString(progressivoPrioritari));
        progressivoPrioritari+=1;

    }

    public String chiamaBiglietto(String identificativo){
        String biglietto = "Nessuno in attesa";
        if (codaNormali.isEmpty() || CCN >= 2){
            if (!codaPrioritari.isEmpty()){
                biglietto = codaPrioritari.remove();
                CCN = 0;
            }
        }
        if (!codaNormali.isEmpty() && Objects.equals(biglietto, "Nessuno in attesa")){
            biglietto= codaNormali.remove();
            CCN+=1;
        }

        if (!biglietto.equals("Nessuno in attesa")) logChiamate.aggiungiChiamata(biglietto,identificativo,new Timestamp(System.currentTimeMillis()));
        return biglietto;
    }

    public List<String> getBigliettiInAttesa(){
        List<String> attesa = new ArrayList<>();

        for (String n : codaNormali) {
            attesa.add(n);
        }

        for (String p : codaPrioritari) {
            attesa.add(p);
        }

        return attesa;
    }

    public Queue<String> getCodaPrioritari() {
        return codaPrioritari;
    }

    public Queue<String> getCodaNormali() {
        return codaNormali;
    }
}
