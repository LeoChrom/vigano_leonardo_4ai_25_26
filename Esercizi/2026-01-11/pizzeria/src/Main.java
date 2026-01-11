void main() {
    Tavolo[] tavoli = new Tavolo[Tavolo.MAX_POS];
    for (int i = 0; i < Tavolo.MAX_POS; i++) {
        tavoli[i]=new Tavolo(i+1);
    }
    Cameriere cameriere1 = new Cameriere();
    Cameriere cameriere2 = new Cameriere();
    Pizzaiolo pizzaiolo = new Pizzaiolo();
    boolean continua = true;

    System.out.println("--- Gestione Pizzeria ---");
    while (continua){
        System.out.println("Prendi le ordinazioni dai clienti: \n  1A. Cameriere 1 \n  1B. Cameriere 2 \n2. Prepara le pizze \n3. Calcola il conto \n0. Esci");
        String sel = IO.readln("Opzione: ");
        sel=sel.toUpperCase();
        switch (sel){
            case "1A":
                prendiOrdini(cameriere1, tavoli, pizzaiolo);
                break;
            case "1B":
                prendiOrdini(cameriere2,tavoli,pizzaiolo);
                break;
            case "2":
                prepara(pizzaiolo,tavoli);
                break;
            case "3":
                break;
            case "0":
                continua=false;
                break;
            default:
                System.out.println("opz. non valida!");
        }
        System.out.println();
    }
}
public void vediTotale(Tavolo[] tavoli){
    boolean errore = true;
    Tavolo tavolo = null;
    while (errore){
        errore=false;
        System.out.println("Seleziona il tavolo:");
        int scelta;
        try {
            scelta = Integer.parseInt(IO.readln());
            if (scelta >= 1 && scelta <= tavoli.length) {
                tavolo = tavoli[scelta-1];
            } else {
                errore=true;
                System.out.println("! - Scelta non valida, riprova.");
            }
        } catch (NumberFormatException e) {
            errore=true;
            System.out.println("! Input non valido; Inserisci un numero.");
        }

    }

    System.out.println("Totale dovuto: " + tavolo.getTotale() + "€");
}

public void prepara(Pizzaiolo pizzaiolo, Tavolo[] tavoli){
    boolean errore = true;
    Tavolo tavolo = null;
    while (errore){
        errore=false;
        System.out.println("Seleziona il tavolo:");
        int scelta;
        try {
            scelta = Integer.parseInt(IO.readln());
            if (scelta >= 1 && scelta <= tavoli.length) {
                tavolo = tavoli[scelta-1];
            } else {
                errore=true;
                System.out.println("! - Scelta non valida, riprova.");
            }
        } catch (NumberFormatException e) {
            errore=true;
            System.out.println("! Input non valido; Inserisci un numero.");
        }

    }
    pizzaiolo.preparaPizzaTavolo(tavolo);
}

public void prendiOrdini(Cameriere cameriere, Tavolo[] t, Pizzaiolo p){
    boolean errore = true;
    Tavolo tavolo = null;
    while (errore){
        errore=false;
        System.out.println("Seleziona il tavolo:");
        int scelta;
        try {
            scelta = Integer.parseInt(IO.readln());
            if (scelta >= 1 && scelta <= t.length) {
                tavolo = t[scelta-1];
            } else {
                errore=true;
                System.out.println("! - Scelta non valida, riprova.");
            }
        } catch (NumberFormatException e) {
            errore=true;
            System.out.println("! Input non valido; Inserisci un numero.");
        }

    }

    List<Pizza> pp = p.getPizze();
    for (int i = 0; i < pp.size(); i++) {
        Pizza pizza = pp.get(i);
        System.out.println(pizza.getNome() + " - " + pizza.getCosto()+"€");
    }
    System.out.println();
    int scelta = -1;
    boolean continua = true;
    while (continua) {
        System. out.print("Seleziona una pizza (1-" + p.getPizze().size() + "): ");

        try {
            scelta = Integer.parseInt(IO.readln());
            if (scelta >= 1 && scelta <= p.getPizze().size()) {
                Pizza pizza = pp.get(scelta-1);
                cameriere.prendiOrdine(tavolo,pizza);
                System.out.println("Ordine aggiunto\n");

                continua=false;
                String s = IO.readln("Altri ordini? (s/n) ");
                if (s.toLowerCase().equals("s")) continua=true;
            } else {
                System.out.println("! - Scelta non valida, riprova.");
            }
        } catch (NumberFormatException e) {
            System.out.println("! Input non valido; Inserisci un numero.");
        }
    }
}