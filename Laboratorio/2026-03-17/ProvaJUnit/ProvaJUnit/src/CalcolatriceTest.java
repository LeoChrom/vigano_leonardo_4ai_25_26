import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalcolatriceTest {

    @Test
    @DisplayName("test della somma: 2 + 3 fa 5")
    void testSomma() {
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.somma(2, 3);
        assertEquals(5, risultato, "la somma di 2 e 3 dovrebbe essere 5");
    }

    @Test
    @DisplayName("test sottrazione: 2 - 3 = -1")
    void testSottrazione() {
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.sottrazione(2, 3);
        assertEquals(-1, risultato, "la sottrazione di 2 e 3 dovrebbe essere -1");
    }

    @Test
    @DisplayName("test moltiplicazione: 4 * 3 = 12")
    void testMoltiplicazione() {
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.moltiplicazione(4, 3);
        assertEquals(12, risultato);
    }

    @Test
    @DisplayName("divisione: 10 / 2 = 5.0")
    void testDivisione() {
        Calcolatrice calc = new Calcolatrice();
        double risultato = calc.divisione(10, 2);
        assertEquals(5.0, risultato);
    }

    @Test
    @DisplayName("divisione per zero: deve lanciare ArithmeticException")
    void testDivisionePerZero() {
        Calcolatrice calc = new Calcolatrice();

        // si verifica il lancio di eccezione
        assertThrows(ArithmeticException.class, () -> calc.divisione(10, 0));
    }
}