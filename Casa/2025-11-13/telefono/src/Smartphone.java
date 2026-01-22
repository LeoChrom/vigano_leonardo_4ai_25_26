public class Smartphone {
    private String marca;
    private String modello;
    private double prezzo;
    private double numPollici;
    private double ram;
    private boolean touch;

    public Smartphone(){
        marca="marca";
        modello="mod";
        prezzo=0.0;
        numPollici=0.0;
        ram=0.0;
        touch=true;
    }

    public Smartphone(String marca, String modello, double prezzo, double numPollici, double ram, boolean touch) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.numPollici = numPollici;
        this.ram = ram;
        this.touch = touch;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getNumPollici() {
        return numPollici;
    }

    public void setNumPollici(double numPollici) {
        this.numPollici = numPollici;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public boolean getTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public String ottieniFasciaDiPrezzo(){
        if(prezzo>500) return "fascia alta";
        else if (prezzo>200 && prezzo<500) return "fascia media";
        else if (prezzo<200) return "fascia bassa";
        return "";
    }

    public String ottieniTipologia(){
        if (numPollici<5) return "Mini";
        else if (numPollici>5 && numPollici<7) return "Normal";
        else if (numPollici>7) return "Maxi";
        return "";
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", prezzo=" + prezzo +
                ", numPollici=" + numPollici +
                ", ram=" + ram +
                ", touch=" + touch +
                '}';
    }
}
