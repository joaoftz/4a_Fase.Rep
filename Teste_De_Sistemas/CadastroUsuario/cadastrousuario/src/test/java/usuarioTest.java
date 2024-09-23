import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.ResultadoValidacao;
import com.example.Usuario;

public class usuarioTest {
    
    @Test
    public void DeveCadastrarComSucessoTest(){
        // Given
        Usuario usuarioValido = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioValido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Usuário salvo com sucesso!");
        assertTrue(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoConfirmacaoSenhaNaoConfereTest(){
        // Given
        Usuario usuarioSenhasNaoConferem = new Usuario("joao", "joao@gmail.com", "12345678", "1234510", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioSenhasNaoConferem.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: A senha e a confirmação de senha não correspondem.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoNomeVazioTest(){
        // Given
        Usuario usuarioNomeVazio = new Usuario(null, "joao@gmail.com", "12345678", "12345678", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioNomeVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O nome é obrigatório.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoEmailVazioTest(){
        // Given
        Usuario usuarioEmailVazio = new Usuario("joao", "", "12345678", "12345678", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioEmailVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O e-mail é obrigatório.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoSenhaVazioTest(){
        // Given
        Usuario usuarioSenhaVazio = new Usuario("joao", "joao@gmail.com", "", "", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioSenhaVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: A senha e a confirmação de senha são obrigatórias.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoConfirmacaoSenhaVazioTest(){
        // Given
        Usuario usuarioConfirmacaoSenhaVazio = new Usuario("joao", "joao@gmail.com", "12345678", "", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioConfirmacaoSenhaVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: A senha e a confirmação de senha são obrigatórias.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoCpfOuCnpjVazioTest(){
        // Given
        Usuario usuarioCpfOuCnpjVazio = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioCpfOuCnpjVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O CPF ou CNPJ é obrigatório.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoCepVazioTest(){
        // Given
        Usuario usuarioCepVazio = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "555.555.555-55", "");

        // When
        ResultadoValidacao resultado = usuarioCepVazio.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O CEP é obrigatório.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoEmailInvalidoTest(){
        // Given
        Usuario usuarioEmailInvalido = new Usuario("joao", "joca@teste", "12345678", "12345678", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioEmailInvalido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O e-mail fornecido é inválido.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoSenhaNaoPossuiCaractereMinimoTest(){
        // Given
        Usuario usuarioSenhaInvalido = new Usuario("joao", "joao@gmail.com", "12345", "12345", "555.555.555-55", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioSenhaInvalido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: A senha deve ter no mínimo 8 caracteres.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoCpfInvalidoTest(){
        // Given
        Usuario usuarioCpfInvalido = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "000.555.000", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioCpfInvalido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O CPF ou CNPJ fornecido é inválido.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoCnpjInvalidoTest(){
        // Given
        Usuario usuarioCnpjInvalido = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "AB.CDE.FGH/0001", "55555-555");

        // When
        ResultadoValidacao resultado = usuarioCnpjInvalido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O CPF ou CNPJ fornecido é inválido.");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarErroQuandoCepnvalidoTest(){
        // Given
        Usuario usuarioCepInvalido = new Usuario("joao", "joao@gmail.com", "12345678", "12345678", "555.555.555-55", "00000");

        // When
        ResultadoValidacao resultado = usuarioCepInvalido.salvarUsuario();

        // Then
        assertEquals(resultado.getMensagemErro(), "Erro ao salvar o usuário: O CEP fornecido é inválido.");
        assertFalse(resultado.isSucesso());
    }


}
