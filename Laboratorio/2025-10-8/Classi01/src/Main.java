//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Mostro m1 = new Mostro();

    m1.cambiaNome("Wario");

    IO.println("Il mostro è " + m1.mostraNome() + " power: " + m1.mostraEnergia());
}
