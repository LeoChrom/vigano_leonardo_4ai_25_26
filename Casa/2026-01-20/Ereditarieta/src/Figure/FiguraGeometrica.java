package Figure;

public abstract class FiguraGeometrica{

    private int numeroLati;
    protected float lunghezzaLato;

    public FiguraGeometrica(int nl, float ll){
        setNumeroLati(nl);
        setLunghezzaLati(ll);
    }

    public float perimetro(){
        return numeroLati * lunghezzaLato;
    }

    private void setNumeroLati(int nl){
        if (nl<=0) {
            throw new IllegalArgumentException("Il numero dei lati non può essere negativo");
        }
        numeroLati = nl;
    }

    private void setLunghezzaLati(float ll){
        if (ll<=0) {
            throw new IllegalArgumentException("La lunghezza dei lati non può essere negativo");
        }
        lunghezzaLato = ll;
    }

    public abstract float area();

    /*public float getLunghezzaLato(){
        return lunghezzaLato;
    }*/
}
