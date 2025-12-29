package dao;

import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioDAO {

    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario);
    public List<Funcionario> verFuncionariosDoBanco();
    public boolean atualizarSalarioNoBanco(int id, BigDecimal novoSalario);
    public void demitirFuncionario();

}
