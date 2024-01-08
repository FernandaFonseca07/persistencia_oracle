package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

    public static Connection getConnection() throws SQLException {
        String serverName = "localhost";
        String portNumber = "1521";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+serverName+ ":"+portNumber+":"+sid;
        String username = "system";
        String password = "1813metallica";
        return DriverManager.getConnection(url, username, password);
    }
}
