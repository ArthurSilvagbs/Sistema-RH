package controller;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOMySQL;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class FuncionarioController {

    public String imprimirFuncionario(int id) {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();
        return dao.buscarFuncionarioPorID(id);
    }

    public void contratarFuncionario(Funcionario funcionario) {

        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.adicionarioFuncionarioDAO(funcionario)) {
                System.out.println("Contratação realizada!");
            } else {
                System.out.println("O banco recusou a inserção.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro na operação!" + e.getMessage());
        }

    }

    public List<Funcionario> verListaFuncionarios() {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        return dao.verFuncionariosDAO();
    }

    public void atualizarSalario(int id, BigDecimal novoSalario) {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.atualizarSalarioDAO(id, novoSalario)) {
                System.out.println("Salário atualizado com sucesso!");
            } else {
                System.out.println("Problema ao atualizar o salário. Tente novamente.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro na operação!" + e.getMessage());
        }
    }

    public void alterarCargo(int id, String novoCargo) {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.atualizarCargoDAO(id, novoCargo)) {
                System.out.println("Cargo atualizado com sucesso!");
            } else {
                System.out.println("Problema ao atualizar o cargo. Tente novamente.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro na operação!" + e.getMessage());
        }
    }

    public BigDecimal getFolhaDePagamento() {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();
        return dao.getSomaSalariosDAO();
    }

    public void demitirFuncionario(int id) {
        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.excluirFuncionarioDAO(id)) {
                System.out.println("Demissão realizada!");
            } else {
                System.out.println("Algum problema ao demitir o funcionário.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro na operação!" + e.getMessage());
        }
    }
}
