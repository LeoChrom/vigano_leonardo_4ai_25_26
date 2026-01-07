//1 - nuova lampada
//2 - accendere e spegnere lampadine
//3 - quante sono ed elimina lamp bruciate
//4 - statistica numero accensioni riuscite
//5 - posizione lampadine

private List<Lampadina> lampadine;

void main() {
    lampadine = new ArrayList<>();
    boolean c = true;

    while (c){
        String sel = IO.readln();
        switch (sel){
            case "1":
                nuovaLamp(lampadine);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "X":
                c=false;

        }
    }

}

public void nuovaLamp(List<Lampadina> lampadine){
    lampadine.add(new Lampadina());
    System.out.println("Aggiunta lampadina");
}

public void contaRotte(List<Lampadina> lampadine){
    int c = 0;
    for (int i = 0; i < lampadine.size(); i++) {
        if (lampadine.get(i).getStato()==StatoLam.FOLGORATA) c++;
    }


}