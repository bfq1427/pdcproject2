package pdcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * *
 * @author Peter Chan 
 * #20117970 
 * COMP603/04a
 * 09/06/2023
 */

//class which handles the adding of GPU's through the GUI
public class guiAdd {

    //adds elements to the specific table and inserting all neccessary values needed
    public void nvidia30Add(String name, int stock, double price, int memory, double clockSpeed, int numCores) {

        try {

            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String query = "SELECT * FROM NVIDIA30SERIES WHERE Name = ?";

            PreparedStatement duplicateStatement = conn.prepareStatement(query);

            duplicateStatement.setString(1, name);

            ResultSet rs = duplicateStatement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "GPU with the same name already exists. Duplicate entry not allowed.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "INSERT INTO NVIDIA30SERIES (Name, Stock, Price, Memory, ClockSpeed, NumCores) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement st = conn.prepareStatement(sql);

                st.setString(1, name);
                st.setInt(2, stock);
                st.setDouble(3, price);
                st.setInt(4, memory);
                st.setDouble(5, clockSpeed);
                st.setInt(6, numCores);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "GPU added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //adds elements to the specific table and inserting all neccessary values needed
    public void nvidia40Add(String name, int stock, double price, int memory, double clockSpeed, int numCores) {

        try {

            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String query = "SELECT * FROM NVIDIA40SERIES WHERE Name = ?";

            PreparedStatement duplicateStatement = conn.prepareStatement(query);

            duplicateStatement.setString(1, name);

            ResultSet rs = duplicateStatement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "GPU with the same name already exists. Duplicate entry not allowed.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "INSERT INTO NVIDIA40SERIES (Name, Stock, Price, Memory, ClockSpeed, NumCores) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement st = conn.prepareStatement(sql);

                st.setString(1, name);
                st.setInt(2, stock);
                st.setDouble(3, price);
                st.setInt(4, memory);
                st.setDouble(5, clockSpeed);
                st.setInt(6, numCores);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "GPU added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //adds elements to the specific table and inserting all neccessary values needed
    public void amd6000Add(String name, int stock, double price, int memory, double clockSpeed, int numCores) {

        try {

            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String query = "SELECT * FROM AMD6000SERIES WHERE Name = ?";

            PreparedStatement duplicateStatement = conn.prepareStatement(query);

            duplicateStatement.setString(1, name);

            ResultSet rs = duplicateStatement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "GPU with the same name already exists. Duplicate entry not allowed.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "INSERT INTO AMD6000SERIES (Name, Stock, Price, Memory, ClockSpeed, NumCores) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement st = conn.prepareStatement(sql);

                st.setString(1, name);
                st.setInt(2, stock);
                st.setDouble(3, price);
                st.setInt(4, memory);
                st.setDouble(5, clockSpeed);
                st.setInt(6, numCores);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "GPU added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //adds elements to the specific table and inserting all neccessary values needed
    public void amd7000Add(String name, int stock, double price, int memory, double clockSpeed, int numCores) {

        try {

            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String query = "SELECT * FROM AMD7000SERIES WHERE Name = ?";

            PreparedStatement duplicateStatement = conn.prepareStatement(query);

            duplicateStatement.setString(1, name);

            ResultSet rs = duplicateStatement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "GPU with the same name already exists. Duplicate entry not allowed.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "INSERT INTO AMD7000SERIES (Name, Stock, Price, Memory, ClockSpeed, NumCores) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement st = conn.prepareStatement(sql);

                st.setString(1, name);
                st.setInt(2, stock);
                st.setDouble(3, price);
                st.setInt(4, memory);
                st.setDouble(5, clockSpeed);
                st.setInt(6, numCores);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "GPU added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
