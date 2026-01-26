public class Pedina {
    private Colore colore;
    private Tipo tipo;
    private int riga;
    private int colonna;
    //Bianco muove verso l'alto
    //Nero verso il basso
    // 1,1 in basso a sinistra


    //INNER ENUM - Enum all'interno di una classe
    //si puo fare anche con le classi
    //INNER CLASS POSSONO ESSERE PRIVATE!!!
    /* public class figuraGeom{
        un vertice è un insieme di cordinate fa parte della figura
        ha senso fare una classe a parte per il vertice?
        uso una inner class privata

        private class Vertice{
            private float x;
            private float y;
        }

        public List<Vertice> vertici;

        ecco a che serve, dal main non potrò accedere
    }*/

    public enum Colore {
        BIANCO,
        NERO
    }

    public enum Tipo{
        DAMA,
        DAMONE
    }

    Pedina(int r, int c, Colore co) throws DamaException {
        colore=co; //non servono controlli!
        muovi(r,c);
        tipo=Tipo.DAMA;
    }

    Pedina(Pedina altra){
        riga=altra.riga;
        colonna=altra.colonna;
        colore=altra.colore;
        tipo=altra.tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Colore getColore(){
        return colore;
    }

    public void promuovi() throws DamaException {
        if(colore==Colore.BIANCO && riga!=8){
            throw new DamaException("! - La dama non può essere promossa");
        }
        if(colore==Colore.NERO && riga!=1){
            throw new DamaException("! - La dama non può essere promossa");
        }
        else tipo=Tipo.DAMONE;
    }

    public void muovi(int nr, int nc) throws DamaException{
        //condizioni da fare: riga o colonna fuori dai limiti 1,8
        //nel caso muovo in diagonale? nr!=(vr+1)
        //colonna: nc!=(vc-1) && nc!=(vc+1)

        if (nr<1 || nr > 8){
            throw new DamaException("Posizione non valida");
        }
        if (nc<1 || nc > 8){
            throw new DamaException("Posizione non valida");
        }

        //TODO controlla gli altri movimenti:


        //non sono al primo movimento..
        if (riga != 0 && colonna != 0){

            int dr = nr - riga; //delta diff riga
            int dc = nc - colonna; //delta diff colonna

            if (tipo == Tipo.DAMONE){
                // DAMONE: diagonale
                if (Math.abs(dr) != Math.abs(dc)){
                    throw new DamaException("Il damone si muove solo in diagonale");
                }
            }
            else {
                // DAMA
                if (Math.abs(dc) != 1){
                    throw new DamaException("Movimento non valido");
                }

                if (colore == Colore.BIANCO){
                    if (dr != 1){
                        throw new DamaException("La dama bianca può muovere solo in avanti");
                    }
                }
                else {
                    if (dr != -1){
                        throw new DamaException("La dama nera può muovere solo in avanti");
                    }
                }
            }
        }

        riga=nr;
        colonna=nc;
    }
}
