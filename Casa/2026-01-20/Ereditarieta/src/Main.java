import Figure.Cerchio;
import Figure.FiguraGeometrica;
import Figure.Quadrato;
import Figure.Rettangolo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Quadrato quadrato = new Quadrato(10);
    Cerchio c = new Cerchio(5);
    Rettangolo r = new Rettangolo(3, 7);


    System.out.println("Il perimetro del rettangolo è: " + r.perimetro());
    System.out.println("L'erea del rettangolo è: " + r.area());

    //System.out.println("Il perimetro del triangolo è: " + triangolo.perimetro());
}
