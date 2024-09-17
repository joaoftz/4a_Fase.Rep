import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.ResultadoValidacao;
import com.example.Usuario;

public class usuarioTest {
    @Test
    public void DeveCadastrarComSucessoTest(){
        // given
        Usuario  usuarioValido = new Usuario("nome", "email@gmail.com", "12345678", "12345678", "32023705000110", "88061423");

        // when
        ResultadoValidacao resultado = usuarioValido.salvarUsuario();

        // then
        assertEquals(resultado.getMensagemErro(), "Usuario Salvo com sucesso!");
        assertTrue(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarQuandoConfirmacaoSenhaForemDiferente(){
        // given
        Usuario  usuarioValido = new Usuario("nome", "email@gmail.com", "12345678", "12345678910", "32023705000110", "88061423");

        // when
        ResultadoValidacao resultado = usuarioValido.salvarUsuario();

        // then
        assertEquals(resultado.getMensagemErro(), "\"Erro ao salvar o usuário: A senha e a confirmação de senha não\r\n" + //
                        "correspondem.\"\r");
        assertFalse(resultado.isSucesso());
    }

    @Test
    public void DeveRetornarQuandoNomeNaoForInserido(){
        // given
        Usuario  usuarioValido = new Usuario(null, "email@gmail.com", "12345678", "12345678910", "32023705000110", "88061423");

        // when
        ResultadoValidacao resultado = usuarioValido.salvarUsuario();

        // then
        assertEquals(resultado.getMensagemErro(),"Erro ao salvar o usuário: O nome é obrigatório");
        assertFalse(resultado.isSucesso());
    }
    
}
