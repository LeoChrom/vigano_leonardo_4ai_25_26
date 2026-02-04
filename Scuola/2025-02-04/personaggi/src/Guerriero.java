public class Guerriero extends Personaggio{

    private int forza;
    private int resistenza;

    protected Guerriero(String nome) {
        super(nome, 300, 20, 10, Armi.SPADA);
        forza=2;
        resistenza=4;

    }

    @Override
    public String toString() {
        return super.toString() + " Guerriero{" +
                "forza=" + forza +
                ", resistenza=" + resistenza +
                ", arma=" + arma +
                '}';
    }
}
