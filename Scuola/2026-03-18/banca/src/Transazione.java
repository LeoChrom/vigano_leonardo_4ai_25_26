import java.time.LocalDate;

public class Transazione {
    private String mittente, beneficiario;
    private LocalDate data;
    private double importo;
    private String causale;

    public Transazione(String mittente, String beneficiario, LocalDate data, double importo, String causale) {
        setMittente(mittente);
        setBeneficiario(beneficiario);
        setData(data);
        setImporto(importo);
        setCausale(causale);
    }

    public void setMittente(String mittente) {
        if (mittente == null || mittente.isEmpty()) {
            throw new IllegalArgumentException("! - Il mittente non può essere vuoto.");
        }
        this.mittente = mittente;
    }

    public void setBeneficiario(String beneficiario) {
        if (beneficiario == null || beneficiario.isEmpty()) {
            throw new IllegalArgumentException("! - beneficiario vuoto");
        }
        this.beneficiario = beneficiario;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("! - La data non può essere nulla");
        }
        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("! - La data non può essere futura");
        }
        this.data = data;
    }

    public void setImporto(double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("! - L'importo deve essere maggiore di zero");
        }
        this.importo = importo;
    }

    public void setCausale(String causale) {
        if (causale == null || causale.isBlank()) {
            throw new IllegalArgumentException("! - la causale non può essere vuota");
        }
        this.causale = causale;
    }
}