//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Pedina t = new Torre();
    t.muovi();
    //t.arrocco() non va!!

    Pedina pt = new Cavallo();
    if (pt instanceof Torre){
        //devo usare il casting comunque perche l'oggetto e Pedina anche se instance of Torre
        ((Torre)pt).arrocco();
    }
}
