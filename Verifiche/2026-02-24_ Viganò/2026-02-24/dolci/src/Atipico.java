import java.util.ArrayList;
import java.util.List;

public class Atipico extends Dolce{
    private String provenienza;
    private float prezzoAlPezzo;

    public Atipico(String id, String nome, boolean rischioAllergia, String provenienza, float prezzoAlPezzo) {
        super(id, nome, rischioAllergia);
        setProvenienza(provenienza);
        setPrezzoAlPezzo(prezzoAlPezzo);
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        List<String> pp = new ArrayList<>(List.of("brasile", "cina", "malesia", "norvegia", "danimarca", "altro"));
        boolean t = false;

        for(String p: pp){
            if (provenienza.toLowerCase().equals(p)){
                t=true;
                break;
            }
        }

        if(t)this.provenienza = provenienza;
        else throw new IllegalArgumentException("! - provenienza; Scegli tra brasile, cina, malesia, norvegia, danimarca, altro.");
    }

    public float getPrezzoAlPezzo() {
        return prezzoAlPezzo;
    }

    public void setPrezzoAlPezzo(float prezzoAlPezzo) {
        if (prezzoAlPezzo>0.0f)this.prezzoAlPezzo = prezzoAlPezzo;
        else throw new IllegalArgumentException("! - Prezzo non valido");
    }

    @Override
    public String toString() {
        return "Atipico{" +
                "provenienza='" + provenienza + '\'' +
                ", prezzoAlPezzo=" + prezzoAlPezzo +
                ", id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", rischioAllergia=" + rischioAllergia +
                '}';
    }

    @Override
    public float scontoMax() {
        String pp = provenienza.toLowerCase();
        float sconto = 0;
        switch (pp) {
            case "brasile":
                sconto = 0.90f;
                break;
            case "cina":
                sconto = 0.34f;
                break;
            case "malesia":
                sconto = 0.18f;
                break;
            case "norvegia":
                sconto = 0.25f;
                break;
            case "danimarca":
                sconto = 0.16f;
                break;
            case "altro":
                sconto = 0.08f;
        }

        if (rischioAllergia) sconto += 0.13f;
        return sconto;
    }
}
