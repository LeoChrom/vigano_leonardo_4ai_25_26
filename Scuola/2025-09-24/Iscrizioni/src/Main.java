import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));


    public static void visualizza(String[] archivio, int quanti){
        System.out.println("---- Archivio iscritti ----" + (quanti+1) + " iscritti ------ ");
        if (quanti==0){
            System.out.println("Non ci sono iscritti!");
        }
        else {
            for (int i = 0; i <=quanti; i++) {
                System.out.println(i + " - " + archivio[i]);
            }
        }
        System.out.println();
    }

    public static int inserisci (String[] archivio, int quanti) throws IOException{
        if (quanti==archivio.length){
            System.out.println("Archivio pieno!! -🤘");
        }
        else {
            System.out.print("Nome iscritto: ");
            String nome = reader.readLine();
            archivio[quanti]=nome;
            quanti++;
        }
        return quanti;

    }

    public static int elimina (String[] archivio, int quanti) throws IOException{
        visualizza(archivio,quanti);
        System.out.print("id iscritto da cancellare: ");
        String ogg = reader.readLine();
        int id;
        try {
            id = Integer.parseInt(ogg);
        }
        catch (Exception e){
            System.out.println("Inserisci un numero!!!");
            System.out.println();
            return quanti;
        }

        if (id>quanti || id<0){
            System.out.println("Selezione non valida!!");
        }
        else {
            archivio[id] = archivio[quanti];
            quanti--;
            return quanti;
        }

        return quanti;
    }

    public static void modifica (String[]archivio, int quanti) throws IOException {
        visualizza(archivio,quanti);
        System.out.print("id iscritto da modificare: ");
        String ogg = reader.readLine();
        int id;
        try {
            id = Integer.parseInt(ogg);
        }
        catch (Exception e){
            System.out.println("Inserisci un numero!!!");
            System.out.println();
            return;

        }

        if (id>quanti || id<0){
            System.out.println("Selezione non valida!!");
        }
        else {
            System.out.print("Nuovo nome dell'iscritto: ");
            String nome = reader.readLine();
            archivio[id] = nome;

        }

    }

    public static void main(String[] args) throws IOException {
        String[] iscritti = new String[10];

        //dati temporanei
        iscritti[0] = "ferrari";
        iscritti[1] = "tornatola";
        iscritti[2] = "silvestri";
        iscritti[3] = "luigi";


        int quanti;


        quanti = 3;
        String scelta;
        do {
            System.out.println("Menu; Cosa vuoi fare?");
            System.out.println("1. Iscrivi \n2. Visualizza tutto  \n3. Cancella iscrizione \n4. Modifica dato \nq. Esci");
            System.out.print("Seleziona: ");
            scelta = reader.readLine();

            switch (scelta) {
                case "1":
                    quanti = inserisci(iscritti, quanti);
                    break;
                case "2":
                    visualizza(iscritti, quanti);
                    break;
                case "3":
                    quanti=elimina(iscritti,quanti);
                    break;
                case "4":
                    modifica(iscritti,quanti);
                    break;
                case "q":
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Selezione non valida");


            }
        } while (scelta.equals("q") == false);


    }
}