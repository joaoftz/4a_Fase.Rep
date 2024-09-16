import com.example.GeometriaService;

import org.junit.jupiter.api.Test;



public class GeometriaServiceTest {
    GeometriaService geometriaService = new GeometriaService();
    
    // public void DeveCalcularAreaTrianguloComSucessoTest(){
    //     double resultado = geometriaService.CalcularAreaTriangulo(2.0, 2.0);
    //     assertEquals
    // }
    
    
    // public void DeveCalcularAreaQuadradoComSucessoTest(){

    //     double resultado = geometriaService.CalcularAreaQuadrado(2);
      
    // }

    // public void DeveCalcularVolumeEsfera(){
    //     double resultado = geometriaService.CalcularVolumeEsfera(2.0);
    //     assertEquals
    // }

    @Test
    public void DeveCalcularAreaRetanguloComSucessoTest(){
        double resultado = geometriaService.CalcularAreaRetangulo(2, 3);
        assertEquals(6, resultado);
    }
}
