import java.util.ArrayList;
import java.util.List;

public class Zombie extends Personaggio {
    private List<Personaggio> schiavi = new ArrayList<>();
    public Zombie(String nome){
        super(nome,50,50,200,Armi.PUGNO);
    }

    public void cattura(Personaggio p){
        schiavi.add(p);

    }

    public List<Personaggio> getSchiavi(){
        return schiavi;
    }

    @Override
    public String toString() {
        String s = "";
        s+= "Zombie{" +
                "arma=" + arma +
                ", Personaggi catturati: ";
        for (Personaggio p: schiavi){
            s+=p.getNome();
            s+=" ";
        }

        return s;
    }
}
