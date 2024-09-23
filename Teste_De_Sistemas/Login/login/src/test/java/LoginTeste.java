import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.Login;

public class LoginTeste {
   @Test
    public void testeLogin(){
        Login login = new Login();
        assertTrue(login.logar("email@gmail.com", "senha123"));
        
    }
    @Test
    public void testeEmailInvalido(){
        Login login = new Login();
        assertTrue(login.logarEmailInvalido("teste@gmail.com", "senha123"));
    }
    @Test
    public void testeSenhaInvalida(){
        Login login = new Login();
        assertTrue(login.logarSenhaInvalida("email@gmail.com", "invalida"));
    }    
}
