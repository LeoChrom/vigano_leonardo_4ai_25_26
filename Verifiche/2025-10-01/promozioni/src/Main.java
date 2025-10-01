import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String acquisici() throws IOException {
        boolean errore = true;
        while (errore){
            errore=false;

            System.out.print("Inserisci codice nel formato AAAAA123: ");
            String dato = reader.readLine();

            dato=dato.trim();
            dato=dato.toUpperCase();

            if (dato.matches("[A-Z]{5}[0-9]{3}")){
                return dato;
            }
            else {
                errore=true;
                System.out.println("! - Formato codice non valido: 5 lettere + 3 cifre");
                System.out.println();

            }
        }

        return "";
    }

    public static void inserisci(List<String> codici) throws IOException {
        String codice = acquisici();
        codici.add(codice);
        System.out.println("Il codice promozionale è stato salvato correttamente");
        System.out.println();

    }

    public static void visualizza(List<String> codici){
        System.out.println("*** Archivio codici ***");
        for (int i = 0; i < codici.size(); i++) {
            System.out.println((i+1) + " - " + codici.get(i));
        }
        if (codici.size()==0){
            System.out.println("! - Non sono presenti codici in archivio");
        }
        System.out.println();

    }

    public static void elimina(List<String> codici) throws IOException {
        boolean errore = true;

        if (codici.size()==0){
            System.out.println("! - Non sono presenti codici in archivio");
            errore=false; //non entra nel ciclo e torna al menu
        }


        while (errore){
            errore=false;
            int ok = 1;

            //ottieni posizione codice da eliminare
            visualizza(codici);
            System.out.println("ID codice da eliminare: ");
            String ogg = reader.readLine();
            int sel = 0;
            try {
                sel=Integer.parseInt(ogg);
            }
            catch (Exception ecc){
                errore=true;
                System.out.println("! - Inserisci il numero associato al codice");
                System.out.println();
                ok=0;
            }

            if (ok==1){

                if (sel<1 || sel>codici.size() ){
                    errore=true;
                    System.out.println("! - ID non valido");
                    System.out.println();
                }
                else {
                    System.out.println("Sarà rimosso il codice " + codici.get(sel-1));
                    codici.remove(sel-1);
                    System.out.println();

                }
            }

        }

    }

    public static boolean verifica(List<String> codici) throws IOException {
        boolean continua=true;
        boolean trovato=false;

        if (codici.size()==0){
            continua=false; //non entra nel ciclo e torna al menu
        }

        if (continua){
            String sel = acquisici();

            //ricerca codice
            for (int i = 0; i < codici.size(); i++) {
                String cod = codici.get(i);

                if (sel.equals(cod)){
                    trovato=true;
                    break;
                }
            }


        }
        return trovato;
    }

    public static void classifica(List<String> codici){
        List<String> conteggio = new ArrayList<>();

        //ordino la lista
        codici.sort(null);
        System.out.println(codici);
        for (int i = 0; i < codici.size(); i++) {

        }
    }


    public static void main(String[] args) throws IOException {
        // i print vuoti sono usati per migliorare l'esperienza utente
        List<String> codici = new ArrayList<String>();

        //menu
        System.out.println("---Gestione codici promozionali---");
        boolean continua =true;
        while (continua){
            System.out.println("1 - Inserisci un nuovo codice \n2 - Visualizza l'archivio dei codici \n3 - Elimina un codice \n4 - Verifica se un codice è presente \n0 - Esci dal programma");
            String sel= reader.readLine();
            System.out.println();

            //opzioni
            switch (sel){
                case "1": inserisci(codici); break;
                case "2": visualizza(codici); break;
                case "3": elimina(codici); break;

                case "4":
                    boolean trovato = verifica(codici);
                    if (trovato){
                        System.out.println("Il codice è in archivio");
                    } else if (codici.size()==0) {
                        System.out.println("! - Non sono presenti codici in archivio");
                    } else {
                        System.out.println("Il codice NON è in archivio");
                    }
                    System.out.println();
                    break;

                case "0": continua=false; break;
                default:
                    System.out.println("! - Selezione non valida");
            }
        }

    }
}