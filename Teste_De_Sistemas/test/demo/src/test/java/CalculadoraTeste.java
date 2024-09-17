import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class CalculadoraTeste {
    @Test
    public void testeSoma(){
        Calculadora calc = new Calculadora();
        Integer result = calc.soma(2,3);
        assertEquals(5, result);

    }

    public void testeMultiplicacao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.multiplicacao(3, 3);
        assertEquals(9, result);
    }

    public void testeSubtracao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.subtracao(5, 2);
        assertEquals(3, result);
    }

    public void testeDivisao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.divisao(10, 2);
        assertEquals(5, result);
    }
}
