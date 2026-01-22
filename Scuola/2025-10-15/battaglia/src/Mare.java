public class Mare {
    public final int righe;
    public final int colonne;
    private char [][] mare;

    public Mare(int righe, int colonne, char simbolo) {
        this.righe = righe;
        this.colonne = colonne;
        this.mare = new char[righe][colonne];

        for (int r = 0; r < righe ; r++) {
            for (int c = 0; c < colonne; c++) {
                mare [r][c] = simbolo;
            }
        }
    }

    public void addCorsaro (char lettera, int riga, int colonna){
        mare[riga][colonna] = lettera;
    }

    public char getMare(int riga, int colonna){
        return mare[riga][colonna];
    }


    /**
     * Aggiunge un muro verticale alla matrice 'mare' partendo da una posizione specificata.
     *
     * @param riga     la riga iniziale da cui cominciare a costruire il muro
     * @param colonna  la colonna in cui costruire il muro
     * @param lunghezza la lunghezza del muro, ovvero il numero di celle da riempire verticalmente
     * Il muro viene rappresentato con il carattere '|'.
     * Ogni cella nella colonna specificata, a partire dalla riga iniziale fino alla lunghezza indicata,
     * viene riempita con il carattere del muro.
     */

    public void addMuro(int riga, int colonna, int lunghezza){
        for(int u = 0; u<lunghezza; u++){
            mare[riga+u][colonna]= '|';
        }
    }
}
