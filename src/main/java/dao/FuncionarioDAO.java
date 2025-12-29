package dao;

import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioDAO {

    public String buscarFuncionarioPorID(int id);
    public boolean adicionarioFuncionarioDAO(Funcionario funcionario);
    public List<Funcionario> verFuncionariosDAO();
    public boolean atualizarSalarioDAO(int id, BigDecimal novoSalario);
    public void excluirFuncionarioDAO(int id);


}
