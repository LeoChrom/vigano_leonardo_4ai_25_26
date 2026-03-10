import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

public class Main {
    /**
     * Avvio del programma
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String scelta = "";

        do {
            System.out.println("+=========================================================+");
            System.out.println("| __        __    _               ____      _             |");
            System.out.println("| \\ \\      / /_ _| |_ ___ _ __   / ___|___ | | ___  _ __  |");
            System.out.println("|  \\ \\ /\\ / / _` | __/ _ \\ '__| | |   / _ \\| |/ _ \\| '__| |");
            System.out.println("|   \\ V  V / (_| | ||  __/ |    | |__| (_) | | (_) | |    |");
            System.out.println("|    \\_/\\_/ \\__,_|\\__\\___|_|     \\____\\___/|_|\\___/|_|    |");
            System.out.println("+=========================================================+");
            System.out.println("|  g - Gioca");
            System.out.println("|  t - Esegui i test");
            System.out.println("|  x - Esci dal gioco");
            System.out.print("Cosa vuoi fare? ");
            scelta = in.nextLine();

            switch (scelta.toLowerCase()) {
                case "g": gioca(); break;
                case "t": eseguiTest(); break;
                case "x": break;
                default: System.out.println("Scelta inesistente.");
            }
        } while (scelta.compareToIgnoreCase("x") != 0);
    }

    /**
     * Crea un tavolo di livello base e permette all'utente di giocare.
     */
    public static void gioca() {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        ArrayList<Colore> tavolozza = new ArrayList<Colore>(EnumSet.allOf(Colore.class));
        ArrayList<Colore> gocce = new ArrayList<Colore>();

        int nProvette = r.nextInt(2, 6);
        int cProvetta = r.nextInt(3, 6);
        for(int i = 1; i < nProvette; i++){
            Colore col = tavolozza.remove(r.nextInt(0, tavolozza.size()));
            for(int c = 0; c < cProvetta; c++)
                gocce.add(col);
        }
        Collections.shuffle(gocce);

        Tavolo t = new Tavolo(nProvette, cProvetta);
        for(int i = 0; i < gocce.size(); i++){
            t.riempi(i % nProvette, 1, gocce.get(i));
        }

        int src, des;
        int mosse = 0;
        while(!t.isFinito()){
            System.out.println("Il tavolo è composto da " + nProvette + " provette.");
            System.out.println("Ogni provetta può contenere " + cProvetta + " unità di colore.");
            System.out.println(t);

            System.out.print("Fai la tua mossa (da, a) CTRL+C per interrompere: ");
            try {
                src = in.nextInt();
                des = in.nextInt();
                t.travasa(src, des);
                mosse++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Complimenti hai completato la partita in " + mosse + " mosse.");
    }

    /**
     * Effettua una serie di test di verifica del funzionamento del gioco.
     */
    public static void eseguiTest() {
        try {
            Test test = new Test();
            test.step1();
            test.step2();
            test.step3();
            test.step4();
            test.step5();
            test.step6();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
