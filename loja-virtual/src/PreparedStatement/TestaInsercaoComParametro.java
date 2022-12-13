package PreparedStatement;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        String nome = "Geladeira";
        String descricao = "Geladeira com filtro";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
