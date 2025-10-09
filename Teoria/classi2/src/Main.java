import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Televisione t1 = new Televisione("Samsung",5);
        Televisione t2 = new Televisione(t1); //copia ma diversi non lo stesso!!
        //ricorda cosa succede in memoria

        t1.setCanale(5);
        //ho creato un nuovo tipo di dato!!
        //cosi imposto gli attributi, t1 e l'oggetto, l'istanza della classe



    }
}