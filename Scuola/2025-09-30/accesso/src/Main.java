import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String acquisici() throws IOException {
        //Acquisici e verifica targa

        System.out.print("Inserisci targa: ");
        String targa = reader.readLine();

        targa=targa.trim();
        targa=targa.toUpperCase();

        if (targa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")==true){
            return targa;
        }
        else {
            System.out.println("Targa inserita non valida");
        }
        return "";
    }

    public static void inserisci(List<String> targhe) throws IOException {
        String targa = acquisici();
        if (targa!=""){
            targhe.add(targa);
        }
        else return;
    }

    public static void visualizza(List<String> targhe) throws IOException{
        for (int i = 0; i < targhe.size(); i++) {
            System.out.println((i+1)+" - "+targhe.get(i));

        }
    }

    public static void verifica(List<String> targhe){}

    public static void main(String[] args) throws IOException {
        //gestione targhe autorizzate ad entrare
        List<String> targhe = new ArrayList<>();


        boolean continua=true;

        while (continua){
            System.out.println("Gestione targhe");
            System.out.println("1. Aggiungi targa \n2. Visualizza targhe");
            String sel=reader.readLine();
            switch (sel){
                case "1": inserisci(targhe); break;
                case "0": continua=false; break;
            }
        }
    }
}