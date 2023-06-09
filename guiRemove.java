package pdcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 * 09/06/2023
 */

//class that envokes the remove action through the GUI 
public class guiRemove {
    
    //removes GPU's based on name
    public void nvidia30Remove(String name){
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM NVIDIA30SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();
            
            
            if(rowsDelete > 0){
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);                
                inventoryMenu database30 = new inventoryMenu();                
                database30.Nvidia30dataBase();             
            }else{
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }            
            conn.close();                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error removing gpu", "Error", JOptionPane.ERROR_MESSAGE);           
        }
    }    

    //removes GPU's based on name
    public void nvidia40Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM NVIDIA40SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);                
                inventoryMenu database40 = new inventoryMenu();                
                database40.Nvidia40dataBase();            
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing gpu", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }

    //removes GPU's based on name
    public void amd6000Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM AMD6000SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);                
                inventoryMenu database6000 = new inventoryMenu();                
                database6000.Amd6000dataBase();      
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing gpu", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }

    //removes GPU's based on name
    public void amd7000Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM AMD7000SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                inventoryMenu database7000 = new inventoryMenu();                
                database7000.Amd7000dataBase();             
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing gpu", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }

}
