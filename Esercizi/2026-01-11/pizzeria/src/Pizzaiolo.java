import java.util.ArrayList;
import java.util.List;

public class Pizzaiolo {
    private List<Pizza> pizze;

    Pizzaiolo(){
        pizze = new ArrayList<>();
        pizze.add(new Pizza("Americana",5.60f));
        pizze.add(new Pizza("Ananas",8192.48f));
        pizze.add(new Pizza("Prosciutto e funghi",6.50f));
    }

    public List<Pizza> getPizze() {
        return pizze;
    }

    public void preparaPizzaTavolo(Tavolo t){
        if (!t.getOrdini().isEmpty()){
            for (int i = 0; i < t.getOrdini().size(); i++) {
                Pizza p = t.getOrdini().get(i);
                System.out.println("Preparata la pizza " + p.getNome());
                t.aggTotale(p.getCosto());
            }
        }
    }
}
