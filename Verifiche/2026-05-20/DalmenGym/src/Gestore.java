import java.util.ArrayList;
import java.util.List;

public class Gestore {
    private List<Iscritto> iscritti;
    private List<Corso> corsi;
    private int accessiPesi;
    private int accessiSauna;

    public Iscritto getIscritto(int nTessera){
        return iscritti.get(nTessera);
    }

    public List<String> getScaduti(){
        return new ArrayList<>();
        //TODO
    }

    
}
