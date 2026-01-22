import java.util.ArrayList;
import java.util.List;

public class Gestore {
    private List<Automobile> automobili;

    Gestore(){
        automobili=new ArrayList<>();
    }

    public void createAuto(String marca, String modello, int anno, float prezzo){
        automobili.add(new Automobile(marca,modello,anno,prezzo));

    }

    List<Automobile> getAuto(){
        return automobili;
    }

    public void updatePrezzo(int index, float newprz){
        if (index>0 && index<automobili.size()){
            Automobile automobile = automobili.get(index);
            automobile.setPrezzo(newprz);
        }
    }

    public void eliminaAuto(int index){
        if (index>0 && index<automobili.size()) automobili.remove(index);
    }

    public List<Automobile> filtraxData(int anno) {
        List<Automobile> autoFiltrate = new ArrayList<>();
        for (Automobile automobile : automobili) {
            if (automobile.getAnno() == anno) autoFiltrate.add(automobile);
        }
        return autoFiltrate;
    }
}
