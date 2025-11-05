import java.time.LocalDate;
import java.util.Random;

public class Brano {
    //attributi
    private String titolo;
    private String artista;
    private int anno;
    private int copieVendute;


    //metodi getters e setters
    public String getTitolo(){
        return titolo;
    }

    public void setTitolo(String t){
        if (t.isEmpty()) throw new IllegalArgumentException("! - Titolo non può esssere vuoto");
        titolo=t;
    }

    public String getArtista(){
        return artista;
    }
    public void setArtista(String a){
        if (a.length() < 2) throw new IllegalArgumentException("! - Artista: min 2 caratteri");
        artista=a;
    }

    public int getAnno(){
        return anno;
    }

    public void setAnno(int a){
        if (a>LocalDate.now().getYear()) throw new IllegalArgumentException("! - Anno non può esssere nel futuro");
        anno=a;
    }

    public int getCopieVendute(){
        return copieVendute;
    }

    public void setCopieVendute(int copie){
        if (copie<0) throw new IllegalArgumentException("! - Copie vendute non può esssere negativo");

    }

    public Classifica getRiconoscimento(){
        Classifica c = Classifica.NESSUNA;
        if (copieVendute <=1000) c= Classifica.LEGNO;
        if (copieVendute>100000 && copieVendute<=250000) c= Classifica.ARGENTO;
        if (copieVendute>250000 && copieVendute<=500000) c= Classifica.ORO;
        if (copieVendute>500000) c= Classifica.PLATINO;

        return c;
    }

    public int getEta(){
        return LocalDate.now().getYear() - anno;
    } //non serve scrivere Brano xche e la classe letteralmente

    public Brano(String t, String a, int anno, int copie){
        setTitolo(t);
        setArtista(a);
        setAnno(anno);
        setCopieVendute(copie);
    }

    static public Brano creaBrano(){
        String[] artisti = {"DjOne", "BlueDragon", "BasicSound"};
        Random r = new Random();
        String dj = artisti[r.nextInt(artisti.length)];
        Brano b = new Brano("Br01", dj, LocalDate.now().getYear(), 0);
        return b;
    }

    @Override
    public String toString() {
        return "Brano: " + '\n' +
                "titolo: " + titolo + '\n' +
                "artista: " + artista + '\n' +
                "anno: " + anno + '\n' +
                "copieVendute: " + copieVendute;
    }
}
