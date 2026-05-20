import java.time.LocalDate;
import java.util.List;

public class Iscritto {
    private String nome;
    private int idTessera;
    private Abbonamento livello;
    private LocalDate scadenza;
    private List<Corso> iscrizioni;

    Iscritto(String nome, int idTessera, Abbonamento livello, LocalDate scadenza){
        if (nome.length()>1) this.nome=nome;
        else throw new IllegalArgumentException("! - Nome min 1 carattere");
        this.livello = livello;
        this.idTessera = idTessera;

        if (scadenza.isAfter(LocalDate.now())) this.scadenza=scadenza;
        else throw new IllegalArgumentException("! - Data scadenza futura");
    }

    public void iscrivi(Corso corso){
        iscrizioni.add(corso);
    }

    public void rinnova(LocalDate nuovaScad){
        //imposta nuova scadenza futura
    }

    public void promuovi (){
        if (livello==Abbonamento.ISCRITTO) livello=Abbonamento.ISCRITTO_GOLD;
    }

    public Abbonamento getLivello() {
        return livello;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public int getId() {
        return idTessera;
    }

    public String getNome() {
        return nome;
    }

    public int nIscrizioni(){
        return iscrizioni.size();
    }

    @Override
    public String toString() {
        return "Iscritto{" +
                "nome='" + nome + '\'' +
                ", idTessera=" + idTessera +
                ", livello=" + livello +
                ", scadenza=" + scadenza +
                ", iscrizioni=" + iscrizioni +
                '}';
    }
}
