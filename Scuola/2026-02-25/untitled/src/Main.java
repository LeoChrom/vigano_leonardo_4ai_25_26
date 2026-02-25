import java.time.LocalDate;


void main() {


    List<Persona> persone = new ArrayList<Persona>();

    persone.add(new Persona("Alessio", "Amato", 42));
    persone.add(new Persona("Carlo", "Bacuzzi", 18));
    persone.add(new Persona("Cicco", "Pasticcio", 55));
    LocalDate date = LocalDate.of(2017, 3,12);
    persone.add(new Bambino("Luca","Orsini",8,date));


    //salvare la lista delle persone su file
    try {
        GestorePersoneFile.salvaPersone(persone);
    } catch (IOException e){
        System.out.println("Errore di scrittura dei dati su file.");
    }

    persone.clear();

    //ricaricaricare la lista dal file
    try {
        persone = GestorePersoneFile.caricaPersone();
    } catch (IOException e){
        System.out.println("Errore di lettura dei dati su file.");
    }

    // stampa della lista
    for (Persona p: persone) {
        System.out.println(p);
    }
}
