void main() {
    Tavolo[] tavoli = new Tavolo[Tavolo.MAX_POS];
    for (int i = 0; i < Tavolo.MAX_POS; i++) {
        tavoli[i]=new Tavolo(i+1);
    }
    Cameriere cameriere1 = new Cameriere();
    Cameriere cameriere2 = new Cameriere();
    boolean continua = true;

    System.out.println("--- Gestione Pizzeria ---");
    while (continua){
        System.out.println("Prendi le ordinazioni dai clienti: \n  1A. Cameriere 1 \n  1B. Cameriere 2 \n2. Prepara le pizze \n3. Calcola il conto \n0. Esci");
        String sel = IO.readln("Opzione: ");
        sel=sel.toUpperCase();
        switch (sel){
            case "1A":
                prendiOrdini(cameriere1, tavoli);
                break;
            case "1B":
                prendiOrdini(cameriere2,tavoli);
                break;
            case "2":
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

public void prendiOrdini(Cameriere cameriere, Tavolo[] t){


}