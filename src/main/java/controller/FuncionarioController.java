package controller;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOMySQL;
import model.Funcionario;

import java.util.List;

public class FuncionarioController {

    public void contratarFuncionario(Funcionario funcionario) {

        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.adicionarioFuncionarioAoBanco(funcionario)) {
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

        return dao.verFuncionariosDoBanco();
    }
}
