import java.util.ArrayList;
import java.util.List;

public class Gestore {
    private List<Automobile> automobili;

    Gestore(){
        automobili=new ArrayList<>();

        //DATI DI PROVA

        automobili.add(new Automobile("Fiat", "Panda", 2018, 9500));
        automobili.add(new Automobile("Volkswagen", "Golf", 2020, 18500));
        automobili.add(new Automobile("Toyota", "Yaris", 2019, 13500));
        automobili.add(new Automobile("Ford", "Focus", 2017, 11000));
        automobili.add(new Automobile("Audi", "A3", 2021, 24500));
        automobili.add(new Automobile("BMW", "Serie 1", 2020, 26500));
        automobili.add(new Automobile("Mercedes", "Classe A", 2019, 23000));
        automobili.add(new Automobile("Peugeot", "208", 2018, 10500));
        automobili.add(new Automobile("Renault", "Clio", 2021, 15500));
        automobili.add(new Automobile("Alfa Romeo", "Giulietta", 2017, 14000));

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
        if (index>-1 && index<automobili.size()) automobili.remove(index);
    }

    public List<Automobile> filtraxData(int anno) {
        List<Automobile> autoFiltrate = new ArrayList<>();
        for (Automobile automobile : automobili) {
            if (automobile.getAnno() == anno) autoFiltrate.add(automobile);
        }
        return autoFiltrate;
    }
}
