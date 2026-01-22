void visualizza(char[][] mtrx, final int RIGHE, final int COLONNE){
    System.out.println("1   2   3   4   5   6   7");
    for (int r = 0; r < RIGHE ; r++) {
        for (int c = 0; c < COLONNE; c++) {
            System.out.print(mtrx[r][c]);
            System.out.print(" ");
            System.out.print("|");
            System.out.print(" ");
        }
        System.out.println();
    }
}

void main() {
    Griglia forza4 = new Griglia(6,7);
    char [][] tabella4=forza4.getGriglia();



    //variabili di controllo
    int turno=1;
    boolean gioco = true;
    boolean errore;

    while (gioco){
        errore=false;

        visualizza(tabella4,6,7);
        System.out.println("Giocatore "+ turno );
        int colonna;
        try {
            System.out.print("Inserisci colonna: ");
            colonna = Integer.parseInt(IO.readln());
            forza4.inserisciPedina(colonna,turno);
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Colonna non valida oppure occupata, segui i numeri indicati");
        }


        if (!errore) {
            if (forza4.chkVincita()){
                gioco=false;
                System.out.println("!! - Partita conclusa");
                System.out.println("Vince il giocatore " + turno);
                visualizza(tabella4,6,7);
            }

            switch (turno){
                case 1:
                    turno=2;
                    break;
                case 2:
                    turno=1;
                    break;
            }

            if (forza4.chkPareggio()){
                System.out.println("!! - Pareggio");
                visualizza(tabella4,6,7);
                gioco=false;
            }

        }
        System.out.println();
    }


}
