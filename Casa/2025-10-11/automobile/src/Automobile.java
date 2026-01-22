public class Automobile {

    private String marca;
    private String modello;
    private int anno;
    private float chilometraggio;

    public Automobile(String marca, String modello, int anno){
        this.marca=marca;
        this.modello=modello;
        this.anno=anno;
        this.chilometraggio=0.0f;
    }

    public String getMarca(){
        return marca;
    }

    public String getModello(){
        return modello;
    }


    public void aggiornaChilometraggio(float nuovoChilometraggio){
        if (nuovoChilometraggio>chilometraggio) chilometraggio=nuovoChilometraggio;
        else throw new IllegalArgumentException("! - Chilometraggio inferiore a quello attuale");


    }

    public int calcolaEta(int annoAtt){
        int eta;
        if (annoAtt>=anno) eta=annoAtt-anno;
        else throw new IllegalArgumentException("! - Anno non valido");
        return eta;
    }

    public void stampaDettagli(){
        System.out.println("Marca: " + marca + "\nModello: "+ modello + "\nAnno: " + anno+ "\nChilometraggio: " + chilometraggio);
    }
}
