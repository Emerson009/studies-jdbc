package PreparedStatement;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection connection = criaConexao.recuperarConexao();

       PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        preparedStatement.execute();
       ResultSet resultSet = preparedStatement.getResultSet();
       while(resultSet.next()){
           Integer id = resultSet.getInt("ID");
           System.out.println(id);
           String nome = resultSet.getString("NOME");
           System.out.println(nome);
           String descricao = resultSet.getString("DESCRICAO");
           System.out.println(descricao);
       }

       connection.close();

    }
}
