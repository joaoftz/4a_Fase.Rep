import org.junit.jupiter.api.Test;

import com.example.contaCorrente;

import static org.junit.jupiter.api.Assertions.*;

public class ContaCorrenteTest {

    
    contaCorrente contaMaria = new contaCorrente("Maria", 200);
    contaCorrente contaJose = new  contaCorrente("José", 100);

    @Test
    public void testCriacaoContas() {
        
        assertNotNull(contaMaria);
        assertNotNull(contaJose);
    }

    @Test
    public void testSaldosDiferentes() {
        assertNotEquals(contaMaria.getSaldo(), contaJose.getSaldo());
    }

    @Test
    public void testSaqueMariaIgualSaldoJose() {
        
        boolean saqueRealizado = contaMaria.sacar(100);
        assertTrue(saqueRealizado); 
        assertEquals(contaMaria.getSaldo(), contaJose.getSaldo());
    }

    @Test
    public void testDepositoJose() {
        contaJose.depositar(50);
         assertEquals(contaJose.getSaldo(), contaMaria.getSaldo() +50);
    }

    @Test
    public void testSaqueInvalido() {
        boolean saqueInvalido = contaJose.sacar(200);
        assertFalse(saqueInvalido);  
    }

    @Test
    public void testSaqueValido() {
        
        boolean saqueValido = contaJose.sacar(50);
        assertTrue(saqueValido);  
        assertEquals(50, contaJose.getSaldo());  
    }
}
