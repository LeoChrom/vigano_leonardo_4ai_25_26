import java.util.ArrayList;

public class Rete {

    private final Router[] routers;
    private final ArrayList<int[]>[] listaAdiacenza;
    private int nRouter;

    public Rete(int maxHost) {
        int i;

        routers = new Router[maxHost];
        listaAdiacenza = new ArrayList[maxHost];
        nRouter = 0;

        //lista collegamenti per ogni router
        i = 0;
        while (i < maxHost) {
            listaAdiacenza[i] = new ArrayList<>();
            i = i + 1;
        }
    }

    public boolean addRouter(Router router) {
        int i;

        if (router == null) {
            return false;
        }

        if (nRouter >= routers.length) {
            return false;
        }

        // evita duplicati hostname / ip
        i = 0;
        while (i < nRouter) {
            if (routers[i].getHostname().equals(router.getHostname())) {
                return false;
            }
            if (routers[i].getIp().equals(router.getIp())) {
                return false;
            }
            i = i + 1;
        }

        routers[nRouter] = router;
        nRouter = nRouter + 1;
        return true;
    }

    /**
     * collega router con costo
     *
     * hostnameA-b router da collegare
     * @param costo peso
     * @return true/false esito operazione
     */
    public boolean collegaRouter(String hostnameA, String hostnameB, int costo) {
        int indiceA;
        int indiceB;

        if (costo <= 0) {
            return false;
        }

        indiceA = findIndice(hostnameA);
        indiceB = findIndice(hostnameB);

        if (indiceA == -1 || indiceB == -1) {
            return false;
        }

        // inserimento lista adiacenza
        addCollegamento(indiceA, indiceB, costo);
        addCollegamento(indiceB, indiceA, costo);

        return true;
    }

    /**
     * ottieni costo percorso
     * @return costo -1 se non collegati o inesistenti
     */
    public int getCosto(String hostnameA, String hostnameB) {
        int indiceA;
        int indiceB;
        ArrayList<int[]> collegamenti;
        int i;

        indiceA = findIndice(hostnameA);
        indiceB = findIndice(hostnameB);

        if (indiceA == -1 || indiceB == -1) {
            return -1;
        }

        if (indiceA == indiceB) {
            return 0;
        }

        collegamenti = listaAdiacenza[indiceA];
        i = 0;
        while (i < collegamenti.size()) {
            if (collegamenti.get(i)[0] == indiceB) {
                return collegamenti.get(i)[1];
            }
            i = i + 1;
        }

        return -1;
    }

    public int getnRouter() {
        return nRouter;
    }

    public Router getRouter(int indice) {
        if (indice < 0 || indice >= nRouter) {
            return null;
        }
        return routers[indice];
    }

    /**
     * trova indice dall'hostname
     * @return -1 se non trovato
     */
    public int findIndice(String hostname) {
        int i;

        if (hostname == null) {
            return -1;
        }

        i = 0;
        while (i < nRouter) {
            if (routers[i].getHostname().equals(hostname)) {
                return i;
            }
            i = i + 1;
        }

        return -1;
    }

    public int[] getIndiciVicini(String hostname) {
        int indiceRouter;
        int i;
        int[] vicini;
        ArrayList<int[]> collegamenti;

        indiceRouter = findIndice(hostname);
        if (indiceRouter == -1) {
            return new int[0];
        }

        collegamenti = listaAdiacenza[indiceRouter];
        vicini = new int[collegamenti.size()];
        i = 0;
        while (i < collegamenti.size()) {
            vicini[i] = collegamenti.get(i)[0];
            i = i + 1;
        }

        return vicini;
    }

    /**
     * inserisce/aggiorna un collegamento in lista di adiacenza
     */
    private void addCollegamento(int indiceSorgente, int indiceDest, int costo) {
        ArrayList<int[]> collegamenti;
        int i;

        collegamenti = listaAdiacenza[indiceSorgente];
        i = 0;
        while (i < collegamenti.size()) {
            if (collegamenti.get(i)[0] == indiceDest) {
                collegamenti.get(i)[1] = costo;
                return;
            }
            i = i + 1;
        }

        collegamenti.add(new int[]{indiceDest, costo});
    }
}
