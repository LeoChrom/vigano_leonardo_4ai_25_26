public class Cameriere {
    private Pizzaiolo pizzaiolo;

    Cameriere(){
        pizzaiolo = new Pizzaiolo();
    }

    public void prendiOrdine(Tavolo t, Pizza pizza) {
        t.addOrdine(pizza);
    }

}
