void datiProva(List<Articolo> regali){
    regali.add(new Articolo("ABC123","Bolle di sapone",1.5f));
    regali.add(new Articolo("CCD342","Cavallo peluche",8.5f));
    regali.add(new Articolo("DBB342","Formine biscotti",0.5f));
    regali.add(new Articolo("VBC232","Tappetino caffè",5.5f));
    regali.add(new Articolo("VXC121","Scatola misteriosa",10.2f));
}

void inserisci(List<Articolo> regali) {
    boolean errore=true;

    while (errore){
        Articolo regalo= null;
        errore=false;
        String id = IO.readln("ID articolo, formato ABC123: ").trim().toUpperCase();
        String descrizione = IO.readln("Descrizione articolo: ").trim();
        float prezzo= 0.0f;
        try {
            prezzo = Float.parseFloat(IO.readln("Prezzo articolo: "));
        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Inserisci il prezzo come numero");
            System.out.println();
        }
        if (errore==false){
            try {
                regalo = new Articolo(id,descrizione,prezzo);
            }
            catch (IllegalArgumentException e){
                errore=true;
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        if (errore==false){
            boolean trova = false;
            for (int i = 0; i < regali.size(); i++) {
                if (Objects.equals(id, regali.get(i).getId())) {
                    trova = true;
                    break;
                }
            }

            if (trova==true) {
                System.out.println("! - ID già presente nell'archivo");
                errore=true;
                System.out.println();
            }
            else regali.add(regalo);
        }
    }
    System.out.println("Articolo aggiunto con successo");
    System.out.println();
}

void visualizza(List<Articolo> regali){
    System.out.println("Ci sono " + regali.size() + " regali in archivio ");
    for (int i = 0; i < regali.size(); i++) {
        System.out.print((i+1) + " ");
        System.out.println(regali.get(i));
    }
    System.out.println();
}

int seleziona(List<Articolo> regali){
    boolean errore= true;
    int sel = -1;
    while (errore){
        errore=false;
        visualizza(regali);
        try {
            sel = Integer.parseInt(IO.readln("Indica il numero di fronte all'articolo da selezionare: "));

        }
        catch (Exception e){
            errore=true;
            System.out.println("! - Selezione non valida");
            System.out.println();
        }
        if (errore==false){
            if (sel>0 && sel<=regali.size()){
                return sel-1;
            }
            else {
                errore=true;
                System.out.println("! - Selezione non valida");
                System.out.println();
            }
        }

    }
    return sel;
}

void elimina(List<Articolo> regali){
    if (regali.isEmpty()){
        System.out.println("! - Non ci sono articoli registrati");
        System.out.println();
        return;
    }
    int sel = seleziona(regali);
    regali.remove(sel);
    System.out.println("Articolo eliminato");
    System.out.println();
}

void statistiche (List<Articolo> regali){
    System.out.println("--- Statistiche archivio ---");
    System.out.println("Ci sono " + regali.size() + " regali in archivio ");
    int somma = 0;
    for (int i = 0; i < regali.size(); i++) {
        somma += regali.get(i).getPrezzo();
    }
    System.out.println("Prezzo medio: " + (somma/regali.size()));
    System.out.println();

}

void main() {
    boolean continua = true;
    List<Articolo> regali = new ArrayList<>();
    System.out.println("---- Gestione articoli di regalo ----");

    while (continua){
        System.out.println("1. Inserire nuovo articolo \n2. Visualizza tutti i dati \n3. Cancella articolo \n4. Mostra statistiche \n0. Esci");
        String sel = IO.readln("Seleziona un'opzione: ");
        System.out.println();
        switch (sel){
            case "1":
                inserisci(regali);
                break;
            case "2":
                visualizza(regali);
                break;
            case "3":
                elimina(regali);
                break;
            case "4":
                statistiche(regali);
                break;
            case "9":
                datiProva(regali);
                break;
            case "0":
                continua=false;
                break;
            default:
                System.out.println("! - Selezione non valida...");

        }
    }

}
