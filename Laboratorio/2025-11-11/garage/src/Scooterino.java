import java.time.LocalDate;

public class Scooterino {
    private String targa;
    private int km;
    private String modello;
    private LocalDate dataAcquisto;

    public String getTarga(){
        return targa;
    }

    public void setTarga(String targa) {
        //formato targa LJ3663
        // 6 caratteri alfanum
        // 1 carattere una lettera
        targa = targa.toUpperCase();
        if (targa.matches("[A-Z]{1}[A-Z0-9]{6}")){}

    }

    public int getKm(){
        return km;
    }

    public void setKm(int k){

    }

    public String getModello(){
        return modello;
    }

    public void setModello(String m){

    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Scooterino(String targa, int km, String modello, LocalDate dataAcquisto){


    }

}
