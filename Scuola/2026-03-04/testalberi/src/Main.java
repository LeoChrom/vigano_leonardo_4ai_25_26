//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Albero albero = new Albero(10);

    albero.inserisci(5);
    albero.inserisci(15);
    albero.inserisci(3);
    albero.inserisci(7);
    albero.inserisci(12);
    albero.inserisci(20);

    System.out.println(albero);
    // Albero{ root=10, dimensione=7, altezza=3 }

    System.out.println("In-order:   ");
    for (Integer i : albero.inOrder()) System.out.print(i + " ");
    System.out.println();

    System.out.println("Pre-order:  ");
    for (Integer i : albero.preOrder()) System.out.print(i + " ");
    System.out.println();

    System.out.println("Post-order: "); albero.postOrder();
    for (Integer i : albero.postOrder()) System.out.print(i + " ");
    System.out.println();

    System.out.println("Contiene 7  " + albero.contiene(7));
    System.out.println("Contiene 99 " + albero.contiene(99));


}
