import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String acq_nome() throws IOException {
        System.out.print("Nome oggetto: ");
        String ogg= reader.readLine();
        return ogg;
    }

    public static void aggiungi(List<String> oggetti) throws IOException {
        String nome = acq_nome();
        oggetti.add(nome);

    }

    public static void elimina(List<String> oggetti) throws IOException {
        visualizza(oggetti);
        System.out.print("Seleziona oggetto: ");
        String ogg=reader.readLine();
        int numogg;
        try{
            numogg = Integer.parseInt(ogg);
        }
        catch (Exception e){
            System.err.println("Inserisci un numero!!");
            return;
        }
        numogg -= 1;
        oggetti.remove(numogg);


    }

    public static void visualizza(List<String> oggetti){
        for (int i = 0; i < oggetti.size(); i++) {
            System.out.println((i+1)+ " - " + oggetti.get(i));
        }
        System.out.println();
    }

    public static void modifica(List<String> oggetti) throws IOException {
        visualizza(oggetti);
        System.out.print("Seleziona oggetto: ");
        String ogg=reader.readLine();
        int numogg;
        try{
            numogg = Integer.parseInt(ogg);
        }
        catch (Exception e){
            System.err.println("Inserisci un numero!!");
            return;
        }
        numogg -= 1;
        oggetti.set(numogg, acq_nome());
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        List<String> oggetti = new ArrayList<>();

        System.out.println("--- Metti nello zaino ---");

        int continua = 1;
        while (continua==1){

            System.out.println("1. Aggiungi oggetto \n2. Rimuovi oggetto \n3. Visualizza oggetti \n4. Modifica \n0. Esci");
            System.out.print("Seleziona un'opzione: ");

            int err =0;

            String sel = reader.readLine();

            int selnum = 0;
            try{
                selnum = Integer.parseInt(sel);
            }
            catch (Exception e){
                err=1;
                System.err.println("Inserisci un numero!!");
            }

            System.out.println();

            if (err==0){
                switch (selnum){
                    case 0:
                        continua=0;
                        break;
                    case 1:
                        aggiungi(oggetti);
                        break;
                    case 2:
                        elimina(oggetti);
                        break;
                    case 3:
                        visualizza(oggetti);
                        break;
                    case 4:
                        modifica(oggetti);
                        break;
                    default:
                        System.out.println("Opzione non valida!");
                }
            } else {
                err=0;
            }

        }

    }
}