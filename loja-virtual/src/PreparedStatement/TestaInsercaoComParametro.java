package PreparedStatement;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        adicionarVariavel("LG Smart TV", "50 polegadas", preparedStatement);
        adicionarVariavel("Radio", "Radio de bateria", preparedStatement);
    }

    public static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

        

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        resultSet.close();
    }
}
