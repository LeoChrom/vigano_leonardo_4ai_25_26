void visualizza(char[][] mtrx, final int RIGHE, final int COLONNE){
    System.out.println("- 1   2   3");
    for (int r = 0; r < RIGHE ; r++) {
        System.out.print(r+1 + " ");
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
    //creo oggetto e ottengo griglia
    Griglia tris = new Griglia();
    char [][] griglia = tris.getGriglia();

    //variabili di controllo
    int turno=1;
    boolean gioco = true;
    boolean errore;

    while (gioco){
        errore=false;

        visualizza(griglia,tris.RIGHE,tris.COLONNE);
        System.out.println("Giocatore "+ turno );
        int riga;
        int colonna;
        try {
            System.out.print("Inserisci riga: ");
            riga = Integer.parseInt(IO.readln());

            System.out.print("Inserisci colonna: ");
            colonna = Integer.parseInt(IO.readln());

            tris.setCella(riga-1,colonna-1,turno);
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Casella non valida oppure occupata, segui i numeri indicati");
        }


        if (!errore) {
            if (tris.chkVincita()==true){
                gioco=false;
                System.out.println("!! - Partita conclusa");
                System.out.println("Vince il giocatore " + turno);
                visualizza(griglia,tris.RIGHE,tris.COLONNE);
            }

            switch (turno){
                case 1:
                    turno=2;
                    break;
                case 2:
                    turno=1;
                    break;
            }

            if (tris.chkPareggio()){
                System.out.println("!! - Pareggio");
                visualizza(griglia,tris.RIGHE,tris.COLONNE);
                gioco=false;
            }

        }
        System.out.println();
    }

}
