public class DataEstesa extends DataFormattata {

    private static final String[] MESI = {
            "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno",
            "luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre"
    };

    public DataEstesa(int giorno, int mese, int anno) {
        super(giorno, mese, anno);
    }

    private int anno4() {
        if (anno >= 0 && anno < 100) {
            return 2000 + anno;
        } else {
            return anno;
        }
    }

    @Override
    public String stringaFormattata() {
        String nomeMese = MESI[mese - 1];
        return String.format("%02d %s %04d", giorno, nomeMese, anno4());
    }
}