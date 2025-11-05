void aggiungi(List<Brano> listaBrani){
    boolean errore = false;

    System.out.println("-- Nuovo brano --");

    errore=true;
    while (errore){
        errore=false;
        System.out.print("Titolo: ");
        String titolo = IO.readln();
        System.out.print("Artista: ");
        String artista = IO.readln();

        int anno=0;
        int copie=0;

        try {
            System.out.print("Anno: ");
            anno = Integer.parseInt(IO.readln());
            System.out.print("Copie vendute: ");
            copie = Integer.parseInt(IO.readln());
        }
        catch (Exception e){
            System.out.println("! - Inserisci un numero per l'anno e per le copie vendute");
            errore=true;
            System.out.println();
        }

        if(errore==false){
            try {
                Brano brano = new Brano(titolo,artista,anno,copie);
                listaBrani.add(brano);
            }
            catch (Exception e){
                errore=true;
                System.out.println(e.getMessage());
                System.out.println();
            }
        }


    }
    System.out.println();

}

void visualizza(List<Brano> listaBrani){

}

void main() {
    System.out.println("------ Gestione Brani ------");
    boolean continua = true;
    List<Brano> brani =new ArrayList<>();

    while (continua){
        System.out.println("1. Aggiungi brano \n2. Visualizza brani \n3. Rimuovi brano");
        System.out.print("Seleziona un'opzione: ");
        String sel = IO.readln();
        System.out.println();

        switch (sel){
            case "1":
                aggiungi(brani);
                break;
            case "0":
                continua=false;
                break;
            default:
                System.out.println("! - Opzione non valida");

        }
    }
}
