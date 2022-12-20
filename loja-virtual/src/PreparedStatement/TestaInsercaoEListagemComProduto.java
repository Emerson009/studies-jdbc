package PreparedStatement;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import model.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException{

        Produto produto = new Produto("comoda", "comoda marrom");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(produto);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
        }
    }
}
