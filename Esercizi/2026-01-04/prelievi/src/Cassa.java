import java.sql.Timestamp;

public class Cassa {
    private static int progressivo = 0;
    private String identificativo;

    public Cassa(){
        identificativo = "CASSA" + Integer.toString(progressivo);
        progressivo++;
    }

    public String getIdentificativo() {
        return identificativo;
    }

    public String chiamaProssimoCliente(Gestore gestore){
        return gestore.chiamaBiglietto(getIdentificativo());

    }
}
