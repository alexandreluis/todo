
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alexandreluis
 */
public class ConnectionFactory 
{
    private static String url = "jdbc:mysql://localhost:3307/todo?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
    private static String user = "root";
    private static String password = "";
    
    
    public static Connection getConnection()
    {
        Connection conn = null;
        
        try
        {
            conn = DriverManager.getConnection(url, user, password);
        }catch(Exception e)
        {
            throw new RuntimeException("Erro na conexão com o banco de dados" + e.getMessage());
        }
        return conn;
    }
    
    public static void closeConnection(Connection connection)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
        }catch(Exception e)
        {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.");
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
            
            if(statement != null)
            {
                statement.close();
            }
        }catch(Exception e)
        {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados e statement.");
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
            
            if(statement != null)
            {
                statement.close();
            }
            
            if(resultSet != null)
            {
                resultSet.close();
            }
        }catch(Exception e)
        {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados e statement.");
        }
    }
}