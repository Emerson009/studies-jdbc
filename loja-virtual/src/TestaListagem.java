import java.sql.*;
import java.util.List;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory criaConexao = new ConnectionFactory();

        Connection connection = criaConexao.recuperarConexao();

       Statement statement = connection.createStatement();
       statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

       ResultSet resultSet = statement.getResultSet();

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
