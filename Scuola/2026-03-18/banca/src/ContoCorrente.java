import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContoCorrente {
    private String intestatario;
    private double saldo;
    private String numeroConto; // ID
    private String pin;
    private LocalDate apertura;
    private List<Transazione> movimenti;

    public ContoCorrente(String intestatario) {
        setIntestatario(intestatario);
        this.saldo = 0.0;
        this.numeroConto = generaNumeroConto();
        this.pin = generaPIN();
        this.apertura = LocalDate.now();
        this.movimenti = new ArrayList<>();
    }

    public void setIntestatario(String in) {
        if (in == null || in.length() < 2)
            throw new IllegalArgumentException("! - Min 2 caratteri per intestatario");
        intestatario = in;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Bonifico in uscita
     */
    public void bonifico(String dest, double importo, String causale) {
        if (dest == null || dest.isBlank())
            throw new IllegalArgumentException("Destinatario non valido");
        if (importo <= 0)
            throw new IllegalArgumentException("Importo non valido");
        if (importo > saldo)
            throw new IllegalArgumentException("Saldo insufficiente");

        // aggiorna saldo
        saldo -= importo;

        // registra movimento
        movimenti.add(new Transazione(intestatario, dest, LocalDate.now(), importo, causale));
    }

    // --- Metodi interni fittizi per numeroconto e pin ---
    private String generaNumeroConto() {
        return "IT" + (int)(Math.random() * 1_000_000_000);
    }

    private String generaPIN() {
        int pinNum = (int)(Math.random() * 9000 + 1000);
        return String.valueOf(pinNum);
    }
}