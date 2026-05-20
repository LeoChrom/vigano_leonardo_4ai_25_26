public class Corso {
    private String nome;
    private boolean goldRichiesto;
    private int nIscritti;

    public Corso(String nome, boolean goldRichiesto){
        if (nome.length()>1) this.nome=nome;
        else throw new IllegalArgumentException("! - Nome corso min 1 carattere");
        this.goldRichiesto=goldRichiesto;
    }

    public String getNome() {
        return nome;
    }

    public boolean getGold(){
        return goldRichiesto;
    }

    public int getIscritti(){
        return nIscritti;
    }

}
