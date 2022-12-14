import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        preparedStatement.setInt(1, 2);
        preparedStatement.execute();

        int linhasModificadas = preparedStatement.getUpdateCount();

        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }


}
