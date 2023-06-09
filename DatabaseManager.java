package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 * 09/06/2023
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//database manager class for handling the connection of the JDBC and functions
public final class DatabaseManager {
    
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";  
   
    private static final String URL = "jdbc:derby://localhost:1527/GPU_Database;create=true";
    
    Connection conn;
    
    public DatabaseManager(){
        establishConnection();
    }
    
    
    public static void main(String[] args) {
        
        DatabaseManager dbManager = new DatabaseManager();
        System.out.println(dbManager.getConnection());
        
    }

    public Connection getConnection(){
        return this.conn;        
    }
    
    //establish the connection with the server
    public void establishConnection() {

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    //close connection to the server 
    public void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    //handles update statements
    public void updateDB(String sql){
        
        Connection connection = this.conn;
        Statement statement = null;
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    //handles queries and resultsets
    public ResultSet myQuery(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    
    
    
    
    
    
    
}
