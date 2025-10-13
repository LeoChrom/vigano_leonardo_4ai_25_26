import javax.naming.LimitExceededException;

public class Furgone {
    //attributi funzionali
    private final int capienza; //non si puo modificare una volta assegnato
    private int spesa; //1 unità occupata = 10 euro di spesa

    //attributi di stato
    private int unita; //unita libere rimanenti


    //costruttore
    /**
     *
     * @param capienza Capienza del furgone espressa in unità
     */
    public Furgone(int capienza){
        this.capienza=capienza;
        spesa=0;
        unita = capienza;
    }

    //metodi

    /**
     *
     * @param dimensione dimensione scatolone dove 1 = piccolo: occupa 1 unità; 2 = medio: 2 unità; 3 = grande: 3 unità
     * @throws LimitExceededException quando il furgone non ha abbastanza spazio per lo scatolone
     * @throws IllegalArgumentException quando il valore dimensione non è tra 1 e 3
     */
    public void caricaScatolone(int dimensione) throws LimitExceededException {
        if (dimensione>0 && dimensione<=3){
            if (unita >= dimensione) {
                unita -= dimensione;
                spesa += (10 * dimensione);
            }
            else throw new LimitExceededException("! - Non c'è abbastanza spazio nel furgone");
        }
        else throw new IllegalArgumentException("! - dimensione scatola non valida");

    }

    /**
     *
     * @return true come conferma dell'avvenuta operazione
     */
    public boolean svuotaFurgone(){
        unita=capienza;
        return true;

    }

    /**
     *
     * @return numero unita rimaste libere
     */
    public int getUnita(){
        return unita;
    }

    /**
     *
     * @return costo di spedizione in euro
     */
    public int getCosto(){
        return spesa;
    }
}
