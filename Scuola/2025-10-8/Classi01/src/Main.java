void main(){
    Mostro m1 = new Mostro();

    m1.cambiaNome("Wario");

    IO.println("Il mostro è " + m1.mostraNome() + " power: " + m1.mostraEnergia());

    Player p1= new Player();
    p1.setNome("fefgd");
    p1.setId("Dragon58");
    Player p2 = new Player();
    p2.setNome("fefgd");
    p2.setId("Dragon5");

    System.out.println("il giocatore 1 si chiama " + p2.getNome());

    //IO.println(p1);
    // System.out.println(p2);
}

