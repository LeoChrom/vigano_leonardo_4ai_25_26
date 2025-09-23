import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static String capitalize(String stringa){
        String nuova_stringa="";
        int up = 0;
        for (int i = 0; i < stringa.length(); i++){

            if (i==0){
                char chrup=Character.toUpperCase(stringa.charAt(i));
                nuova_stringa= nuova_stringa+ chrup;
            } else if (stringa.charAt(i)==' ') {
                up=1;
            } else if (up==1) {
                char chrup=Character.toUpperCase(stringa.charAt(i));
                String temp = " " + chrup;
                nuova_stringa += temp;
                up=0;

            } else {nuova_stringa+=stringa.charAt(i);} // += e segnato come warn ma funziona!!
        }
        return nuova_stringa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Scrivi una parola: ");
        String stringa = reader.readLine();
        String nstr=capitalize(stringa); //nuova stringa
        System.out.println(nstr);
        if (nstr.length()==0){
            System.err.println("Parola vuota...");
        }

    }
}