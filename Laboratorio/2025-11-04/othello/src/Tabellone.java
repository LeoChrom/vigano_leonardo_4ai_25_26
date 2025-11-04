public class Tabellone {
    public final int RIGHE;
    public final int COLONNE;
    public final char SIMBOLO_GIOC1 = 'X';
    public final char SIMBOLO_GIOC2 = 'O';
    private char [][] tabella;

    public Tabellone() {
        this.RIGHE = 8;
        this.COLONNE = 8;
        this.tabella = new char[RIGHE][COLONNE];

        for (int r = 0; r < RIGHE; r++) {
            for (int c = 0; c < COLONNE; c++) {
                tabella [r][c] = '~';
            }
        }
        tabella[3][3]='O';
        tabella[3][4]='X';
        tabella[4][3]='X';
        tabella[4][4]='O';
    }

    public char[][] getGriglia(){
        return tabella;
    }

}
