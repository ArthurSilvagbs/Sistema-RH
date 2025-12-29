package jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class FabricaConexoesTest {

    @Test
    void getConexao() {
        try (Connection conn = FabricaConexoes.getConexao()) {

            // Verifica se o objeto foi criado (não é null)
            Assertions.assertNotNull(conn, "A conexão não deveria ser nula");

            // Verifica se a conexão está realmente ativa no MySQL
            Assertions.assertFalse(conn.isClosed(), "A conexão deveria estar aberta");

        } catch (SQLException e) {
            // Se cair aqui, o teste falha automaticamente
            Assertions.fail("Falha ao conectar ao banco: " + e.getMessage());
        }
    }

}