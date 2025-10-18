void visualizza(char[][] mtrx, final int RIGHE, final int COLONNE){
    for (int r = 0; r < RIGHE ; r++) {
        for (int c = 0; c < COLONNE; c++) {
            System.out.print(mtrx[r][c]);
            System.out.print(" ");
            System.out.print("|");
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("━ ━ ━ ━ ━ ━");
    }
}

void main() {

    Griglia tris = new Griglia();
    char [][] griglia = tris.getGriglia();
    visualizza(griglia,tris.RIGHE,tris.COLONNE);

    System.out.println();
    System.out.println(tris.getTurno());
    tris.setCella(2,2);
    visualizza(griglia,tris.RIGHE,tris.COLONNE);
    System.out.println(tris.getTurno());

    System.out.println();
    System.out.println(tris.getTurno());
    tris.setCella(1,0);
    visualizza(griglia,tris.RIGHE,tris.COLONNE);
    System.out.println(tris.getTurno());

    System.out.println();
    System.out.println(tris.getTurno());
    tris.setCella(1,1);
    visualizza(griglia,tris.RIGHE,tris.COLONNE);
    System.out.println(tris.getTurno());

    System.out.println();
    System.out.println(tris.getTurno());
    tris.setCella(2,0);
    visualizza(griglia,tris.RIGHE,tris.COLONNE);
    System.out.println(tris.getTurno());

    System.out.println();
    System.out.println(tris.getTurno());
    tris.setCella(2,2);
    visualizza(griglia,tris.RIGHE,tris.COLONNE);
    System.out.println(tris.getTurno());


    System.out.println(tris.chkVincita());


}
