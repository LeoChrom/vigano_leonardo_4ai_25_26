import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int prezzo = 15;

        System.out.println("Acquista i tuoi biglietti");
        System.out.println("Prezzo: 15 euro per ciascuno");
        Scanner input = new Scanner(System.in);
        int qta = input.nextInt();
        System.out.println("Totale: " + prezzo*qta);
            }
        }
