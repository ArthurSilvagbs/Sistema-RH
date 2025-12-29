package controller;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOMySQL;
import model.Funcionario;

public class FuncionarioController {

    public void contratarFuncionario(Funcionario funcionario) {

        FuncionarioDAO dao = new FuncionarioDAOMySQL();

        try {
            if (dao.adicionarioFuncionarioAoBanco(funcionario)) {
                System.out.println("Contratação realizada!");
            } else {
                System.out.println("O banco recusou a inserção.");
            }
        } catch (NullPointerException e) {
            System.out.println("Erro na operação!" + e.getMessage());
        }

    }
}
