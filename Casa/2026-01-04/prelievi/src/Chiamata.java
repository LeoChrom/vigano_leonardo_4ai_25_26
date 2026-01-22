import java.sql.Timestamp;

public class Chiamata {
    private String codiceBiglietto;
    private String identificativoCassa;
    private Timestamp orario;

    public Chiamata (String c, String i, Timestamp o){
        setCodiceBiglietto(c);
        setIdentificativoCassa(i);
        setOrario(o);

    }
    private void setCodiceBiglietto(String c){
        if (c.matches("[NP][0-9]")) codiceBiglietto = c;
        else throw new IllegalArgumentException("! - Formato id biglietto errato");

    }

    public String getCodiceBiglietto() {
        return codiceBiglietto;
    }

    private void setIdentificativoCassa(String i){
        if (i.matches("CASSA[0-9]")) identificativoCassa =i;
        else throw new IllegalArgumentException("! - Formato id cassa errato");

    }

    public String getIdentificativoCassa() {
        return identificativoCassa;
    }

    private void setOrario(Timestamp o){
        orario=o;

    }

    public Timestamp getOrario() {
        return orario;
    }

    @Override
    public String toString() {
        return "Chiamata{" +
                "codiceBiglietto='" + codiceBiglietto + '\'' +
                ", identificativoCassa='" + identificativoCassa + '\'' +
                ", orario=" + orario +
                '}';
    }
}
