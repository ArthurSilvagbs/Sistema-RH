package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void getId() {
        Funcionario f = new Funcionario();
        int id = 1;
        f.setId(id);
        assertEquals(id, f.getId());
    }

    @Test
    void setId() {
        Funcionario f = new Funcionario();
        int idAntigo = 1;
        f.setId(idAntigo);
        int idNovo = 2;
        f.setId(idNovo);
        assertNotEquals(idAntigo, f.getId());
    }

    @Test
    void getNome() {
        Funcionario f = new Funcionario();
        String nome = "Nome";
        f.setNome(nome);
        assertEquals(nome, f.getNome());
    }

    @Test
    void setNome() {
        Funcionario f = new Funcionario();
        String nome1 = "Nome1";
        f.setNome(nome1);
        String nome2 = "Nome2";
        f.setNome(nome2);
        assertNotEquals(nome1, f.getNome());
    }

    @Test
    void getSalario() {
        Funcionario f = new Funcionario();
        BigDecimal salario = new BigDecimal(1000);
        f.setSalario(salario);
        assertEquals(salario, f.getSalario());
    }

    @Test
    void setSalario() {
        Funcionario f = new Funcionario();
        BigDecimal salario1 = new BigDecimal(1000);
        f.setSalario(salario1);
        BigDecimal salario2 = new BigDecimal(2000);
        f.setSalario(salario2);
        assertNotEquals(salario1, f.getSalario());
    }

    @Test
    void getCargo() {
        Funcionario f = new Funcionario();
        String cargo = "Gerente";
        f.setCargo(cargo);
        assertEquals(cargo, f.getCargo());
    }

    @Test
    void setCargo() {
        Funcionario f = new Funcionario();
        String cargo1 = "Auxiliar";
        f.setCargo(cargo1);
        String cargo2 = "Coordenador";
        f.setCargo(cargo2);
        assertNotEquals(cargo1, f.getCargo());
    }

    @Test
    void testToString() {
        Funcionario f = new Funcionario(1, "Arthur", new BigDecimal(1000), "Gerente");
        String saidaToString = f.toString();
        String saidaEsperadaToString = String.format("ID: %d | NOME: %s | SALÁRIO: R$ %.2f | CARGO: %s", f.getId(), f.getNome(), f.getSalario(), f.getCargo());
        assertEquals(saidaToString, saidaEsperadaToString);
    }
}