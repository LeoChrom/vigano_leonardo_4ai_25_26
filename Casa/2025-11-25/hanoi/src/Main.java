void main() {
    int numDischi=2;
    System.out.println("--- TORRE DI HANOI ---");

    boolean errore=true;
    while (errore){
        errore=false;
        try {
            numDischi = Integer.parseInt(IO.readln("Inserisci il numero di dischi (2-8):"));
        } catch (NumberFormatException e) {
            errore=true;
            System.out.println("! - Selezione non valida");
            System.out.println();
        }
    }

    try {
        Rastrelliera gioco = new Rastrelliera(numDischi);

        System.out.println("Inizia la partita, con " + numDischi + " dischi!");
        System.out.println();
        System.out.println("Obiettivo: spostare tutti i dischi sulla torre 2 o 3");
        System.out.println();

        while (gioco.chkVincita()==false) {
            stampaTorri(gioco);
            int origine = 0;
            int destinazione = 0;

            errore=true;
            while (errore){
                errore=false;
                System.out.print("\n");
                try {
                    origine = Integer.parseInt(IO.readln("Da quale torre vuoi prelevare? (1-3): "));
                } catch (NumberFormatException e) {
                    errore=true;
                    System.out.println("! - Selezione non valida");
                    System.out.println();
                }
            }

            errore=true;
            while (errore){
                errore=false;
                try {
                    destinazione = Integer.parseInt(IO.readln("In quale torre vuoi spostare? (1-3): "));
                } catch (NumberFormatException e) {
                    errore=true;
                    System.out.println("! - Selezione non valida");
                    System.out.println();
                }
            }

            try {
                gioco.spostaDisco(origine, destinazione);
                System.out.println("Mossa effettuata! Mosse totali: " + gioco.getMosse());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n*** HAI VINTO! ***");
        System.out.println("Hai completato il gioco in " + gioco.getMosse() + " mosse!");

    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}

private static void stampaTorri(Rastrelliera gioco) {
    System.out.println("\n--- STATO TORRI ---");
    System.out.println("Torre 1: " + gioco.otTorre(1));
    System.out.println("Torre 2: " + gioco.otTorre(2));
    System.out.println("Torre 3: " + gioco.otTorre(3));
}
