
public class ProvaData {
    public void main() {
        try {
            System.out.print("Quante date vuoi inserire? ");
            int n = 0;
            boolean errore=true;
            while (errore) {
                errore=false;
                try {
                    String s = IO.readln();
                    n = Integer.parseInt(s.trim());
                    if (n <= 0){
                        System.out.print("Inserisci un intero >= 0: ");
                        errore=true;
                    }
                } catch (Exception e) {
                    errore=true;
                    System.out.print("Valore non valido. Riprova: ");
                }
            }

            DataFormattata[] date = new DataFormattata[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Data #" + (i + 1) + " ---");

                String formato = "";
                errore = true;
                while (errore) {
                    errore=false;
                    System.out.print("Formato (N = numerica gg/mm/aaaa, E = estesa gg mese aaaa): ");
                    formato = IO.readln();
                    if (formato != null) formato = formato.trim();
                    if (!("N".equalsIgnoreCase(formato) || "E".equalsIgnoreCase(formato))) {
                        System.out.println("Scelta non valida. Digita N o E.");
                        errore=true;
                    }
                }

                errore=true;
                int g = 0;
                while (errore) {
                    errore=false;
                    try {
                        System.out.print("Giorno (1..31): ");
                        String s = IO.readln();
                        g = Integer.parseInt(s.trim());
                    } catch (Exception e) {
                        errore=true;
                        System.out.println("Valore non valido. Riprova.");
                    }
                }

                errore=true;
                int m = 0;
                while (errore) {
                    errore=false;
                    try {
                        System.out.print("Mese (1..12): ");
                        String s = IO.readln(); // <-- adegua qui se necessario
                        m = Integer.parseInt(s.trim());
                    } catch (Exception e) {
                        errore=true;
                        System.out.println("Valore non valido. Riprova.");
                    }
                }

                errore=true;
                int a = 0;
                while (errore) {
                    errore=false;
                    try {
                        System.out.print("Anno (2 o 4 cifre, es. 12 oppure 2012): ");
                        String s = IO.readln(); // <-- adegua qui se necessario
                        a = Integer.parseInt(s.trim());
                    } catch (Exception e) {
                        errore=true;
                        System.out.println("Valore non valido. Riprova.");
                    }
                }

                if ("N".equalsIgnoreCase(formato)) {
                    date[i] = new DataNumerica(g, m, a);
                } else {
                    date[i] = new DataEstesa(g, m, a);
                }
            }

            System.out.println("\n=== Date inserite ===");
            for (int i = 0; i < n; i++) {
                System.out.println(date[i].stringaFormattata());
            }

        } catch (Exception e) {
            System.out.println("Si è verificato un errore inatteso: " + e.getMessage());
        }
    }
}
