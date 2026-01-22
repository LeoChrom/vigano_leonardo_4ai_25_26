package Figure;

public class Rettangolo extends FiguraGeometrica {

    private float base;
    //private float altezza; //l'altezza la gestisce il padre (lunghezzaLato)

    public Rettangolo(float base, float altezza){
        super(4, altezza);
        //TODO - da scrivere come il mio Dio comanda
        this.base = base;
    }

    @Override
    public float perimetro() {
        return 2*(base + lunghezzaLato);
    }

    public float area(){
        return base * lunghezzaLato;
    }
}

