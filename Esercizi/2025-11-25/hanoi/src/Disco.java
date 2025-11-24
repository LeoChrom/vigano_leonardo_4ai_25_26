public class Disco {
    private int dimensione;

    Disco(int dimensione){
        if(dimensione>0 && dimensione<=8) this.dimensione=dimensione;
        else throw new IllegalArgumentException("! - Dimensione disco non valida");
    }
    public int getDimensione() {
        return dimensione;
    }

    @Override
    public String toString() {
        return Integer.toString(dimensione);
    }
}
