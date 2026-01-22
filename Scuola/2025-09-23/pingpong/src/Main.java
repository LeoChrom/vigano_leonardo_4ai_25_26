import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public String [] iscritti = new String[10];
    static private int conta= 0;

    static public void stampa (String[] a, int s){
        System.out.println("******* Iscritti al campionato *******" + conta + "Iscritti");

        if (s==0){
            System.err.println("Non ci sono iscritti in archivio...");

        } else {
            for (int i = 0; i < s; i++) {
                System.out.println(i + " - " + a[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        iscritti[0] = "Ba";
        iscritti[1] = "Viganò";
        iscritti[2] = "Harid";
        conta=3;

        stampa(iscritti, conta);

        System.out.print("Inserisci nuovo iscritto: ");
        String iscritto = reader.readLine();
        if (iscritto==""){
            System.out.println("Nome vuoto");
        }
        else {
            iscritti[conta]=iscritto;
            conta+=1;
        }


    }
}