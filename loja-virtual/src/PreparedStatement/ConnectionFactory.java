package PreparedStatement;

import java.sql.*;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "EticumSans17@#$");
    }
}