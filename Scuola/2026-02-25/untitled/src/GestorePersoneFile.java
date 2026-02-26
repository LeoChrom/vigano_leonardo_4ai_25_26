import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorePersoneFile implements Serializable {

    public final static String NOME_FILE = "persone.txt";
    public final static String SEPARATORE =";";

    public static void salvaPersone(List<Persona> personeDaSalvare) throws IOException {

        //creo il buffer writer
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(NOME_FILE));
        String personaTesto = "";

        //scorro le persone da salvare
        for (Persona p : personeDaSalvare) {
            //creo una stringa da salvare su file per ogni persona
            //controllo se ho un bambino oppure una persona
            if (p instanceof Bambino) {
                Bambino b = (Bambino) p;
                personaTesto = p.getClass().getName() + SEPARATORE + b.getNome() + SEPARATORE + b.getCognome() + SEPARATORE + b.getEta() + SEPARATORE + b.getNascita();

            }else if (p instanceof Persona){
                personaTesto = p.getClass().getName() + SEPARATORE + p.getNome() + SEPARATORE + p.getCognome() + SEPARATORE + p.getEta();
            }

            //scrivo su file
            bufferWriter.write(personaTesto);

            //metto un a capo su file
            bufferWriter.newLine();
        }
        bufferWriter.close();
    }

    public static List<Persona> caricaPersone() throws IOException {
        //creo il BufferReader
        BufferedReader br = new BufferedReader(new FileReader(NOME_FILE));
        //creo la lista delle persone
        List<Persona> personeDaCaricare = new ArrayList<>();
        //creo la variabile per salvare la stringa completa
        String stringaCompleta = "";
        //finche la riga ha qualcosa dentro
        while ((stringaCompleta = br.readLine()) != null) {
            //splitta la stringa
            String[] dati = stringaCompleta.split(SEPARATORE);
            //salvo il nome, cognome, eta
            String nome = dati[1];
            String cognome = dati[2];
            System.out.println("AAA " + Arrays.toString(dati));
            int eta = Integer.parseInt(dati[3]);
            if (dati[0].equals("Persona")){
                //carico tutto sulla lista che devo ritornare
                personeDaCaricare.add(new Persona(nome, cognome, eta));
            } else if (dati[0].equals("Bambino")) {
                LocalDate nascita = LocalDate.parse(dati[4]);
                personeDaCaricare.add(new Bambino(nome, cognome, eta, nascita));
            }
        }
        //chiudo il BufferReader e faccio la return
        br.close();
        return personeDaCaricare;
    }



/*
    public static List<Persona> caricaPersone() throws IOException{
        List<Persona> lista= new ArrayList<>();
        //creo un buffer reader
        BufferedReader br = new BufferedReader(new FileReader(NOME_FILE));
        List<String> righe;
        righe = br.readAllLines();
        for (String riga:righe){
            //leggo il file fino all'ultima riga

            //per ogni riga eseguo la split sul carattere "|"
            String nome =riga.split(SEPARATORE)[0] ;
            String cognome = riga.split(SEPARATORE)[1];
            int eta = Integer.parseInt(riga.split(SEPARATORE)[2]);
            //prendo le 3 informazioni, e creo una Persona
            Persona p = new Persona(nome,cognome,eta);
            lista.add(p);

        }
        br.close();
        return lista;
        //chiudo il buffer reader
    }
 */

}
