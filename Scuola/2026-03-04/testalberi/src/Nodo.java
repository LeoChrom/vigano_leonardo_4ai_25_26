public class Nodo {
    private int valore;
    private Nodo sx;
    private Nodo dx;

    public Nodo(int valore) {
        this.valore = valore;
    }

    // costruttore di copia
    private Nodo(Nodo n) {
        this.valore = n.getValore();
        if (n.sx != null) this.sx = new Nodo(n.sx);
        if (n.dx != null) this.dx = new Nodo(n.dx);
    }

    public int getValore() {
        return valore;
    }

    public Nodo getSx() {
        return sx;
    }

    public Nodo getDx() {
        return dx;
    }

    public boolean hasSx() {
        return sx != null;
    }

    public boolean hasDx() {
        return dx != null;
    }

    public boolean isFoglia() {
        return sx == null && dx == null;
    }

    public void addSx(int valore) {
        if (sx == null) sx = new Nodo(valore);
        else throw new NodeAlreadyDefined("! - Nodo sinistra già presente");
    }

    public void addDx(int valore) {
        if (dx == null) dx = new Nodo(valore);
        else throw new NodeAlreadyDefined("! - Nodo destra già presente");
    }

    @Override
    public String toString() {
        return " - " + valore + " - ";
    }
}