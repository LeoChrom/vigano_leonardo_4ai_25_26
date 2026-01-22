//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    FiguraGeometrica quadrato = new FiguraGeometrica(4,50);
    System.out.println("perimetro quadrato: "+ quadrato.perimetro());
    FiguraGeometrica triangolo = new FiguraGeometrica(4,50);
    System.out.println("perimetro triangolo: "+ triangolo.perimetro());
}
