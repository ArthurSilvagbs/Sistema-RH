package dao;

import model.Funcionario;

import java.util.List;

public interface FuncionarioDAO {

    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario);
    public List<Funcionario> verFuncionariosDoBanco();
    public void atualizarSalario();
    public void demitirFuncionario();

}
