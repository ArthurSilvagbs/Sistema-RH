package dao;

import jdbc.FabricaConexoes;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAOMySQL implements FuncionarioDAO {

    private FuncionarioDAO dao;

    @Override
    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar novo funcionário no banco", e);
        }
    }

    @Override
    public void verListaDeFuncionarios() {

    }

    @Override
    public void atualizarSalario() {

    }

    @Override
    public void demitirFuncionario() {

    }
}
