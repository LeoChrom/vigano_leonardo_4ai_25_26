import java.io.Serializable;
import java.time.LocalDate;
public class Bambino extends Persona implements Serializable {
    LocalDate nascita;

    public Bambino(String nome, String cognome, int eta, LocalDate nascita) {
        super(nome, cognome, eta);
        this.nascita = nascita;
    }

    public void setNascita(LocalDate nascita) {
        //TODO verifica la data immessa
        this.nascita = nascita;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    @Override
    public String toString() {
        return "Bambino{" +
                "nascita=" + nascita +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                '}';
    }
}