import javax.print.DocFlavor;

public class Griglia {
    
    private char[][] griglia;
    private final int N_CASELLE = 3;
    private  final char CASELLA_VUOTA = ' ';
    public  final char SIMBOLO_O = 'O';
    public  final char SIMBOLO_X = 'X';

    public Griglia() {
    }

    public void resetGriglia() {
        for (int i = 0; i < N_CASELLE; i++) {
            for (int j = 0; j < N_CASELLE; j++) {
                griglia[i][j] = CASELLA_VUOTA;
            }
        }
    }

    public void inserisciSimbolo(char simbolo, int r, int c) {
        r = r - 1;
        c = c - 1;

        if (simbolo != SIMBOLO_X && simbolo != SIMBOLO_O)
            throw new IllegalArgumentException("Simbolo non valido");
        if (r < 0 || r > N_CASELLE-1)
            throw new IllegalArgumentException("Riga fuori dal range");
        if (c < 0 || c > N_CASELLE-1)
            throw new IllegalArgumentException("Colonna fuori dal range");
        if (griglia[c][r] != CASELLA_VUOTA)
            throw new IllegalArgumentException("Casella gia occupata");
        griglia[c][r] = simbolo;
    }

    public char controllaVincita() {
        for (int r = 0; r < N_CASELLE; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                if ((griglia[c][r] == griglia[c][r + 1] && griglia[c][r] == griglia[c][r + 2] && griglia[c][r] == SIMBOLO_X) ||
                        (griglia[c][r] == griglia[c + 1][r] && griglia[c][r] == griglia[c + 2][r] && griglia[c][r] == SIMBOLO_X) ||
                        (griglia[c][r] == griglia[c + 1][r - 1] && griglia[c][r] == griglia[c + 2][r - 2] && griglia[c][r] == SIMBOLO_X) ||
                        (griglia[c][r] == griglia[c - 1][r + 1] && griglia[c][r] == griglia[c - 2][r + 2] && griglia[c][r] == SIMBOLO_X)) {
                    return 'X';
                }
            }
        }
        for (int r = 0; r < N_CASELLE; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                if ((griglia[c][r] == griglia[c][r + 1] && griglia[c][r] == griglia[c][r + 2] && griglia[c][r] == SIMBOLO_O) ||
                        (griglia[c][r] == griglia[c + 1][r] && griglia[c][r] == griglia[c + 2][r] && griglia[c][r] == SIMBOLO_O) ||
                        (griglia[c][r] == griglia[c + 1][r - 1] && griglia[c][r] == griglia[c + 2][r - 2] && griglia[c][r] == SIMBOLO_O) ||
                        (griglia[c][r] == griglia[c - 1][r + 1] && griglia[c][r] == griglia[c - 2][r + 2] && griglia[c][r] == SIMBOLO_O)) {
                    return 'O';
                }
            }
        }
        return 'N';
    }

    public boolean stallo(){
        for (int r = 0; r < N_CASELLE; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                if (griglia[c][r] == CASELLA_VUOTA) return false;
            }
        }
        return true;
    }

}
