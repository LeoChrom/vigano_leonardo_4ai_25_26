public class Studente extends Persona{
    private int matricola;
    private String universita;

    public Studente(String codFiscale, String nome, String cognome, int matricola, String universita) {
        super(codFiscale, nome, cognome);

    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        if (matricola>99 && matricola<=999) this.matricola = matricola;
        else throw new IllegalArgumentException("! La matricola è un numero a 3 cifre");
    }

    public String getUniversita() {
        return universita;
    }

    public void setUniversita(String universita) {
        if(universita.length()>4) this.universita = universita;
        else throw new IllegalArgumentException("! Inserisci il nome dell'università");
    }


    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", universita='" + universita + '\'' +
                '}';
    }
}
