public class Lampadina {
    static private int conta = 0;
    private final int maxAccensioni=10;
    private int x, y;
    private int id;
    private int accensioni;
    private StatoLam stato;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getAccensioni() {
        return accensioni;
    }

    public StatoLam getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "Lampadina{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                ", accensioni=" + accensioni +
                ", stato=" + stato +
                '}';
    }

    public Lampadina(){
        x = 0;
        y=0;
        accensioni=0;
        stato=StatoLam.SPENTA;

        id = conta;
        conta++;

    }

    public void posiziona (int x, int y){
        setX(x);
        setY(y);
    }

    //prova ad accendere
    //se è gia accesa o rotta richiesta ignorata
    //supera acc max si brucia
    public void accendi (){
        if (stato==StatoLam.SPENTA){
            stato=StatoLam.ACCESA;
            accensioni++;
            if (accensioni>maxAccensioni){
                stato = StatoLam.FOLGORATA;

            }
        }
    }
    public void spegni (){
        if (stato == StatoLam.ACCESA){
            stato=StatoLam.SPENTA;
        }
    }

}
