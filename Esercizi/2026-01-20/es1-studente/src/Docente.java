public class Docente extends Persona{
    private String materia;
    private int salario;

    public Docente(String codFiscale, String nome, String cognome, String materia, int salario) {
        super(codFiscale, nome, cognome);
        setMateria(materia);
        setSalario(salario);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia.length()<3) throw new IllegalArgumentException("!- materia min 3 caratteri");
        else this.materia=materia;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        if (salario<1000 || salario>9999) throw new IllegalArgumentException("!- salario non valido");
        else this.salario=salario;
    }
}
