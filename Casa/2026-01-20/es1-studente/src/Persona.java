public class Persona {
    private String codFiscale;
    private String nome;
    private String cognome;

    public Persona(String codFiscale, String nome, String cognome){
        setCodFiscale(codFiscale);
        setNome(nome);
        setCognome(cognome);
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public void setCodFiscale(String cod) {
        if (cod.length()==16 && cod.matches("^[A-Z]{6}[0-9]{2}[A-EHLMPRST][0-9]{2}[A-Z][0-9]{3}[A-Z]$")){
            codFiscale=cod;
        }
        else throw new IllegalArgumentException("!- cod fiscale non valido");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        if (n.length()<2) throw new IllegalArgumentException("!- Nome min 2 caratteri");
        else nome=n;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String c) {
        if (c.length()<2) throw new IllegalArgumentException("!- Nome min 2 caratteri");
        else cognome=c;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "codFiscale='" + codFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
