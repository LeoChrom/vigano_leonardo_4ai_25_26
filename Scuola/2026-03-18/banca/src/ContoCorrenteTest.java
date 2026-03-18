import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


public class ContoCorrenteTest {
    //@DisplayName()
    @Test
    void test01(){
        ContoCorrente c;
    }

    @Test
    void testEccezione(){
        ContoCorrente c1,c2;
        assertThrows(Exception.class, ()-> {
           ContoCorrente c = new ContoCorrente("a");
        });

    }


}
