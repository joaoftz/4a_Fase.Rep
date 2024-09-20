import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.GeometriaService;

public class GeometriaServiceTest {
    
    @Test
    public void DeveCalcularAreaTrianguloComSucessoTest(){
        GeometriaService geometriaService = new GeometriaService();

        double resultado = geometriaService.CalcularAreaTriangulo(2, 2);
        assertEquals(2, resultado);
    }

    @Test
    public void DeveCalcularAreaQuadradoComSucessoTest(){
        GeometriaService geometriaService = new GeometriaService();

        double resultado = geometriaService.CalcularAreaQuadrado(2);
        assertEquals(4, resultado);
    }

    @Test
    public void DeveCalcularVolumeEsferaComSucessoTest(){  
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularVolumeEsfera(2.0);
        assertEquals(33.5, resultado, 0.1);
    }

    @Test
    public void DeveCalcularAreaRetanguloComSucessoTest(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaRetangulo(2, 3);
        assertEquals(6, resultado);
    }

    @Test
    public void DeveCalcularAreaCirculoComSucessoTest(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaCirculo(2);
        assertEquals(12.5, resultado, 0.1);
    }

    @Test
    public void deveCalcularVolumeCilindroComSucessoTest(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularVolumeCilindro(2, 2);
        assertEquals(25.1, resultado, 0.1);
    }
}