void main() {
    Penna penna = new Penna();
    penna.setMarca("Inkmate");
    penna.setCancellabile(false);
    penna.setQtaInk(2.5);
    penna.setColore("Verde");
    System.out.println("Informazioni penna:" +
            "\nMarca: " + penna.getMarca() +
            "\nCancellabile: " + penna.isCancellabile() +
            "\nQuantità Inchiostro: " + penna.getQtaInk() +
            "\nColore: " + penna.getColore()
    );
    System.out.println();

    Penna penna2 = new Penna();
    penna2.setMarca(IO.readln("Marca penna: "));
    penna2.setCancellabile(Boolean.parseBoolean(IO.readln("Cancellabile (true/false)? ")));
    penna2.setQtaInk(Double.parseDouble(IO.readln("Inchiostro: ")));
    penna2.setColore(IO.readln("Colore: "));
    System.out.println("Informazioni penna:" +
            "\nMarca: " + penna2.getMarca() +
            "\nCancellabile: " + penna2.isCancellabile() +
            "\nQuantità Inchiostro: " + penna2.getQtaInk() +
            "\nColore: " + penna2.getColore()
    );
}