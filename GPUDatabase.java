package pdcproject2;

/**
 *
 * @author Peter
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GPUDatabase {
    
    private final DatabaseManager dbManager;
    private final Connection conn;
   
    public GPUDatabase() {
        dbManager = new DatabaseManager();
        conn = dbManager.getConnection();
    }
 
    public void createNVIDIA30Table() {
        try {
            Connection connection = dbManager.getConnection();
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "NVIDIA30series";

            ResultSet tables = connection.getMetaData().getTables(null, null, newTableName.toUpperCase(), null);
            boolean tableExists = tables.next();

            if (tableExists) {
                String sqlDrop = "DROP TABLE " + newTableName;
                statement.executeUpdate(sqlDrop);
            }

            String sqlCreate = "CREATE TABLE " + newTableName + " ("
                    + "NAME VARCHAR(30), STOCK INT, PRICE DOUBLE, MEMORY INT, CLOCKSPEED DOUBLE, NUMCORES INT)";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "INSERT INTO " + newTableName + " VALUES "
                    + "('RTX 3060', 10, 500.00, 8, 1320.0, 3584),"
                    + "('RTX 3060ti', 5, 699.99, 8, 1770.0, 4864),"
                    + "('RTX 3070', 7, 899.99, 8, 1500.0, 5888),"
                    + "('RTX 3070ti', 4, 1099.99, 8, 1830.0, 6144),"
                    + "('RTX 3080', 5, 1359.99, 10, 1440, 8704),"
                    + "('RTX 3080ti', 3, 1799.99, 12, 1365, 10240),"
                    + "('RTX 3090', 6, 2599.99, 24, 1395, 10496),"
                    + "('RTX 3090ti', 2, 3599.99, 24, 1560, 10752)";
            statement.executeUpdate(sqlInsert);

            System.out.println("NVIDIA 30 series table created");

        } catch (SQLException e) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
    public void createNVIDIA40Table(){        
        try {
            Connection connection = dbManager.getConnection();
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "NVIDIA40series";

            ResultSet tables = connection.getMetaData().getTables(null, null, newTableName.toUpperCase(), null);
            boolean tableExists = tables.next();

            if (tableExists) {
                String sqlDrop = "DROP TABLE " + newTableName;
                statement.executeUpdate(sqlDrop);
            }

            String sqlCreate = "CREATE TABLE " + newTableName + "(NAME VARCHAR(30), STOCK INT, PRICE DOUBLE, MEMORY INT, CLOCKSPEED DOUBLE, NUMCORES INT)";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "INSERT INTO " + newTableName + " VALUES "
                    + "('RTX 4070', 8, 1499.99, 12, 1920.0, 5888),"
                    + "('RTX 4070ti', 5, 1699.99, 12, 2310.0, 7680),"
                    + "('RTX 4080', 4, 2099.99, 16, 2205.0, 9728),"
                    + "('RTX 4090', 3, 3259.99, 24, 2235.0, 16384)";
            statement.executeUpdate(sqlInsert);

            System.out.println("NVIDIA 40 series table created");

        } catch (SQLException e) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    public void createAMD6000Table(){        
        try {
            Connection connection = dbManager.getConnection();
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "AMD6000series";

            ResultSet tables = connection.getMetaData().getTables(null, null, newTableName.toUpperCase(), null);
            boolean tableExists = tables.next();

            if (tableExists) {
                String sqlDrop = "DROP TABLE " + newTableName;
                statement.executeUpdate(sqlDrop);
            }

            String sqlCreate = "CREATE TABLE " + newTableName + "(NAME VARCHAR(30), STOCK INT, PRICE DOUBLE, MEMORY INT, CLOCKSPEED DOUBLE, NUMCORES INT)";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "INSERT INTO " + newTableName + " VALUES "
                    + "('RX 6500 XT', 8, 319.99, 4, 2310, 1024),"
                    + "('RX 6600', 6, 349.99, 8, 1626, 1792),"
                    + "('RX 6600 XT', 4, 449.99, 8, 1968, 2048),"
                    + "('RX 6650 XT', 6, 549.99, 8, 2055, 2048),"
                    + "('RX 6700', 8, 609.99, 10, 1941, 2304),"
                    + "('RX 6700 XT', 6, 649.99, 12, 2321, 2560),"
                    + "('RX 6750 XT', 3, 749.99, 12, 2150, 2560),"
                    + "('RX 6800', 6, 1019.99, 16, 1700, 3840),"
                    + "('RX 6800 XT', 4, 1549.99, 16, 1825, 4608),"
                    + "('RX 6900 XT', 2, 1999.99, 16, 1825, 5120)";
            statement.executeUpdate(sqlInsert);

            System.out.println("AMD 6000 series table created");

        } catch (SQLException e) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    public void createAMD7000Table(){        
        try {
            Connection connection = dbManager.getConnection();
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "AMD7000series";

            ResultSet tables = connection.getMetaData().getTables(null, null, newTableName.toUpperCase(), null);
            boolean tableExists = tables.next();

            if (tableExists) {
                String sqlDrop = "DROP TABLE " + newTableName;
                statement.executeUpdate(sqlDrop);
            }

            String sqlCreate = "CREATE TABLE " + newTableName + "(NAME VARCHAR(30), STOCK INT, PRICE DOUBLE, MEMORY INT, CLOCKSPEED DOUBLE, NUMCORES INT)";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "INSERT INTO " + newTableName + " VALUES "
                    + "('RX 7900 XT', 10, 1599.99, 20, 1500, 5376),"
                    + "('RX 7900 XTX', 5, 1999.99, 24, 2499, 6144)";
                    
            statement.executeUpdate(sqlInsert);

            System.out.println("AMD 7000 series table created");

        } catch (SQLException e) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public ArrayList<GPU> getNVIDIA30GPUs(){
        
        ArrayList<GPU> gpuList = new ArrayList<>();
        
        ResultSet rs = dbManager.myQuery("SELECT * FROM NVIDIA30SERIES");
        
        try{
            while(rs.next()){
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");
                
                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                
                gpuList.add(gpu);         
                
                System.out.println("Showing all NVIDIA 30 gpus in the database");
            }
        }catch(SQLException ex){
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;        
    }
    
    public ArrayList<GPU> getNVIDIA40GPUs(){
        
        ArrayList<GPU> gpuList = new ArrayList<>();
        
        ResultSet rs = dbManager.myQuery("SELECT * FROM NVIDIA40SERIES");
        
        try{
            while(rs.next()){
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");
                
                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                
                gpuList.add(gpu);   
                
                System.out.println("Showing all NVIDIA 40 gpus in the database!");
            }
        }catch(SQLException ex){
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;        
    }
    
    public ArrayList<GPU> getAMD6000GPUs(){
        
        ArrayList<GPU> gpuList = new ArrayList<>();
        
        ResultSet rs = dbManager.myQuery("SELECT * FROM AMD6000SERIES");
        
        try{
            while(rs.next()){
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");
                
                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                
                gpuList.add(gpu);   
                
                System.out.println("Showing all AMD 6000 gpus in the database!");
            }
        }catch(SQLException ex){
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;        
    }
    
    
    public ArrayList<GPU> getAMD7000GPUs(){
        
        ArrayList<GPU> gpuList = new ArrayList<>();
        
        ResultSet rs = dbManager.myQuery("SELECT * FROM AMD7000SERIES");
        
        try{
            while(rs.next()){
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");
                
                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                
                gpuList.add(gpu);  
                System.out.println("Showing all AMD 7000 gpus in the database!");
            }
        }catch(SQLException ex){
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;        
    }
    
    public static void main(String[] args) {

        GPUDatabase db = new GPUDatabase();
        db.createNVIDIA30Table();
        db.createNVIDIA40Table();
        db.createAMD6000Table();
        db.createAMD7000Table();
        
        ArrayList<GPU> gpuList = db.getAMD7000GPUs();
        
        for(GPU gpu : gpuList)
        {
            System.out.println(gpu);
        }

        db.dbManager.closeConnection();     

    }    
}
