public class Casa {
    private String nome;
    private boolean fibraOttica;
    private int numStanze;
    private double metriQuadrati;

    public Casa(){
        nome="";
        fibraOttica=false;
        numStanze=0;
        metriQuadrati=0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFibraOttica() {
        return fibraOttica;
    }

    public void setFibraOttica(boolean fibraOttica) {
        this.fibraOttica = fibraOttica;
    }

    public int getNumStanze() {
        return numStanze;
    }

    public void setNumStanze(int numStanze) {
        this.numStanze = numStanze;
    }

    public double getMetriQuadrati() {
        return metriQuadrati;
    }

    public void setMetriQuadrati(double metriQuadrati) {
        this.metriQuadrati = metriQuadrati;
    }
}
