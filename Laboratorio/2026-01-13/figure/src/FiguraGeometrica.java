public class FiguraGeometrica {
    private int numeroLati;
    private float lunghezzaLato;

    FiguraGeometrica(int nl, float ll){
        numeroLati = nl;
        lunghezzaLato = ll;
    }

    //AGGIUNGI I CONTROLLI

    public float perimetro(){
        return numeroLati * lunghezzaLato;
    }
}
