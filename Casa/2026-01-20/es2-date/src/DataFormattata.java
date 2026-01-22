public abstract class DataFormattata {
    protected int giorno;
    protected int mese;
    protected int anno;

    DataFormattata(int giorno, int mese, int anno){
        setGiorno(giorno);
        setMese(mese);
        setAnno(anno);
    }

    private void setGiorno(int giorno){
        if (giorno<1 || giorno>31) throw new IllegalArgumentException("!- giorno non valido");
        else this.giorno=giorno;
    }

    private void setMese(int mese){
        if (mese<1 || mese>12) throw new IllegalArgumentException("!- mese non valido");
        else this.mese=mese;
    }

    private void setAnno(int anno){
        if (anno<1 || anno>3000) throw new IllegalArgumentException("!- anno non valido");
        else this.anno=anno;
    }

    public abstract String stringaFormattata();
}
