import java.util.Arrays;

public class Griglia {
    public final int RIGHE;
    public final int COLONNE;
    public final char SIMBOLO_GIOC1 = 'X';
    public final char SIMBOLO_GIOC2 = 'O';

    private char [][] tabella;

    public Griglia(int righe, int colonne) {
        this.RIGHE = righe;
        this.COLONNE = colonne;
        this.tabella = new char[RIGHE][COLONNE];

        for (int r = 0; r < RIGHE; r++) {
            for (int c = 0; c < COLONNE; c++) {
                tabella [r][c] = '~';
            }
        }
    }


    public void inserisciPedina (int colonna, int turno){
        int riga=-1;
        colonna--;

        if (colonna >=0 && colonna<COLONNE){
            //trova la riga
            for (int r = RIGHE-1; r >=0; r--) {
                if(tabella[r][colonna]=='~'){
                    riga=r;
                    break;
                }

            }


            if (riga>=0){
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
            else throw new IllegalArgumentException("! - Colonna già occupata");

        }
        else throw new IllegalArgumentException("! - Colonna non valida");


    }

    public char[][] getGriglia(){
        return tabella;
    }

    public boolean chkVincita(){
        int conta=0;

        //vincite verticali
        for (int c = 0; c< COLONNE; c++) {
            for (int r = 1; r < RIGHE; r++) {
                if (tabella[r][c]==tabella[r-1][c] && tabella[r][c]!='~'){
                    conta+=1;
                }

            }
            if (conta==3){
                return true;
            }
        }
        conta=0;

        //vincite orrizzontali
        for (int r = 1; r< RIGHE; r++) {
            for (int c = 1; c < COLONNE; c++) {
                if (tabella[r][c]==tabella[r][c-1] && tabella[r][c]!='~'){
                    conta+=1;
                }

            }
            if (conta==3){
                return true;
            }
        }
        conta=0;

/*
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

 */
    return false;
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
