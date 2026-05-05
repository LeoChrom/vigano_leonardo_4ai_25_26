public class ClasseSgl {
    static private ClasseSgl istanza;
    private String nome;

    private ClasseSgl(){
        nome=new String();
    }

    static public ClasseSgl getIstanza() {
        if (istanza==null) istanza= new ClasseSgl();
        return istanza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ClasseSgl{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
