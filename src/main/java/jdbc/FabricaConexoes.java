package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexoes {

    public static Connection getConexao() {
        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro crítico! Problemas com a comunicação com o banco de dados." + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Erro crítico! Arquivo de configuração não encontrado ou comprometido." + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String path = "/conexao.properties";
        try {
            prop.load(FabricaConexoes.class.getResourceAsStream(path));
            return prop;
        } catch (IOException e) {
            System.out.println("Erro crítico! Path do arquivo de configuração não encontrado");
        }
        return prop;
    }

}
