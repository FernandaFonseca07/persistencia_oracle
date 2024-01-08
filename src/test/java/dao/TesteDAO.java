package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDAO {
    static Connection connection;
    static Statement stmt;

    @BeforeClass
    public static void beforeClass () throws SQLException {
        System.out.println("Iniciando conexão com o banco");
        connection = ConnectionFactory.getConnection();
        stmt = connection.createStatement();
        connection.setAutoCommit(false);
    }

    @Test
    public void testeRetornoSelectDadosTeste () throws SQLException {
        String comandoSQL = "SELECT  dt.Massa_teste FROM DADOS_TESTE dt WHERE ID_CASO_TESTE = 1"; //criando um comando SQL
        ResultSet resultSet = stmt.executeQuery(comandoSQL);
        resultSet.next();//aponta para o primeiro valor do resultado
        String jsonMassaTeste = resultSet.getNString(1);
        Assert.assertTrue("Informação incorreta", jsonMassaTeste.contains("\"url\":\"https://amazon.com.br\""));
    }

    @After
    public void after() throws SQLException {
        stmt.close();
        connection.close();
        System.out.println("Conexão finalizada com sucesso");
    }

}
