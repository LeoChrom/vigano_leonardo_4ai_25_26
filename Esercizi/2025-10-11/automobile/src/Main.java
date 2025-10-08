public class Main {
    public static void main(String[] args) {
        Automobile auto = new Automobile("Lancia","Thema i.e. 16v",1993);

        int eta=auto.calcolaEta(1993);
        System.out.println("L'automobile " + auto.getMarca() + " " + auto.getModello() + " ha " + eta + " anni");

        auto.stampaDettagli();
        auto.aggiornaChilometraggio(34.45f);
        //auto.aggiornaChilometraggio(22.00f);
        System.out.println();
        auto.stampaDettagli();
    }
}