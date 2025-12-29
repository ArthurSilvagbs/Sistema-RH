package dao;

import jdbc.FabricaConexoes;
import model.Funcionario;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOMySQL implements FuncionarioDAO {

    private FuncionarioDAO dao;

    @Override
    public boolean adicionarioFuncionarioAoBanco(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setBigDecimal(3, funcionario.getSalario());
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar novo funcionário no banco", e);
        }
    }

    @Override
    public List<Funcionario> verFuncionariosDoBanco() {
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                BigDecimal salario = resultado.getBigDecimal("salario");
                String cargo = resultado.getString("cargo");

                funcionarios.add(new Funcionario(id, nome, salario, cargo));
            }

            for (Funcionario funcionario: funcionarios) {
                System.out.println(funcionario.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro na operação!", e);
        }
        return funcionarios;
    }

    @Override
    public boolean atualizarSalarioNoBanco(int id, BigDecimal novoSalario) {
        String sql = "UPDATE pessoas SET nome = ? where id = ?";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setBigDecimal(1, novoSalario);
            stmt.setInt(2, id);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro na operação!", e);
        }
    }

    @Override
    public void demitirFuncionario() {

    }
}
