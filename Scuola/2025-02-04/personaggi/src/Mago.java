import java.util.Random;

public class Mago extends Personaggio {
    private int aura;
    private Potere potere;

    protected Mago(String nome){
        super(nome, 150,50,20,Armi.BACCHETTA);
        aura=1;
        scegliTipo();
    }

    private void scegliTipo(){
        Random n = new Random();
        int numero =n.nextInt(1,4);
        switch (numero){
            case 1:
                potere=Potere.ELETTRICO;
                break;
            case 2:
                potere=Potere.FUOCO;
                break;
            case 3:
                potere=Potere.GHIACCIO;
                break;
        }
    }

    private enum Potere{
        GHIACCIO, FUOCO, ELETTRICO
    }

    @Override
    public String toString() {
        return super.toString()+" ---- Mago{" +
                "aura=" + aura +
                ", potere=" + potere +
                ", arma=" + arma +
                '}';
    }
}
