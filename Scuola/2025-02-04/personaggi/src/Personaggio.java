import javax.print.attribute.standard.PrinterURI;

public class Personaggio {
    private String nome;
    private int vita;
    private int stamina;
    private int danni;
    private int livelloXp;
    public Armi arma;

    public Personaggio (String nome){
        vita=100;
        danni=20;
        livelloXp=1;
        stamina=20;
        arma=Armi.PUGNO;
        setNome(nome);

    }

    protected Personaggio(String nome, int vita, int danni, int stamina, Armi arma){
        setNome(nome);
        setVita(vita);
        setDanni(danni);
        setStamina(stamina);
        this.arma=arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()&&nome.length()<=20) this.nome = nome;
        else throw new IllegalArgumentException("! max 20 car per il nome");
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        if (vita<0) throw new IllegalArgumentException("Vita non puo essere negativo");
        this.vita = vita;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina < 0) throw new IllegalArgumentException("La stamina non può essere minore di 0");
        this.stamina = stamina;
    }

    public int getDanni() {
        return danni;
    }

    public void setDanni(int danni) {
        if (danni<=0) throw new IllegalArgumentException("Danni non può essere min. di 0");
        this.danni = danni;
    }

    public int getLivelloXp() {
        return livelloXp;
    }

    public void attacca(Personaggio p, int danno){
        p.setVita(p.getVita()-danno);
    }

    public Armi getArma() {
        return arma;
    }

    @Override
    public String toString() {
        return "Personaggio{" +
                "nome='" + nome + '\'' +
                ", vita=" + vita +
                ", stamina=" + stamina +
                ", danni=" + danni +
                ", livelloXp=" + livelloXp +
                ", arma=" + arma +
                '}';
    }
}

