public class Ordinario extends Dolce{
    private String variante;
    private float prezzoKg;

    public Ordinario(String id, String nome, boolean rischioAllergia, String variante, float prezzoKg) {
        super(id, nome, rischioAllergia);
        setVariante(variante);
        setPrezzoKg(prezzoKg);
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        if (variante.length()>1) this.variante = variante;
        else throw new IllegalArgumentException("! - Variante; minimo un carattere");
    }

    public float getPrezzoKg() {
        return prezzoKg;
    }

    public void setPrezzoKg(float prezzoKg) {
        if (prezzoKg>0) this.prezzoKg = prezzoKg;
        else throw new IllegalArgumentException("! - Prezzo non valido");
    }

    @Override
    public String toString() {
        return "Ordinario{" +
                "variante='" + variante + '\'' +
                ", prezzoKg=" + prezzoKg +
                ", id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", rischioAllergia=" + rischioAllergia +
                '}';
    }

    @Override
    public float scontoMax() {
        if (prezzoKg<12.00f) return prezzoKg*0.01f+1.05f;
        return 1.40f;
    }
}
