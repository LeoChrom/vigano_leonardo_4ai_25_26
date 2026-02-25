public abstract class Dolce {
    protected String id;
    protected String nome;
    protected boolean rischioAllergia;

    public Dolce(String id, String nome, boolean rischioAllergia) {
        setId(id);
        setNome(nome);
        this.rischioAllergia = rischioAllergia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.matches("[A-Z]{2}[0-9]{3}")) this.id = id;
        else throw new IllegalArgumentException("! - Formato id non valido (AA123)");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length()<3 || nome.length() >15) throw new IllegalArgumentException("! - nome; Min 3 caratteri, Max 15, no numeri");
        this.nome=nome;
    }

    public boolean getRischioAllergia() {
        return rischioAllergia;
    }

    /**
     *
     * @return sconto massimo applicabile
     */
    public abstract float scontoMax();

    @Override
    public String toString() {
        return "Dolce{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", rischioAllergia=" + rischioAllergia +
                '}';
    }

}
