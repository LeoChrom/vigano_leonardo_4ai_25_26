import javax.security.auth.Refreshable;
import java.util.ArrayList;
import java.util.List;

public class Articolo {
    //Attributi funzionali
    private String id;
    private String descrizione;
    private float prezzo;

    // costruttori
    Articolo(String id) {
        setId(id);
        descrizione="";
        prezzo=0.0f;

    }

    Articolo(String id, String descrizione, float prezzo) {
        setId(id);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
    }

    //metodi getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id)  {
        if(id.matches("[A-Z]{3}[0-9]{3}")){
            this.id=id;
        }
        else throw new IllegalArgumentException("! - Formato ID non valido");

    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        if (descrizione.length()>=5 && descrizione.length()<=45 ) this.descrizione = descrizione;
        else throw new IllegalArgumentException("! - Descrizione min. 4 caratteri; max 45");
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        if (prezzo>0) this.prezzo = prezzo;
    }


    //funzionalità
    public float scontoApplicabile(){
        if (prezzo<15) return 0.0f;
        float scontoBase = 0.80f;
        float scontoTot = 0.0f;
        scontoTot=prezzo/100 - 0.02f;
        System.out.println(scontoTot);

        return scontoTot;
    }

    @Override
    public String toString() {
        return  "Articolo " + id +
                ", Descrizione: " + descrizione +
                ", Prezzo: " + prezzo;
    }
}
