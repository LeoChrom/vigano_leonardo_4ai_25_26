package Figure;

public class Cerchio extends FiguraGeometrica {
    public Cerchio(float raggio){
        super(1, raggio);
    }

    @Override
    public float perimetro() {;
        return (float)(2*lunghezzaLato*Math.PI);
    }
}

