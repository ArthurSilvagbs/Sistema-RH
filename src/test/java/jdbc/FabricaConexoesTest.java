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
            Assertions.assertNotNull(conn, "A conexão não deveria ser nula");
            Assertions.assertFalse(conn.isClosed(), "A conexão deveria estar aberta");
        } catch (SQLException e) {
            Assertions.fail("Falha ao conectar ao banco: " + e.getMessage());
        }
    }

}