public class Nodo {
    private int valore;
    private Nodo destro;
    private Nodo sinistro;

    public Nodo(int valore) {
        this.valore = valore;
        destro = null;
        sinistro = null;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public Nodo getDestro() {
        return destro;
    }

    public void setDestro(Nodo destro) {
        this.destro = destro;
    }

    public Nodo getSinistro() {
        return sinistro;
    }

    public void setSinistro(Nodo sinistro) {
        this.sinistro = sinistro;
    }
}
