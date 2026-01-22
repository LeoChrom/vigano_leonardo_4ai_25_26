void visualizza(char[][] mtrx, final int RIGHE, final int COLONNE){
    System.out.println("1   2   3   4   5   6   7");
    for (int r = 0; r < RIGHE ; r++) {
        for (int c = 0; c < COLONNE; c++) {
            System.out.print(mtrx[r][c]);
            System.out.print(" ");
            System.out.print("|");
            System.out.print(" ");
        }
        System.out.println();
    }
}

void main() {
    Tabellone oth = new Tabellone();
    visualizza(oth.getGriglia(),oth.RIGHE,oth.COLONNE);
}
