import java.time.LocalDate;

public class Proprietario {
    private String CF;
    private String nome;
    private String cognome;

    public Proprietario(String CF, String nome, String cognome) {
        setCF(CF);
        setNome(nome);
        setCognome(cognome);
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        if (CF.length()==16) this.CF = CF;
        else throw new IllegalArgumentException("! - Codice fiscale non valido");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length()<2 || nome.length()>20) throw new IllegalArgumentException("! - Nome: minimo 2 caratteri, massimo 20");
        else this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        if (cognome.length()<2 || cognome.length()>30) throw new IllegalArgumentException("! - Cognome: minimo 2 caratteri, massimo 30");
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return  "CF='" + CF + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'';
    }
}
