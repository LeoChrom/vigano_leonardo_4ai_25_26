void main() {
    Casa casa = new Casa();
    casa.setNome("Casa di Leonardo");
    casa.setFibraOttica(true);
    casa.setMetriQuadrati(500.5);
    casa.setNumStanze(18);
    System.out.println("Informazioni casa:" +
            "\nNome: " + casa.getNome() +
            "\nFibra ottica presente: " + casa.isFibraOttica() +
            "\nNumero stanze: " + casa.getNumStanze() +
            "\nMetri quadrati: " + casa.getMetriQuadrati()
    );

    System.out.println();

    Casa casa2 = new Casa();
    casa2.setNome(IO.readln("Nome casa: "));
    casa2.setFibraOttica(Boolean.parseBoolean(IO.readln("Fibra ottica (true/false)? ")));
    casa2.setMetriQuadrati(Double.parseDouble(IO.readln("Metri quadrati: ")));
    casa2.setNumStanze(Integer.parseInt(IO.readln("Numero di stanze: ")));
    System.out.println("Informazioni casa:" +
            "\nNome: " + casa2.getNome() +
            "\nFibra ottica presente: " + casa2.isFibraOttica() +
            "\nNumero stanze: " + casa2.getNumStanze() +
            "\nMetri quadrati: " + casa2.getMetriQuadrati()
    );

}
