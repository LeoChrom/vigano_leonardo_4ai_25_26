import java.time.LocalDate;
List<Scooterino> archivio= new ArrayList<Scooterino>();
List<Proprietario> anagrafica = new ArrayList<>();

void datiDiProva(){
    anagrafica.add(new Proprietario("RSSMRA80A01H501Z", "Mario", "Rossi"));
    anagrafica.add(new Proprietario("VRDLGI85B12F205X", "Luigi", "Verdi"));
    anagrafica.add(new Proprietario("BNCLRA90C23L219Y", "Clara", "Bianchi"));
    anagrafica.add(new Proprietario("FRNGPP75D14M345Z", "Giuseppe", "Franchi"));
    anagrafica.add(new Proprietario("LNGSRA88E09T678X", "Sara", "Longhi"));
    archivio.add(new Scooterino("D12345", 3432, "Malaguti f10", LocalDate.of(2000, 1, 29),anagrafica.get(0)));
    archivio.add(new Scooterino("A12345", 1232, "Aprilia 125 RX", LocalDate.of(2005, 1, 29),anagrafica.get(1)));
    archivio.add(new Scooterino("C12345", 4345, "Vespa P80", LocalDate.of(2009, 1, 29),anagrafica.get(2)));
    archivio.add(new Scooterino("L12345", 5000, "KTM K3", LocalDate.of(2002, 1, 29),anagrafica.get(3)));
    archivio.add(new Scooterino("U12345", 3212, "Malaguti f10", LocalDate.of(2007, 1, 29),anagrafica.get(4)));
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

void visualizzaProp(List<Proprietario> anagrafica){
    System.out.println("Proprietari presenti: " + anagrafica.size());
    int i = 1;
    for (Proprietario p : anagrafica) {
        IO.print(i);
        IO.println(" " + p);
        i++;
    }
    System.out.println();
}

Scooterino selezionaScooter(List<Scooterino> lista){
    visualizza(lista);
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

Proprietario selezionaProp(List<Proprietario> anagrafica){
    if (anagrafica.isEmpty()){
        System.out.println("! - Nessun proprietario registrato, inserisci un proprietario prima di registrare uno scooterino");
        return null;
    }
    visualizzaProp(anagrafica);
    String t = IO.readln("Inserisci il codice fiscale del proprietario: ");
    Proprietario selezione = null;
    if(anagrafica.size()==0) return selezione;
    int i = 0;
    try {
        while (selezione == null || i< anagrafica.size() ) {
            if (anagrafica.get(i).getCF().equals(t)){
                selezione = anagrafica.get(i);
            }
            i++;
        }
    }
    catch (IndexOutOfBoundsException e){
        System.out.println("! Proprietario non trovato. controlla il CF");
        System.out.println();
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

void eliminaProprietario(List<Scooterino> scooterinos, List<Proprietario> proprietarios){
    boolean errore=true;
    Proprietario p = selezionaProp(anagrafica);
    if (p==null) return;
}

void inserisci(List<Scooterino> lista, List<Proprietario> anagrafica){
    boolean errore=true;
    Proprietario p = selezionaProp(anagrafica);
    if (p==null) return;

    while (errore){
        String t=null;
        LocalDate da = null;
        int km=-1;
        errore=false;
        System.out.println();
        String m = IO.readln("Inserisci modello: ");

        try {
            t = IO.readln("Inserisci targa: ");
            km = Integer.parseInt(IO.readln("Inserisci kilometri: "));
            da = LocalDate.parse(IO.readln("Data di acquisto : "));
            archivio.add(new Scooterino(t,km,m,da,p));
        } catch (Exception e){
            errore=true;
            System.out.println("!- Dati inseriti errati");
        }
    }
    System.out.println();
}

void inserisciProp(List<Proprietario> anagrafica){
    System.out.println("---Nuovo proprietario---");
    boolean errore = true;
    while (errore){
        errore=false;
        String nome= IO.readln("Nome: ");
        String cognome = IO.readln("Cognome: ");
        String cf = IO.readln("Codice fiscale: ");

        try {
            Proprietario newp = new Proprietario(cf,nome,cognome);
            anagrafica.add(newp);
            System.out.println("Proprietario aggiunto correttamente");
            System.out.println();
        }
        catch (Exception e){
            errore=true;
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}

void main() {

    System.out.println("---------Gestione scoooterini---------");
    boolean continua = true;
    while (continua){
        System.out.println("1. Nuovo scooter \n2. Visualizza tutto \n3. Elimina scooter \n4. Dati di prova \n5. Inserisci proprietario \n6. Visualizza proprietari \n7. Elimina proprietario \n0. Esci");
        System.out.print("Scegli un'opzione: ");
        String sel = IO.readln();
        System.out.println();
        switch (sel){
            case "1":
                inserisci(archivio,anagrafica);
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
            case "5":
                inserisciProp(anagrafica);
                break;
            case "6":
                visualizzaProp(anagrafica);
                break;
            case "7":
                eliminaProprietario(archivio,anagrafica);
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
