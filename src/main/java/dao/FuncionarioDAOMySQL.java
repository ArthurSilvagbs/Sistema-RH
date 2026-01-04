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

    public String buscarFuncionarioPorID(int id) {
        String sql = "SELECT id, nome, salario, cargo FROM funcionarios WHERE id = ?";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()){
                int idF = resultado.getInt("id");
                String nome = resultado.getString("nome");
                BigDecimal salario = resultado.getBigDecimal("salario");
                String cargo = resultado.getString("cargo");

                Funcionario funcionario = new Funcionario(idF, nome, salario, cargo);

                return funcionario.toString();
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro na operação! ", e);
        }
    }

    @Override
    public boolean adicionarioFuncionarioDAO(Funcionario funcionario) {
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
    public List<Funcionario> verFuncionariosDAO() {
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery();

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
    public boolean atualizarSalarioDAO(int id, BigDecimal novoSalario) {

        buscarFuncionarioPorID(id);

        String sql = "UPDATE funcionarios SET salario = ? where id = ?";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setBigDecimal(1, novoSalario);
            stmt.setInt(2, id);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean atualizarCargoDAO(int id, String novoCargo) {
        buscarFuncionarioPorID(id);

        String sql = "UPDATE funcionarios SET cargo = ? where id = ?";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novoCargo);
            stmt.setInt(2, id);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro na operação!", e);
        }
    }

    public BigDecimal getSomaSalariosDAO() {

        String sql = "SELECT SUM(salario) as somatoriaSalarios FROM funcionarios";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                return resultado.getBigDecimal("somatoriaSalarios");
            }

            return BigDecimal.ZERO;

        } catch (SQLException e) {
            throw new RuntimeException("Erro na operação!", e);
        }

    }

    @Override
    public boolean excluirFuncionarioDAO(int id) {

        buscarFuncionarioPorID(id);

        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (Connection conexao = FabricaConexoes.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário do banco", e);
        }
    }
}
