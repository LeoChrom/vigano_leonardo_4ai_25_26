import java.time.LocalDate;

public class Automobile {
    private String marca;
    private String modello;
    private int anno;
    private float prezzo;

    Automobile(String marca, String modello, int anno, float prezzo){
        setMarca(marca);
        setModello(modello);
        setAnno(anno);
        setPrezzo(prezzo);
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String ma) {
        if (ma.length()<2) throw new IllegalArgumentException("! - Min 2 car per marca");
        else marca=ma;
}

    public String getModello() {
        return modello;
    }

    private void setModello(String mo) {
        if (mo.length()<1) throw new IllegalArgumentException("! - Min 1 car per modello");
        else modello=mo;
    }

    public int getAnno() {
        return anno;
    }

    private void setAnno(int a) {
        if (a<1900 || a> LocalDate.now().getYear()) throw new IllegalArgumentException("! - annno non valido, non può essere futuro o prima del 1900");
        else anno=a;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float p) {
        if (p<100) throw new IllegalArgumentException("! - prezzo non valido");
        else prezzo=p;
    }

    @Override
    public String toString() {
        return "Automobile: " +
                "   marca: " + marca + '\n' +
                "   modello: " + modello + '\n' +
                "   anno: " + anno +
                "   prezzo: " + prezzo;
    }
}
