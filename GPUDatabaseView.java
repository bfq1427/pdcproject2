package pdcproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 * 09/06/2023
 */

//class to view the GPU database, calling it through SQL statements
public class GPUDatabaseView {

    private DatabaseManager dbManager;

    public GPUDatabaseView() {
        dbManager = new DatabaseManager();
    }

    //views NVIDIA 30 GPU's from the database
    public ArrayList<GPU> getNVIDIA30GPUs() {        
       
        ArrayList<GPU> gpuList = new ArrayList<>();

        ResultSet rs = dbManager.myQuery("SELECT * FROM NVIDIA30SERIES");

        try {
            while (rs.next()) {
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");

                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);

                gpuList.add(gpu);
            }
            System.out.println("Showing all NVIDIA 30 gpus in the database");
        } catch (SQLException ex) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;
    }

    //views NVIDIA 40 GPU's from the database
    public ArrayList<GPU> getNVIDIA40GPUs() {

        ArrayList<GPU> gpuList = new ArrayList<>();

        ResultSet rs = dbManager.myQuery("SELECT * FROM NVIDIA40SERIES");

        try {
            while (rs.next()) {
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");

                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);

                gpuList.add(gpu);
            }
            System.out.println("Showing all NVIDIA 40 gpus in the database!");
        } catch (SQLException ex) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;
    }

    //views AMD6000 GPU's from the database
    public ArrayList<GPU> getAMD6000GPUs() {

        ArrayList<GPU> gpuList = new ArrayList<>();

        ResultSet rs = dbManager.myQuery("SELECT * FROM AMD6000SERIES");

        try {
            while (rs.next()) {
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");

                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);

                gpuList.add(gpu);
            }
            System.out.println("Showing all AMD 6000 gpus in the database!");
        } catch (SQLException ex) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;
    }

     //views AMD7000 GPU's from the database
    public ArrayList<GPU> getAMD7000GPUs() {

        ArrayList<GPU> gpuList = new ArrayList<>();

        ResultSet rs = dbManager.myQuery("SELECT * FROM AMD7000SERIES");

        try {
            while (rs.next()) {
                String name = rs.getString("Name");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                int memory = rs.getInt("Memory");
                double clockSpeed = rs.getDouble("ClockSpeed");
                int numCores = rs.getInt("NumCores");

                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);

                gpuList.add(gpu);
            }
            System.out.println("Showing all AMD 7000 gpus in the database!");
        } catch (SQLException ex) {
            Logger.getLogger(GPUDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpuList;
    }

    //main to test and view the GPU's in the database
    public static void main(String[] args) {

        GPUDatabaseView db = new GPUDatabaseView();

        ArrayList<GPU> gpuList1 = db.getNVIDIA30GPUs();
        ArrayList<GPU> gpuList2 = db.getNVIDIA40GPUs();
        ArrayList<GPU> gpuList3 = db.getAMD6000GPUs();
        ArrayList<GPU> gpuList4 = db.getAMD7000GPUs();
        
         System.out.println("=========================");

        for (GPU gpu : gpuList1) {
            System.out.println(gpu);            
        }
         System.out.println("=========================");
        for (GPU gpu : gpuList2) {
            System.out.println(gpu);            
        }
         System.out.println("=========================");
        for (GPU gpu : gpuList3) {
            System.out.println(gpu);          
        }
         System.out.println("=========================");
        for (GPU gpu : gpuList4) {
            System.out.println(gpu);           
        }
         System.out.println("=========================");

        db.dbManager.closeConnection();

    }
}
