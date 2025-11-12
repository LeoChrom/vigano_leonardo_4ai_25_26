public class Penna {
    private String marca;
    private boolean cancellabile;
    private double qtaInk;
    private String colore;

    public Penna() {
        marca = "marca";
        cancellabile = false;
        qtaInk = 0.0;
        colore = "colore";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isCancellabile() {
        return cancellabile;
    }

    public void setCancellabile(boolean cancellabile) {
        this.cancellabile = cancellabile;
    }

    public double getQtaInk() {
        return qtaInk;
    }

    public void setQtaInk(double qtaInk) {
        this.qtaInk = qtaInk;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
