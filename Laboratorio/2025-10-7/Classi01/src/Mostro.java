import java.awt.*;

public class Mostro {
    private int vita = 100; //= 100 e cacccapupu uso costruttore
    private String nome = "Silvestri";
    private String colore = "Lilla";

    public Mostro(){
        vita=1000;
        nome= "Cipollo";
        colore = "marrone";
    }

    public void cambiaNome(String n){
        nome = n;
    }

    public String mostraNome(){
        return nome;
    }

    public int mostraEnergia(){
        return vita;
    }

}
