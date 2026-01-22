//ripassiamo i costrutti

import java.io.BufferedReader;
//import java.io.IO;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void benvenuto(String nome){
        switch (nome) {
            case "Mario": System.out.println("L'eroe di un fantastico gioco");break;
            case "Luigi": System.out.println("Il fratello dell'eroe");break;
            case "Goku": System.out.println("anime jap");break;
            case "Luffy": System.out.println("Il capitano pirata");break;
            default: System.out.println("non ti conosco");break;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //creo un reader
        //creo il buffer per leggere la tastiera (dalla console)


        //System.out.print("Ciao, Come ti chiami ? ");
        //String nome = br.readLine();

        //benvenuto(nome);

        System.out.print("Inserisci un numero intero positivo: ");
        String s = br.readLine(); // e poi lo uso

        try {
            int n = Integer.parseInt(s); //Trasformo stringa in integer

            //SCRIVERE PROMEMORIA: for (<inizializzazione>; <condizione di terminazione>; <incremento>) {
            //  <istruzioni>
            // }

            for(int conta = 0; conta < n  ; conta=conta + 3){
                System.out.println(conta + " X");
            }

            int conta = 0;
            while (conta < n){
                System.out.println("x");
                conta = conta+3;
            }

            // while (<condizione di esecuzione>){
            // <istruzioni> ricorda l'incremento
            // }

            conta=0;
            do{
               System.out.println("@");
               conta = conta +3;
            }
            while (conta < n);
            //LA DIFFERENZA e che do viene eseguito almeno una volta!!


            if (n>0) {
                System.out.println("Il quadrato di " + n + " è " + (n*n));
            }
            else {
                if (n==0) {
                    System.err.println("Furbo !!! il quadrato di 0 è quadrato 🤘");
                }
                else {
                    System.err.println("inserisci un numero POSITIVO!!!");
                }
            }


        } catch (NumberFormatException nfe) {
            System.err.println("Ti ho chiesto un numero intero!!");
        }


        //System.out.println("Hai inserito il numero " + n);


    }
}



/*


*/

        /*
        System.out.print("Inserisci stringa");
        String s = br.readLine();
        System.out.print("Inserisci numero:");
        try {
            int i= Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }

        int somma = 0;
        for (int i = 1; i <=5; i++) {
            System.out.println("i = "+i);
            String s1 = IO.readln("Inserisci il " + i + "* numero:");
            int n= Integer.parseInt(s1);
            somma= somma + n;
        }

        IO.println("Il totale ?: " + somma);

        */
