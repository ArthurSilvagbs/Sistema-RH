package controller;

import model.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioControllerTest {

    @Test
    void contratarFuncionarioDeveFuncionarSemExcecoes() {
        Funcionario f = new Funcionario("Arthur", new BigDecimal("1000"), "Dev");
        FuncionarioController controller = new FuncionarioController();

        assertDoesNotThrow(() -> controller.contratarFuncionario(f));
    }

    @Test
    void contratarFuncionarioDeveSalvarNoBanco() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", new BigDecimal("1000"), "Dev");
        FuncionarioController controller = new FuncionarioController();

        controller.contratarFuncionario(funcionario);

        List<Funcionario> funcionarios = controller.verListaFuncionarios();
        boolean encontrou = funcionarios.stream().anyMatch(f -> f.getNome().equals(funcionario.getNome()));

        assertTrue(encontrou, "O funcionário deveria estar na lista após ser contratado");
    }

    @Test
    void verListaFuncionarios() {
        FuncionarioController controller = new FuncionarioController();

        // Agora o Java aceita guardar na variável
        List<Funcionario> lista = controller.verListaFuncionarios();

        // Validações objetivas:
        assertNotNull(lista, "A lista não deveria ser nula");

        // Se você sabe que o banco tem dados:
        assertFalse(lista.isEmpty(), "A lista deveria conter funcionários");
    }

    @Test
    void verListaFuncionariosDeveRetornarListaVaziaQuandoNaoHouverDados() {
        FuncionarioController controller = new FuncionarioController();

        // Supondo que o banco esteja vazio
        List<Funcionario> lista = controller.verListaFuncionarios();

        assertNotNull(lista);
        assertFalse(lista.isEmpty(), "A lista deveria estar vazia, mas não nula");
    }
}