public class Televisione {
    //attributi funzionali
    public float dimensione;
    public String marca;
    public boolean colore;

    //attributi di stato
    public int volume;
    public int canale;
    public boolean accesa;

    // costruttoreee nota come non ce la roba void e il nome corrisp alla classe
    public Televisione() {
        // definisco i valori default
    }

    // metodi
    public void accendi(){
        accesa = true;
    }

    public void spegni(){
        accesa=false;
    }

    public void volumepiu (){
        volume ++;
    }

    //eccetera

}
