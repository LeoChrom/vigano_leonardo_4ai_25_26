import javax.naming.LimitExceededException;

/**
 * <p>
 *     Questa classe rappresenta un furgone utilizzato per il trasporto di scatoloni.
 *     Si possono caricare scatoloni di dimensioni predefinite, si può scaricare completamente il furgone,
 *     calcolare lo spazio rimanente e la spesa di spedizione
 * </p>
 *
 * <p>
 *     Include controlli per evitare che venga caricato uno scatolone quando
 *     non c'è spazio a sufficenza
 * </p>
 *
 */
public class Furgone {

    //attributi funzionali e costanti
    public final int capienza; //non si puo modificare una volta assegnato
    public final int SCATOLONE_PICCOLO = 1;
    public final int SCATOLONE_MEDIO = 2;
    public final int SCATOLONE_GRANDE = 3;
    public final float SPESA_PER_UNITA = 10.00f;

    //COSTANTI SU PUBLIC
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
     * le dimensioni in unità degli scatoloni sono definite dalle costanti
     * @param dimensione dimensione scatolone dove 1 = piccolo, 2 = medio, 3 = grande
     * @throws LimitExceededException quando il furgone non ha abbastanza spazio per lo scatolone
     */
    private void caricaScatolone(int dimensione) throws LimitExceededException {
        if (dimensione>unita){
            throw new LimitExceededException("! - Non c'è abbastanza spazio nel furgone");
        }
        unita-=dimensione;
    }

    /**
     * Carica uno scatolone piccolo. Dimensioni definite dalla costante
     * @throws LimitExceededException quando il furgone non ha abbastanza spazio per lo scatolone
     */
    public void caricaScatolaPiccola() throws LimitExceededException {
        caricaScatolone(SCATOLONE_PICCOLO);
    }

    /**
     * Carica uno scatolone medio. Dimensioni definite dalla costante
     * @throws LimitExceededException quando il furgone non ha abbastanza spazio per lo scatolone
     */
    public void caricaScatolaMedia() throws LimitExceededException {
        caricaScatolone(SCATOLONE_MEDIO);
    }

    /**
     * Carica uno scatolone grande. Dimensioni definite dalla costante
     * @throws LimitExceededException quando il furgone non ha abbastanza spazio per lo scatolone
     */
    public void caricaScatolaGrande() throws LimitExceededException {
        caricaScatolone(SCATOLONE_GRANDE);
    }


    public void svuotaFurgone(){
        unita=capienza;
    }

    /**
     *
     * @return Numero unità rimaste libere
     */
    public int getUnita(){
        return unita;
    }

    /**
     *
     * @return costo di spedizione in euro
     */
    public float getCosto(){
        return SPESA_PER_UNITA*(-(unita-capienza)); //metodo calcolato; risultato calcolato al momento
        //questo mi permette di occupare meno spazio nella classe
    }
}
