import java.time.LocalDate;
List<Scooterino> archivio= new ArrayList<Scooterino>();

void datiDiProva(){
    archivio.add(new Scooterino("D12345", 3432, "Malaguti f10", LocalDate.of(2000, 1, 29)));
    archivio.add(new Scooterino("A12345", 1232, "Aprilia 125 RX", LocalDate.of(2005, 1, 29)));
    archivio.add(new Scooterino("C12345", 4345, "Vespa P80", LocalDate.of(2009, 1, 29)));
    archivio.add(new Scooterino("L12345", 5000, "KTM K3", LocalDate.of(2002, 1, 29)));
    archivio.add(new Scooterino("U12345", 3212, "Malaguti f10", LocalDate.of(2007, 1, 29)));


}

void visualizza(List<Scooterino> lista){
    System.out.println("Scooter presenti: " + lista.size());
    int i = 1;
    for (Scooterino s : archivio) {
        IO.print(i);
        IO.println(" " + s);
        i++;
    }
    System.out.println();
}

Scooterino selezionaScooter(List<Scooterino> lista){
    String t = IO.readln("Inserisci la targa dello scooter da selezionare: ");
    Scooterino selezione = null;
    if(lista.size()==0) return selezione;
    int i = 0;
    while (selezione == null || i< lista.size() ) {
        if (lista.get(i).getTarga().equals(t)){
            selezione = lista.get(i);
        }
        i++;
    }
    return selezione;

}

void modificaScooter(List<Scooterino> lista){

}

void eliminaScooter(List<Scooterino> lista){
    if (lista.size()==0){
        System.out.println("! - non ci sono scooter registrati");
        return;
    }
    Scooterino daEliminare = selezionaScooter(lista);
    if (daEliminare==null){
        System.out.println("! - Scooter non troato");
    } else{
        String s = IO.readln("Vuoi eliminare lo scooter di targa " + daEliminare.getTarga()+" (s/n)? ");
        if (s=="s") lista.remove(daEliminare);
    }

}

void inserisci(List<Scooterino> lista){
    boolean errore=true;

    while (errore){
        String t=null;
        LocalDate da = null;
        int km=-1;
        errore=false;
        String m = IO.readln("Inserisci modello: ");

        try {
            t = IO.readln("Inserisci targa: ");
            km = Integer.parseInt(IO.readln("Inserisci kilometri: "));
            da = LocalDate.parse(IO.readln("Data di acquisto : "));
        } catch (Exception e){
            errore=true;
            System.out.println("!- Dati inseriti errati");
        }

        if(errore==false) archivio.add(new Scooterino(t,km,m,da));
    }
    System.out.println();
}

void main() {

    System.out.println("---------Gestione scoooterini---------");
    boolean continua = true;
    while (continua){
        System.out.println("1. Nuovo scooter \n2. Visualizza tutto \n3. Elimina scooter \n4. Dati di prova \n0. Esci");
        System.out.print("Scegli un'opzione: ");
        String sel = IO.readln();
        System.out.println();
        switch (sel){
            case "1":
                inserisci(archivio);
                break;
            case "2":
                visualizza(archivio);
                break;
            case "3":
                eliminaScooter(archivio);
                break;
            case "4":
                datiDiProva();
                break;
            case "0":
                continua=false;
                break;
            default:
                System.out.println("! - opzione non valida");
                System.out.println();
        }
    }

    //IO.println(f10);
}
