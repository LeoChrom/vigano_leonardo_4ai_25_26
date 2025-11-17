import java.util.Arrays;

public class Griglia {
    public final int RIGHE=3;
    public final int COLONNE=3;
    public final char SIMBOLO_GIOC1 = 'X';
    public final char SIMBOLO_GIOC2 = 'O';

    private char [][] tabella;

    public Griglia() {
        this.tabella = new char[RIGHE][COLONNE];
        resetGriglia(tabella);
    }

    public void resetGriglia(char [][] tab){
        for (int r = 0; r < RIGHE; r++) {
            for (int c = 0; c < COLONNE; c++) {
                tab [r][c] = '~';
            }
        }
    }


    public void setCella (int riga, int colonna, int turno){
        if (riga>=0 && riga< RIGHE && colonna >=0 && colonna<COLONNE){
            if (tabella[riga][colonna]=='~'){
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
            else throw new IllegalArgumentException("! - Casella già occupata");

        }
        else throw new IllegalArgumentException("! - posizione cella non valida");


    }

    public char[][] getGriglia(){
        return tabella;
    }

    public boolean chkVincita(){
        boolean vinto=false;

        //vincite verticali
        for (int c = 0; c< COLONNE; c++) {
            vinto=true;
            for (int r = 1; r < RIGHE; r++) {
                if (tabella[r][c]!=tabella[r-1][c] || tabella[r][c]=='~'){
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
                if (tabella[r][c]!=tabella[r][c-1] || tabella[r][c]=='~'){
                    vinto=false;
                    break;
                }

            }
            if (vinto==true){
                return vinto;
            }
        }


        // diagonale da sinistra a destra
        vinto=true;
        for (int i = 1; i < tabella.length; i++) {
            if (tabella[i][i] != tabella[i - 1][i - 1] || tabella[i][i] == '~') {
                vinto = false;
                break;
            }
        }
        if (vinto) return true;

        // diagonale da destra a sinistra
        vinto = true;
        for (int i = 1; i < tabella.length; i++) {
            if (tabella[i][tabella.length - 1 - i] != tabella[i - 1][tabella.length - i] || tabella[i][tabella.length - 1 - i] == '~') {
                vinto = false;
                break;
            }
        }

        return vinto;
    }

    public boolean chkPareggio(){
        boolean pieno =true;
        for (int r = 0; r < RIGHE ; r++) {
            for (int c = 0; c < COLONNE; c++) {
                if (tabella [r][c]=='~'){
                    pieno=false;
                    break;
                }
            }
        }
        if (pieno && chkVincita()==false){
            return true;
        }
        return false;
    }
}
