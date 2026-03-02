import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorePersoneFile implements Serializable {

    public final static String NOME_FILE = "persone.bin";
    public final static String SEPARATORE =";";

    public static void salvaPersone(List<Persona> personeDaSalvare) throws IOException {

        //creo il buffer writer
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(NOME_FILE));
        String personaTesto = "";

        //scorro le persone da salvare
        for (Persona p : personeDaSalvare) {
            //provo a serializzare direttamente gli oggetti
            stream.writeObject(p);
        }
        stream.close();
    }

    public static List<Persona> caricaPersone() throws IOException, ClassNotFoundException {
        //creo il BufferReader
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(NOME_FILE));
        //creo la lista delle persone
        List<Persona> personeDaCaricare = new ArrayList<>();

        boolean end=false;
        while (!end) {
            try {
                personeDaCaricare.add((Persona) stream.readObject());
            }
            catch (EOFException e){
                end=true;
            }
        }
        //chiudo il BufferReader e faccio la return
        stream.close();
        System.out.println("Lista: " + personeDaCaricare.toString());
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
