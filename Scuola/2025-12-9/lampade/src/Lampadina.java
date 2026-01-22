import java.util.Objects;

public class Lampadina {
    private StatoLampadina stato;
    private String numSerie;
    private int numAccensioni;
    private float tempoFunzionamento;
    private String tipo;

    public StatoLampadina getStato() {
        return stato;
    }

    public void setStato(StatoLampadina stato) {
        this.stato = stato;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        if (numSerie.matches("[A-Z]{4}[1-9]{2}")) this.numSerie = numSerie;
        else throw new IllegalArgumentException("! - Formato seriale non valido (ABCD12)");

    }

    public int getNumAccensioni() {
        return numAccensioni;
    }

    public void setNumAccensioni(int numAccensioni) {
        if (numAccensioni>this.numAccensioni) this.numAccensioni = numAccensioni;
        else throw new IllegalArgumentException("! - Numero accensioni non valido");
    }

    public float getTempoFunzionamento() {
        return tempoFunzionamento;
    }

    public void setTempoFunzionamento(float tempoFunzionamento) {
        if (tempoFunzionamento>this.tempoFunzionamento) this.tempoFunzionamento = tempoFunzionamento;
        else throw new IllegalArgumentException("! - Tempo di funzionamento non valido");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (Objects.equals(tipo, "Alogeno") || Objects.equals(tipo, "LED")) this.tipo = tipo;
        else throw new IllegalArgumentException("! - La lampada può essere alogena o a LED");


    }
}
