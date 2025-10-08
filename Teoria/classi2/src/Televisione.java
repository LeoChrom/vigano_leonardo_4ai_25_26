public class Televisione {
    //attributi funzionali
    public float dimensione;
    public String marca;
    public boolean colore;

    //attributi di stato
    public int volume;
    private int canale;
    public boolean accesa;

    //Information hiding una classe DOVREBBE avere gli attributi private
    //modificatori di accesso!!  se metto private non accedo dall'esterno
    //privato + metodi = prinicipio di information hiding


    // costruttoreee nota come non ce la roba void e il nome corrisp alla classe
    public Televisione(String marca) {
        marca=marca;
        // definisco i valori default
    }

    // metodi
    //Incapsulation: metodi x comunicare con il mondo esterno
    public void accendi(){
        accesa = true;
    }
    public void spegni(){
        accesa=false;
    }
    public void alzaVolume(){
        volume ++;
    }
    public void abbassaVolume(){
        volume--;
    }
    public void incrementaCanale(){
        canale++;
    }
    public void decrementaCanale(){
        canale--;
    }
    public void impostaCanale (int canale){
        if(canale<=0){
            System.out.println("Il canale non può essere negativo");
        }
        else {
            this.canale=canale;
        }
    }


    //eccetera

}
