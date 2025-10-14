public class Televisione {
    //attributi funzionali
    private int altezza;
    private int larghezza;
    private String marca;

    //attributi di stato
    private int volume;
    private int canale;
    private boolean accesa;

    //costanti -- final
    private final int CANALE_MAX=100;
    private final int VOLUME_MAX=100;

    //Information hiding una classe DOVREBBE avere gli attributi private
    //modificatori di accesso!!  se metto private non accedo dall'esterno
    //privato + metodi = prinicipio di information hiding


    // costruttoreee nota come non ce la roba void e il nome corrisp alla classe
    public Televisione(String marca, int larghezza, int altezza) {
        this.marca=marca;
        canale=1;
        volume=0;
        this.altezza=altezza;
        this.larghezza=larghezza;
        accesa=false;
        // definisco i valori default
    }

    public Televisione(String marca, int canale){
        this.marca=marca;
        setCanale(canale); //sfrutto e devo sfruttare i controlli
        volume=0;
        altezza=0;
        larghezza=0;
        accesa=false;
    }
    //COSTRUTTORE DI COPIA
    public Televisione(Televisione b){
        this.marca=b.marca;
        this.accesa=b.accesa;
        this.volume=b.volume;
        this.altezza=b.altezza;
        this.larghezza=b.larghezza;
        this.canale=b.canale;
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
        if (volume>0) volume--;
        else throw new IllegalArgumentException("! - Volume minimo raggiunto");

    }
    public void incrementaCanale(){
        canale++;
    }
    public void decrementaCanale(){
        if (canale>1) canale--;
        else throw new IllegalArgumentException("! - Tentativo di accesso a canale inesistente");
    }

//JAVA DOC:
    /**
     * Questo metodo serve per impostare il canale
     * @param canale il canale da impostare non può essere negativo
     * @throws IllegalArgumentException quando è negativo
     */

    public void setCanale (int canale){
        if(canale<=0){
            throw new IllegalArgumentException("! - Canale insesistente");
        }
        this.canale=canale;

    }

    /**
     *
     * @return il canale attuale in int
     */
    public int getCanale(){
        return canale;
    }


    //eccetera

}
