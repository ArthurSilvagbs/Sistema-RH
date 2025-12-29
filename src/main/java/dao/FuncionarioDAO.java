package dao;

import model.Funcionario;

public interface FuncionarioDAO {

    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario);
    public void verListaDeFuncionarios();
    public void atualizarSalario();
    public void demitirFuncionario();

}
