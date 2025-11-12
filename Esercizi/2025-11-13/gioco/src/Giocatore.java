public class Giocatore {
    private String nome;
    private boolean capitano;
    private int goal;
    private int goalNazionale;

    public Giocatore(){
        nome="nome";
        capitano=false;
        goal=0;
        goalNazionale=0;
    }

    public Giocatore(String nome, boolean capitano, int goal, int goalNazionale) {
        this.nome = nome;
        this.capitano = capitano;
        this.goal = goal;
        this.goalNazionale = goalNazionale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getCapitano() {
        return capitano;
    }

    public void setCapitano(boolean capitano) {
        this.capitano = capitano;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getGoalNazionale() {
        return goalNazionale;
    }

    public void setGoalNazionale(int goalNazionale) {
        this.goalNazionale = goalNazionale;
    }

    public int calcolaGoalTotali(){
        return goal+goalNazionale;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", capitano=" + capitano +
                ", goal=" + goal +
                ", goalNazionale=" + goalNazionale +
                '}';
    }
}
