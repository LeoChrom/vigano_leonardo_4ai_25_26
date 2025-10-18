public class Griglia {
    public final int RIGHE;
    public final int COLONNE;
    public final char SIMBOLO_GIOC1 = 'X';
    public final char SIMBOLO_GIOC2 = 'O';

    private char [][] tabella;
    private int turno;

    public Griglia() {
        this.RIGHE = 3;
        this.COLONNE = 3;
        this.tabella = new char[RIGHE][COLONNE];
        this.turno=1;

        for (int r = 0; r < RIGHE; r++) {
            for (int c = 0; c < COLONNE; c++) {
                tabella [r][c] = '~';
            }
        }
    }

    public int getTurno (){
        return turno;
    }

    public void setCella (int riga, int colonna){
        if (riga>=0 && riga< RIGHE && colonna >=0 && colonna<COLONNE){
            switch (turno){
                case 1:
                    tabella[riga][colonna]=SIMBOLO_GIOC1;
                    break;

                case 2:
                    tabella[riga][colonna]=SIMBOLO_GIOC2;
                    break;

                default: throw new IllegalArgumentException("! - Valore turno non valido");

            }
        }
        else throw new IllegalArgumentException("! - posizione cella non valida");

        switch (turno){
            case 1:
                turno=2;
                break;
            case 2:
                turno=1;
                break;
        }
    }

    public char[][] getGriglia(){
        return tabella;
    }

    public boolean chkVincita(){
        boolean vinto = false;

        //vincite verticali
        for (int c = 0; c< COLONNE; c++) {
            vinto=true;
            for (int r = 1; r < RIGHE; r++) {
                if (tabella[r][c]!=tabella[r-1][c]){
                    vinto=false;
                    break;
                }

            }
            if (vinto==true){
                return vinto;
            }
        }

        //orrizzontale
        for (int r = 0; r< RIGHE; r++) {
            vinto=true;
            for (int c = 1; c < COLONNE; c++) {
                if (tabella[r][c]!=tabella[r][c-1]){
                    vinto=false;
                    break;
                }

            }
            if (vinto==true){
                return vinto;
            }
        }

        //diagonale da sinistra a destra
        for (int c = 1; c< COLONNE; c++) {
            vinto=true;
            for (int r = 1; r < RIGHE; r++) {
                if (tabella[r][c]!=tabella[r-1][c-1]){
                    vinto=false;
                    break;
                }

            }
            if (vinto==true){
                return vinto;
            }
        }

        //diagonale da destra a sinistra
        for (int c = COLONNE-2; c>=0; c--) {
            vinto=true;
            for (int r = RIGHE-2; r >=0; r--) {
                if (tabella[r][c]!=tabella[r+1][c+1]){
                    vinto=false;
                    break;
                }

            }
            if (vinto==true){
                return vinto;
            }
        }

        return vinto;
    }
}
