import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
        Connection root = DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "EticumSans17@#$");
        return root;
    }
}