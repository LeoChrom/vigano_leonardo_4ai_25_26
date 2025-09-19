public class Main {

    public static int faiQcos(){
        String n = "john";
        int num=12;
        System.out.println(n);
        return 5;
    }
    // void e un tipo di dato che indica il vuoto, public static sono indicatori di accesso che posso mescolare
    // Posso mettere int per esempio al posto di void!!
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int numero = -1;
        if (numero>0){
            for (int conta=1; conta < numero; conta++){
                System.out.println(conta);
            }
        }
        else {
            System.out.println("Errore numero");
        }

        faiQcos();

        // non posso dichiarare piu volte la stessa var
        // nel senso che non puo cambiare tipo

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}