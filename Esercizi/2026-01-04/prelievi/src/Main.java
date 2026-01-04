private Cassa[] casse;
private int scelta;
private Gestore gestore;
private LogChiamate logChiamate;


void main() {
    boolean continua = true;
    logChiamate = new LogChiamate();
    gestore = new Gestore(logChiamate);
    scelta=-1;
    boolean errore= true;
    int ncasse = 0;
    while (errore){
        errore=false;
        try {
            ncasse = Integer.parseInt(IO.readln("Inserisci numero di casse: "));
            if (ncasse<=0) throw new IllegalArgumentException();
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Inserisci un numero\n");
        }
    }
    this.casse = new Cassa[ncasse];
    for (int i = 0; i < ncasse; i++) {
        casse[i]=new Cassa();
    }

    System.out.println("--- Gestione sala d'attesa ---");
    while (continua){
        stampaMenu();
        scelta = chiediScelta();
        System.out.println();
        switch (scelta){
            case 1:
                prenotaBiglietto();
                break;
            case 2:
                usaCassa(casse,gestore);
                break;
            case 3:
                stampaUtentiInCoda(gestore);
                break;
            case 4:
                stampaStoricoChiamate(gestore);
                break;
            case 0:
                continua=false;
                break;
            default:
                System.out.println("! - Sel non valida");
        }
    }


}

public void stampaMenu(){
    System.out.println("\n=== SPORTELLO BIGLIETTI ===");
    System.out.println("1) Cliente – Presa del numero");
    System.out.println("2) Cassa – Chiamata del prossimo cliente");
    System.out.println("3) Visualizza clienti in attesa");
    System.out.println("4) Visualizza elenco delle chiamate effettuate");
    System.out.println("0) Esci");

}
private int chiediScelta(){
    int s = 0;

    boolean errore = true;
    while (errore){
        errore = false;
        try {
            s =Integer.parseInt(IO.readln("Seleziona un'opzione: "));
            return s;
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Selezione non valida");
        }
    }
    return s;

}
public void prenotaBiglietto(){
    String cod;
    System.out.println("\nOttieni un biglietto");
    boolean errore = true;
    while (errore){
        errore=false;
        System.out.println("1. Normale \n2. Prioritario \n3. Indietro");
        String sel = IO.readln("Seleziona: ");
        switch (sel){
            case "1":
                cod=prenotaBigliettoNormale(gestore);
                System.out.println("Il tuo biglietto: " + cod);
                break;
            case "2":
                cod=prenotaBigliettoPrioritario(gestore);
                System.out.println("Il tuo biglietto: " + cod);
                break;
            case "3":
                break;
            default:
                errore=true;
        }
    }
}

public String prenotaBigliettoNormale(Gestore g) {
    g.emettiBigliettoNormale();
    Queue<String> q = g.getCodaNormali();
    String ultimo = null;
    for (String e : q) {
        ultimo = e; // alla fine del ciclo è l’ultimo visto
    }
    return ultimo;
}

public String prenotaBigliettoPrioritario(Gestore g){
    g.emettiBigliettoPrioritario();
    Queue<String> q = g.getCodaPrioritari();
    String ultimo = null;
    for (String e : q) {
        ultimo = e; // alla fine del ciclo è l’ultimo visto
    }
    return ultimo;
}

public void usaCassa(Cassa[] cs, Gestore g){
    boolean errore = true;
    Cassa cassa = null;
    System.out.println("--- Ci sono " + cs.length + " Casse --");
    int ncassa = 0;
    while (errore){
        errore = false;
        try {
            ncassa = Integer.parseInt(IO.readln("ID cassa: "));
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Inserisci un numero a partire da 0");
        }
        if (!errore){
            if (ncassa <cs.length && ncassa>0){
                cassa = casse[ncassa];
            }
            else {
                errore=true;
                System.out.println("! num cassa non valido");
                System.out.println();
            }
        }
    }
    System.out.println();

    boolean cc = true;
    String sel;
    while (cc){
        System.out.println("--- CASSA " + cassa.getIdentificativo() + " ---");
        System.out.println("\n1. Chiama prossimo cliente \n2. Indietro");
        sel = IO.readln("Opzione: ");
        if (sel.equals("2")) cc=false;
        else if (sel.equals("1")) {
            String chiama = cassa.chiamaProssimoCliente(g);
            System.out.println();
            System.out.println("PROSSIMO CLIENTE: " + chiama);
            System.out.println();
        }
    }
}

public void stampaUtentiInCoda(Gestore g){
    List<String> coda = g.getBigliettiInAttesa();
    System.out.println("--- Ci sono " + coda.size() + " clienti attualmente in coda ---");
    for (int i = 0; i < coda.size(); i++) {
        System.out.println("- Biglietto: " + coda.get(i));
    }
}

public void stampaStoricoChiamate(Gestore g){
    List<String> coda = g.getBigliettiInAttesa();
    System.out.println("--- LOG CHIAMATE ---");
    for (int i = 0; i < coda.size(); i++) {
        System.out.println("- Biglietto: " + coda.get(i));
    }
    if (coda.isEmpty()) System.out.println("Nessuna chiamata effettuata");
}