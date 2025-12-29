package dao;

import model.Funcionario;

public interface FuncionarioDAO {

    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario);
    public void verFuncionariosDoBanco();
    public void atualizarSalario();
    public void demitirFuncionario();

}
