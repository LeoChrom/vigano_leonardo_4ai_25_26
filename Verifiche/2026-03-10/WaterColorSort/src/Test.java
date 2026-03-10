/**
 * Classe di verifica del funzionamento del gioco.
 */
public class Test {
    Tavolo tavolo;
    boolean exc;

    /**
     * Comunica il punteggio ottenuto e l'attività controllata.
     * 
     * @param step  Indica il numero progessivo del controllo effettuato.
     * @param msg   Messaggio per l'utente.
     */
    private void ok(int step, String msg) {
        System.out.println("STEP" + step + " OK - " + msg + "\n---------------------------\n");
    }

    /**
     * Step1: verifica creazione Tavolo e stato iniziale.
     */
    public void step1() {
        exc = false;
        // Eccezione per numProvette <= 0
        try {
            tavolo = new Tavolo(0, 4);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException("STEP1 ERRORE - Il costruttore deve gestire numProvette <= 0");

        exc = false;
        // Eccezione per capacitaProvette <= 0
        try {
            tavolo = new Tavolo(5, 0);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException("STEP1 ERRORE - Il costruttore deve gestire capacitaProvette <= 0");

        tavolo = new Tavolo(3, 4);

        if (!tavolo.isFinito()) {
            throw new RuntimeException(
                    "STEP1 ERRORE - Un tavolo appena creato dovrebbe risultare finito perche' tutte le provette sono vuote");
        }

        System.out.println(tavolo);
        ok(1, "Creazione Tavolo e stato iniziale");
    }

    /**
     * Step2: verifica riempimento delle provette.
     */
    public void step2() {
        tavolo = new Tavolo(3, 4);
        tavolo.riempi(0, 2, Colore.ROSSO);
        tavolo.riempi(0, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.ROSSO);

        exc = false;
        // Eccezione per posizione provetta errata
        try {
            tavolo.riempi(5, 2, Colore.GIALLO);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException("STEP2 ERRORE - Deve essere gestita una posizione provetta non valida");

        exc = false;
        // Eccezione per quantità colore eccessiva
        try {
            tavolo.riempi(2, 50, Colore.GIALLO);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException(
                    "STEP2 ERRORE - Deve essere gestita una quantità di colore superiore alla capacità");

        System.out.println(tavolo);

        if (tavolo.isFinito()) {
            throw new RuntimeException("STEP2 ERRORE - Dopo il riempimento il gioco non deve risultare finito");
        }

        ok(2, "Riempimento delle provette");
    }

    /**
     * Step3: verifica travaso corretto e controllo finale di isFinito.
     */
    public void step3() {
        tavolo = new Tavolo(3, 4);
        tavolo.riempi(0, 2, Colore.ROSSO);
        tavolo.riempi(0, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.ROSSO);

        System.out.println(tavolo);

        exc = false;
        // Eccezione posizione sorgente errata
        try {
            tavolo.travasa(5, 1);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException("STEP3 ERRORE - Deve essere gestita una posizione sorgente non valida");

        exc = false;
        // Eccezione posizione destinazione errata
        try {
            tavolo.travasa(1, 5);
        } catch (Exception e) {
            exc = true;
        }
        if (!exc)
            throw new RuntimeException("STEP3 ERRORE - Deve essere gestita una posizione destinazione non valida");

        // TEST LOGICA DI GIOCO
        tavolo.travasa(0, 2);
        if (tavolo.isFinito()) {
            throw new RuntimeException("STEP3 ERRORE - Dopo il primo travaso il gioco non deve ancora essere finito");
        }

        tavolo.travasa(1, 0);
        if (tavolo.isFinito()) {
            throw new RuntimeException("STEP3 ERRORE - Dopo il secondo travaso il gioco non deve ancora essere finito");
        }

        tavolo.travasa(1, 2);
        if (!tavolo.isFinito()) {
            throw new RuntimeException("STEP3 ERRORE - Dopo i travasi corretti il gioco dovrebbe risultare finito");
        }
        if (tavolo.isFinito())
            System.out.println("STEP3 - Gioco Completato");
        ok(3, "Travaso corretto e controllo finale di isFinito");
    }

    /**
     * Step4: Verifica travaso da provetta vuota.
     */
    public void step4() {
        tavolo = new Tavolo(4, 4);
        tavolo.riempi(0, 2, Colore.ROSSO);
        tavolo.riempi(0, 2, Colore.GIALLO);
        tavolo.riempi(1, 1, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.ROSSO);
        tavolo.riempi(3, 1, Colore.GIALLO);

        // Eccezione travaso da provetta vuota
        if (tavolo.travasa(2, 1) != 0) {
            throw new RuntimeException("STEP4 ERRORE - Il travaso da una provetta vuota deve restituire 0");
        }

        // Primo Travaso da 0 a 3 (provetta con 1 Giallo, dopo avrà 3)
        if (tavolo.travasa(0, 3) != 2) {
            throw new RuntimeException("STEP4 ERRORE - Il primo travaso valido deve versare 2 unita'");
        }
        if (tavolo.isFinito()) {
            throw new RuntimeException(
                    "STEP4 ERRORE - Dopo il primo travaso valido il gioco non deve ancora essere finito");
        }
        // Secondo Travaso da 1 a 0 (Completo la provetta 0 con tutto ROSSO)
        if (tavolo.travasa(1, 0) != 2) {
            throw new RuntimeException("STEP4 ERRORE - Il secondo travaso valido deve versare 2 unita'");
        }
        if (tavolo.isFinito()) {
            throw new RuntimeException(
                    "STEP4 ERRORE - Dopo il secondo travaso valido il gioco non deve ancora essere finito");
        }
        // Terzo Travaso da 1 a 3 (Completo la provetta 3 con tutto GIALLO)
        if (tavolo.travasa(1, 3) != 1) {
            throw new RuntimeException("STEP4 ERRORE - Il terzo travaso valido deve versare 2 unita'");
        }
        if (!tavolo.isFinito()) {
            throw new RuntimeException("STEP4 ERRORE - La sequenza corretta di travasi deve completare il gioco");
        }

        System.out.println("STEP4 - Gioco Completato");
        ok(4, "Gestione travaso da provetta vuota");
    }

    /**
     * Step5: Verifica travaso su provetta piena.
     */
    public void step5() {
        tavolo = new Tavolo(3, 4);
        tavolo.riempi(0, 2, Colore.ROSSO);
        tavolo.riempi(0, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.GIALLO);
        tavolo.riempi(1, 2, Colore.ROSSO);

        // Eccezione Travaso in una provetta già piena
        if (tavolo.travasa(0, 1) != 0) {
            throw new RuntimeException("STEP5 ERRORE - Il travaso in una provetta piena deve restituire 0");
        }

        // La sequenza corretta deve continuare a funzionare
        // Primo Travaso da 0 a 2 (provetta vuota)
        if (tavolo.travasa(0, 2) != 2) {
            throw new RuntimeException("STEP5 ERRORE - Il primo travaso valido deve versare 2 unita'");
        }
        if (tavolo.isFinito()) {
            throw new RuntimeException(
                    "STEP5 ERRORE - Dopo il primo travaso valido il gioco non deve ancora essere finito");
        }
        // Secondo Travaso da 1 a 0 (Completo la provetta 0 con tutto ROSSO)
        if (tavolo.travasa(1, 0) != 2) {
            throw new RuntimeException("STEP5 ERRORE - Dopo il secondo travaso valido devono essere versate 2 unita'");
        }
        if (tavolo.isFinito()) {
            throw new RuntimeException(
                    "STEP5 ERRORE - Dopo il secondo travaso valido il gioco non deve ancora essere finito");
        }
        // Terzo Travaso da 1 a 2 (Completo la provetta 2 con tutto GIALLO)
        if (tavolo.travasa(1, 2) != 2) {
            throw new RuntimeException("STEP5 ERRORE - Dopo il terzo travaso valido devono essere versate 2 unita'");
        }
        if (!tavolo.isFinito()) {
            throw new RuntimeException("STEP5 ERRORE - La sequenza corretta di travasi deve completare il gioco");
        }

        if (tavolo.isFinito()) {
            System.out.println("STEP5: Gioco Completato");
        }
        ok(5, "Gestione travaso su provetta piena");
    }

    /**
     * Step6: ProvettaSpecial capovolgi.
     */
    public void step6() {
        tavolo = new Tavolo(3, 1, 4);
        tavolo.riempi(3, 1, Colore.ROSSO);
        tavolo.riempi(3, 1, Colore.GIALLO);
        tavolo.riempi(3, 1, Colore.BLU);
        tavolo.riempi(3, 1, Colore.VERDE);

        Provetta p = tavolo.getProvetta(3);
        // Eccezione su provetta non Special
        if (!(p instanceof ProvettaSpecial)) {
            throw new RuntimeException("STEP6 ERRORE - La provetta in posizione 3 non è una ProvettaSpecial");
        }

        ProvettaSpecial ps = (ProvettaSpecial) p;
        System.out.println(ps);
        ps.capovolgi();
        // Eccezione su inversione colori errata
        System.out.println(ps);
        if (ps.rimuovi() != Colore.ROSSO) {
            throw new RuntimeException("STEP6 ERRORE - Primo colore errato dopo capovolgi()");
        }
        if (ps.rimuovi() != Colore.GIALLO) {
            throw new RuntimeException("STEP6 ERRORE - Secondo colore errato dopo capovolgi()");
        }
        if (ps.rimuovi() != Colore.BLU) {
            throw new RuntimeException("STEP6 ERRORE - Terzo colore errato dopo capovolgi()");
        }
        if (ps.rimuovi() != Colore.VERDE) {
            throw new RuntimeException("STEP6 ERRORE - Quarto colore errato dopo capovolgi()");
        }

        ok(6, "Implementazione ProvettaSpecial e capovolgi");
    }
}
