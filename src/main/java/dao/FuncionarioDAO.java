package dao;

import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioDAO {

    String buscarFuncionarioPorID(int id);
    boolean adicionarioFuncionarioDAO(Funcionario funcionario);
    List<Funcionario> verFuncionariosDAO();
    boolean atualizarSalarioDAO(int id, BigDecimal novoSalario);
    boolean atualizarCargoDAO(int id, String novoCargo);
    BigDecimal getSomaSalariosDAO();
    boolean excluirFuncionarioDAO(int id);

}
