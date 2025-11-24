void main() {
    Stack<String> pila = new Stack<>();
    pila.push("ciao");
    pila.push("pollo");
    pila.push("mela");
    pila.push("banana");
    pila.push("arancia");
    pila.push("albero");
    pila.push("cioccolato");

    System.out.println(pila);

    pila.pop();
    pila.pop();

    System.out.println(pila);

    System.out.println(pila.peek());
    pila.clear();
    System.out.println(pila);


}
