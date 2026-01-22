import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Scooterino {
    static private List<String> targhe = new ArrayList<String>(); //ricorda la funzione di static

    private String targa;
    private int km;
    private String modello;
    private LocalDate dataAcquisto;
    private Proprietario p;

    public Proprietario getP(){
        return p;
    }

    public void setP(Proprietario p){
        if (p!=null) this.p=p;
        else throw new IllegalArgumentException("! - Proprietario non impostato");
    }

    public String getTarga(){
        return targa;
    }


    public void setTarga(String targa) {
        //formato targa LJ3663
        // 6 caratteri alfanum
        // 1 carattere una lettera
        targa = targa.toUpperCase();
        if (targa.matches("[A-Z][0-9A-Z]{5}")==false){
            throw new IllegalArgumentException("Formato targa errato");
        }
        else {
            if (targhe.contains(targa)) throw new IllegalArgumentException("Targa già presente in archivio");
            else {
                targhe.add(targa);
                this.targa=targa;
            }
        }

    }

    public int getKm(){
        return km;
    }

    public void setKm(int k){
        if (k<0) throw new IllegalArgumentException("Chilometraggio negativo");
        else km=k;

    }

    public String getModello(){
        return modello;
    }

    public void setModello(String m){
        if(m.length() < 2) throw new IllegalArgumentException("Min 2 caratteri per il modello");
        else modello=m;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        if(dataAcquisto.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data futura non ammessa");
        else this.dataAcquisto=dataAcquisto;
    }

    public Scooterino(String targa, int km, String modello, LocalDate dataAcquisto, Proprietario p){
        setTarga(targa);
        setKm(km);
        setModello(modello);
        setDataAcquisto(dataAcquisto);
        setP(p);

    }

    @Override
    public String toString() {
        return "Scooterino{" +
                "targa='" + targa + '\'' +
                ", km=" + km +
                ", modello='" + modello + '\'' +
                ", dataAcquisto=" + dataAcquisto +
                ", p=" + p +
                '}';
    }
}
