package pdcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter
 */
public class inventoryMenu extends javax.swing.JFrame {

    /**
     * Creates new form inventoryMenu
     */
    public inventoryMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        Nvidia30dataBase();
        Nvidia40dataBase();
        Amd6000dataBase();
        Amd7000dataBase();
        
       
        
    }
    
    public void Nvidia30dataBase(){
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;","pdc","pdc");
            
            String sql = "SELECT * FROM NVIDIA30SERIES";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            model.setColumnCount(0);
            model.addColumn("Name");
            model.addColumn("Stock");
            model.addColumn("Price $");
            model.addColumn("Memory GBs");
            model.addColumn("ClockSpeed GHz");
            model.addColumn("NumCores");
            model.setRowCount(0);
            
            
            while(rs.next()){
                
                String name = rs.getString("Name");
                String stock = String.valueOf(rs.getInt("Stock"));
                String price = String.valueOf(rs.getDouble("Price"));
                String memory = String.valueOf(rs.getInt("Memory"));
                String clockSpeed = String.valueOf(rs.getDouble("ClockSpeed"));
                String numCores = String.valueOf(rs.getInt("NumCores"));
                
                model.addRow(new Object[]{name, stock, price, memory, clockSpeed, numCores});
            }
            conn.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Nvidia40dataBase(){
        
         try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;","pdc","pdc");
            
            Statement st = conn.createStatement();
            
            String sql = "SELECT * FROM NVIDIA40SERIES";
            
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            
           
            model.setColumnCount(0);
            model.addColumn("Name");
            model.addColumn("Stock");
            model.addColumn("Price $");
            model.addColumn("Memory GBs");
            model.addColumn("ClockSpeed GHz");
            model.addColumn("NumCores");
            model.setRowCount(0);
            
            
            while(rs.next()){
                
                String name = rs.getString("Name");
                String stock = String.valueOf(rs.getInt("Stock"));
                String price = String.valueOf(rs.getDouble("Price"));
                String memory = String.valueOf(rs.getInt("Memory"));
                String clockSpeed = String.valueOf(rs.getDouble("ClockSpeed"));
                String numCores = String.valueOf(rs.getInt("NumCores"));
                
                String tbData[] = {name, stock, price, memory, clockSpeed, numCores};

                model.addRow(tbData);                
            }
            conn.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    public void Amd6000dataBase(){    
         try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;","pdc","pdc");
            
            Statement st = conn.createStatement();
            
            String sql = "SELECT * FROM AMD6000SERIES";
            
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            
           
            model.setColumnCount(0);
            model.addColumn("Name");
            model.addColumn("Stock");
            model.addColumn("Price $");
            model.addColumn("Memory GBs");
            model.addColumn("ClockSpeed GHz");
            model.addColumn("NumCores");
            model.setRowCount(0);
            
            
            while(rs.next()){
                
                String name = rs.getString("Name");
                String stock = String.valueOf(rs.getInt("Stock"));
                String price = String.valueOf(rs.getDouble("Price"));
                String memory = String.valueOf(rs.getInt("Memory"));
                String clockSpeed = String.valueOf(rs.getDouble("ClockSpeed"));
                String numCores = String.valueOf(rs.getInt("NumCores"));
                
                String tbData[] = {name, stock, price, memory, clockSpeed, numCores};

                model.addRow(tbData);                
            }
            conn.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Amd7000dataBase() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            Statement st = conn.createStatement();

            String sql = "SELECT * FROM AMD7000SERIES";

            ResultSet rs = st.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

            model.setColumnCount(0);
            model.addColumn("Name");
            model.addColumn("Stock");
            model.addColumn("Price $");
            model.addColumn("Memory GBs");
            model.addColumn("ClockSpeed GHz");
            model.addColumn("NumCores");
            model.setRowCount(0);

            while (rs.next()) {

                String name = rs.getString("Name");
                String stock = String.valueOf(rs.getInt("Stock"));
                String price = String.valueOf(rs.getDouble("Price"));
                String memory = String.valueOf(rs.getInt("Memory"));
                String clockSpeed = String.valueOf(rs.getDouble("ClockSpeed"));
                String numCores = String.valueOf(rs.getInt("NumCores"));

                String tbData[] = {name, stock, price, memory, clockSpeed, numCores};

                model.addRow(tbData);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
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
            System.out.println(e.getMessage());
        }
    }
    
    public void nvidia30Remove(String name){
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM NVIDIA30SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();
            
            
            if(rowsDelete > 0){
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                Nvidia30dataBase();
            }else{
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }
            
            conn.close();            
            
        }catch(Exception e){
            System.out.println(JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void nvidia30Update(String name, String fieldName, String fieldValue){
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");
            
            String query = "SELECT * FROM NVIDIA30SERIES WHERE Name = ?";
            PreparedStatement duplicateStatement = conn.prepareStatement(query);
            duplicateStatement.setString(1, name);
            ResultSet rs = duplicateStatement.executeQuery();
            
            

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "GPU Name not found", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String sql = "UPDATE NVIDIA30SERIES SET " +fieldName + " = ? WHERE Name = ?"; 
                PreparedStatement st = conn.prepareStatement(fieldValue);
                
                if(fieldName.equals("Stock") || fieldName.equals("Memory") || fieldName.equals("NumCores")){
                    int value = Integer.parseInt(fieldValue);
                    st.setInt(1, value);
                }else if(fieldName.equals("Price") || fieldName.equals("ClockSpeed")){
                    double value = Double.parseDouble(fieldValue);
                    st.setDouble(1, value);
                }
                st.setString(2, name);
                st.executeUpdate();                
                JOptionPane.showMessageDialog(null, "GPU updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();  
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An Error Occurred");
        }
        
    }

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
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }

    public void nvidia40Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM NVIDIA40SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                Nvidia30dataBase();
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }

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
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }

    public void amd6000Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM AMD6000SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                Amd6000dataBase();
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }

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
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }

    public void amd7000Remove(String name) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GPU_Database;", "pdc", "pdc");

            String deleteQuery = "DELETE FROM AMD7000SERIES WHERE Name = ?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);

            deleteStatement.setString(1, name);

            int rowsDelete = deleteStatement.executeUpdate();

            if (rowsDelete > 0) {
                JOptionPane.showMessageDialog(null, "GPU removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                Amd7000dataBase();
            } else {
                JOptionPane.showMessageDialog(null, "GPU not found", "Not found", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding gpu");
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        stockButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NVIDIA30button = new javax.swing.JButton();
        NVIDIA40button = new javax.swing.JButton();
        AMD6000button = new javax.swing.JButton();
        AMD7000button = new javax.swing.JButton();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        nvidia30Name = new javax.swing.JLabel();
        nvidia30Stock = new javax.swing.JLabel();
        nvidia30Price = new javax.swing.JLabel();
        nvidia30PMemory = new javax.swing.JLabel();
        nvidia30ClockSpeed = new javax.swing.JLabel();
        nvidia30NumCores = new javax.swing.JLabel();
        name30TextField = new javax.swing.JTextField();
        stock30TextField = new javax.swing.JTextField();
        price30TextField = new javax.swing.JTextField();
        memory30TextField = new javax.swing.JTextField();
        clockSpeed30TextField = new javax.swing.JTextField();
        numCores30TextField = new javax.swing.JTextField();
        add30Button = new javax.swing.JButton();
        remove30Button = new javax.swing.JButton();
        update30Button = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        nvidia40Name = new javax.swing.JLabel();
        nvidia40Stock = new javax.swing.JLabel();
        nvidia40Price = new javax.swing.JLabel();
        nvidia40Memory = new javax.swing.JLabel();
        nvidia40clockSpeed = new javax.swing.JLabel();
        nvidia40NumCores = new javax.swing.JLabel();
        name40TextField = new javax.swing.JTextField();
        stock40TextField = new javax.swing.JTextField();
        price40TextField = new javax.swing.JTextField();
        memory40TextField = new javax.swing.JTextField();
        clockSpeed40TextField = new javax.swing.JTextField();
        numCores40TextField = new javax.swing.JTextField();
        add40Button = new javax.swing.JButton();
        remove40Button = new javax.swing.JButton();
        update40Button = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        amd6000Name = new javax.swing.JLabel();
        amd6000Stock = new javax.swing.JLabel();
        amd6000Price = new javax.swing.JLabel();
        amd6000Memory = new javax.swing.JLabel();
        amd6000ClockSpeed = new javax.swing.JLabel();
        amd6000NumCores = new javax.swing.JLabel();
        amd6000NameTextField = new javax.swing.JTextField();
        amd6000StockTextField = new javax.swing.JTextField();
        amd6000PriceTextField = new javax.swing.JTextField();
        amd6000MemoryTextField = new javax.swing.JTextField();
        amd6000ClockSpeedTextField = new javax.swing.JTextField();
        amd6000NumCoresTextField = new javax.swing.JTextField();
        amd6000Add = new javax.swing.JButton();
        amd6000Remove = new javax.swing.JButton();
        amd6000Update = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        amd7000Name = new javax.swing.JLabel();
        amd7000Stock = new javax.swing.JLabel();
        amd7000Price = new javax.swing.JLabel();
        amd7000Memory = new javax.swing.JLabel();
        amd7000ClockSpeed = new javax.swing.JLabel();
        amd7000NumCores = new javax.swing.JLabel();
        amd7000NameTextField = new javax.swing.JTextField();
        amd7000StockTextField = new javax.swing.JTextField();
        amd7000PriceTextField = new javax.swing.JTextField();
        amd7000MemoryTextField = new javax.swing.JTextField();
        amd7000ClockSpeedTextField = new javax.swing.JTextField();
        amd7000NumCoresTextField = new javax.swing.JTextField();
        amd7000Add = new javax.swing.JButton();
        amd7000Remove = new javax.swing.JButton();
        amd7000Update = new javax.swing.JButton();
        nvidia30 = new javax.swing.JButton();
        nvidia40 = new javax.swing.JButton();
        amd6000 = new javax.swing.JButton();
        amd7000 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftPanel.setForeground(new java.awt.Color(255, 255, 255));

        homeButton.setText("Home");
        homeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        stockButton.setText("View Stock");
        stockButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add/Remove");
        addButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("    Chan's");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(homeButton)
                .addGap(103, 103, 103)
                .addComponent(stockButton)
                .addGap(103, 103, 103)
                .addComponent(addButton)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 800));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventory Management System");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome to Chan's Inventory Management System!");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("This System is used for managing GPU's ranging from NVIDIA and AMD ");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Peter\\Pictures\\GPU\\amd2.png")); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(810, 456));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Peter\\Pictures\\GPU\\nvidia3.jpg")); // NOI18N

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Please use the left hand bar to navigate through the GUI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(486, 486, 486)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jLabel9)))
                .addContainerGap(444, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel8)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(79, 79, 79)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock");

        NVIDIA30button.setText("NVIDIA 30 series");
        NVIDIA30button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NVIDIA30buttonActionPerformed(evt);
            }
        });

        NVIDIA40button.setText("NVIDIA 40 series");
        NVIDIA40button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NVIDIA40buttonActionPerformed(evt);
            }
        });

        AMD6000button.setText("AMD 6000 series");
        AMD6000button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AMD6000buttonActionPerformed(evt);
            }
        });

        AMD7000button.setText("AMD 7000 series");
        AMD7000button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AMD7000buttonActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("NVIDIA 30 series stock ");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Stock", "Price", "Memory", "ClockSpeed", "NumCores"
            }
        ));
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1270, 490));

        jTabbedPane7.addTab("tab1", jPanel4);

        jLabel11.setText("NVIDIA 40 series stock ");

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setRowHeight(60);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(563, 563, 563)
                .addComponent(jLabel11)
                .addContainerGap(588, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("tab2", jPanel5);

        jLabel12.setText("AMD 6000 series stock");

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setRowHeight(40);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(571, 571, 571)
                .addComponent(jLabel12)
                .addContainerGap(582, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("tab3", jPanel6);

        jLabel13.setText("AMD 7000 series stock");

        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setRowHeight(60);
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(566, 566, 566)
                .addComponent(jLabel13)
                .addContainerGap(587, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("tab4", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(NVIDIA30button)
                .addGap(144, 144, 144)
                .addComponent(NVIDIA40button)
                .addGap(230, 230, 230)
                .addComponent(AMD6000button)
                .addGap(132, 132, 132)
                .addComponent(AMD7000button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NVIDIA30button)
                    .addComponent(NVIDIA40button)
                    .addComponent(AMD6000button)
                    .addComponent(AMD7000button))
                .addGap(75, 75, 75)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        jTabbedPane2.addTab("tab2", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add / Remove");

        jLabel14.setText("NVIDIA 30 series ");

        nvidia30Name.setText("Name:");

        nvidia30Stock.setText("Stock:");

        nvidia30Price.setText("Price:");

        nvidia30PMemory.setText("Memory:");

        nvidia30ClockSpeed.setText("Clock Speed:");

        nvidia30NumCores.setText("Number of Cores:");

        add30Button.setText("Add");
        add30Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add30ButtonActionPerformed(evt);
            }
        });

        remove30Button.setText("Remove");
        remove30Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove30ButtonActionPerformed(evt);
            }
        });

        update30Button.setText("Update");
        update30Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update30ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(588, 588, 588)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(596, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nvidia30ClockSpeed)
                                .addComponent(nvidia30NumCores))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clockSpeed30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numCores30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(nvidia30Name)
                                        .addGap(93, 93, 93))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(nvidia30Stock)
                                        .addGap(96, 96, 96)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(nvidia30PMemory)
                                    .addGap(80, 80, 80)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(memory30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stock30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(name30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(price30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(add30Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(remove30Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(update30Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nvidia30Price))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(63, 63, 63)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nvidia30Name))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nvidia30Stock))
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia30Price)
                    .addComponent(price30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia30PMemory)
                    .addComponent(memory30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia30ClockSpeed)
                    .addComponent(clockSpeed30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia30NumCores)
                    .addComponent(numCores30TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove30Button)
                    .addComponent(update30Button)
                    .addComponent(add30Button))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel8);

        jLabel15.setText("NVIDIA 40 Series");

        nvidia40Name.setText("Name:");

        nvidia40Stock.setText("Stock:");

        nvidia40Price.setText("Price:");

        nvidia40Memory.setText("Memory:");

        nvidia40clockSpeed.setText("Clock Speed:");

        nvidia40NumCores.setText("Number of Cores:");

        stock40TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock40TextFieldActionPerformed(evt);
            }
        });

        add40Button.setText("Add");
        add40Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add40ButtonActionPerformed(evt);
            }
        });

        remove40Button.setText("Remove");
        remove40Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove40ButtonActionPerformed(evt);
            }
        });

        update40Button.setText("Update");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nvidia40Stock)
                    .addComponent(nvidia40Name)
                    .addComponent(nvidia40Price)
                    .addComponent(nvidia40Memory)
                    .addComponent(nvidia40clockSpeed)
                    .addComponent(nvidia40NumCores))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clockSpeed40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numCores40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memory40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(add40Button)
                .addGap(116, 116, 116)
                .addComponent(remove40Button)
                .addGap(89, 89, 89)
                .addComponent(update40Button)
                .addGap(454, 454, 454))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40Name)
                    .addComponent(name40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40Stock)
                    .addComponent(stock40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40Price)
                    .addComponent(price40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40Memory)
                    .addComponent(memory40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40clockSpeed)
                    .addComponent(clockSpeed40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia40NumCores)
                    .addComponent(numCores40TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update40Button)
                    .addComponent(add40Button)
                    .addComponent(remove40Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel9);

        jLabel16.setText("AMD 6000 Series");

        amd6000Name.setText("Name:");

        amd6000Stock.setText("Stock:");

        amd6000Price.setText("Price:");

        amd6000Memory.setText("Memory:");

        amd6000ClockSpeed.setText("Clock Speed:");

        amd6000NumCores.setText("Number of Cores:");

        amd6000StockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd6000StockTextFieldActionPerformed(evt);
            }
        });

        amd6000Add.setText("Add");
        amd6000Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd6000AddActionPerformed(evt);
            }
        });

        amd6000Remove.setText("Remove");
        amd6000Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd6000RemoveActionPerformed(evt);
            }
        });

        amd6000Update.setText("Update");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amd6000Add)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(amd6000Stock)
                                .addComponent(amd6000Name)
                                .addComponent(amd6000Memory)
                                .addComponent(amd6000ClockSpeed)
                                .addComponent(amd6000NumCores)
                                .addComponent(amd6000Price)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(amd6000Remove)
                                .addGap(95, 95, 95)
                                .addComponent(amd6000Update))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amd6000StockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amd6000NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amd6000PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amd6000MemoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amd6000ClockSpeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amd6000NumCoresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(587, 587, 587)
                        .addComponent(jLabel16)))
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel16)
                .addGap(77, 77, 77)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000Name)
                    .addComponent(amd6000NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(amd6000Stock)
                    .addComponent(amd6000StockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000Price)
                    .addComponent(amd6000PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000Memory)
                    .addComponent(amd6000MemoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000ClockSpeed)
                    .addComponent(amd6000ClockSpeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000NumCores)
                    .addComponent(amd6000NumCoresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd6000Add)
                    .addComponent(amd6000Remove)
                    .addComponent(amd6000Update))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel10);

        jLabel17.setText("AMD 7000 Series");

        amd7000Name.setText("Name:");

        amd7000Stock.setText("Stock:");

        amd7000Price.setText("Price:");

        amd7000Memory.setText("Memory:");

        amd7000ClockSpeed.setText("Clock Speed:");

        amd7000NumCores.setText("Number of Cores:");

        amd7000ClockSpeedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd7000ClockSpeedTextFieldActionPerformed(evt);
            }
        });

        amd7000NumCoresTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd7000NumCoresTextFieldActionPerformed(evt);
            }
        });

        amd7000Add.setText("Add");
        amd7000Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd7000AddActionPerformed(evt);
            }
        });

        amd7000Remove.setText("Remove");
        amd7000Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd7000RemoveActionPerformed(evt);
            }
        });

        amd7000Update.setText("Update");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(591, 591, 591))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(amd7000Add)
                        .addGap(110, 110, 110)
                        .addComponent(amd7000Remove)
                        .addGap(110, 110, 110)
                        .addComponent(amd7000Update))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amd7000Name)
                            .addComponent(amd7000Stock)
                            .addComponent(amd7000Price)
                            .addComponent(amd7000Memory)
                            .addComponent(amd7000ClockSpeed)
                            .addComponent(amd7000NumCores))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amd7000NameTextField)
                            .addComponent(amd7000StockTextField)
                            .addComponent(amd7000PriceTextField)
                            .addComponent(amd7000MemoryTextField)
                            .addComponent(amd7000ClockSpeedTextField)
                            .addComponent(amd7000NumCoresTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel17)
                .addGap(47, 47, 47)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000Name)
                    .addComponent(amd7000NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000Stock)
                    .addComponent(amd7000StockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000Price)
                    .addComponent(amd7000PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000Memory)
                    .addComponent(amd7000MemoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000ClockSpeed)
                    .addComponent(amd7000ClockSpeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000NumCores)
                    .addComponent(amd7000NumCoresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amd7000Add)
                    .addComponent(amd7000Remove)
                    .addComponent(amd7000Update))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel11);

        nvidia30.setText("NVIDIA 30 Series");
        nvidia30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvidia30ActionPerformed(evt);
            }
        });

        nvidia40.setText("NVIDIA 40 Series");
        nvidia40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvidia40ActionPerformed(evt);
            }
        });

        amd6000.setText("AMD 6000 Series");
        amd6000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd6000ActionPerformed(evt);
            }
        });

        amd7000.setText("AMD 7000 Series");
        amd7000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amd7000ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(554, 554, 554))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(nvidia30)
                .addGap(118, 118, 118)
                .addComponent(nvidia40)
                .addGap(166, 166, 166)
                .addComponent(amd6000)
                .addGap(110, 110, 110)
                .addComponent(amd7000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvidia30)
                    .addComponent(nvidia40)
                    .addComponent(amd6000)
                    .addComponent(amd7000))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("tab3", jPanel3);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -40, 1270, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void stockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_stockButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_addButtonActionPerformed

    private void NVIDIA30buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NVIDIA30buttonActionPerformed
        // TODO add your handling code here:
        jTabbedPane7.setSelectedIndex(0);
        //dataBase();
    }//GEN-LAST:event_NVIDIA30buttonActionPerformed

    private void NVIDIA40buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NVIDIA40buttonActionPerformed
        // TODO add your handling code here:
        jTabbedPane7.setSelectedIndex(1);
    }//GEN-LAST:event_NVIDIA40buttonActionPerformed

    private void AMD6000buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AMD6000buttonActionPerformed
        // TODO add your handling code here:
        jTabbedPane7.setSelectedIndex(2);
    }//GEN-LAST:event_AMD6000buttonActionPerformed

    private void AMD7000buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AMD7000buttonActionPerformed
        // TODO add your handling code here:
        jTabbedPane7.setSelectedIndex(3);
    }//GEN-LAST:event_AMD7000buttonActionPerformed

    private void nvidia30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvidia30ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_nvidia30ActionPerformed

    private void nvidia40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvidia40ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_nvidia40ActionPerformed

    private void amd6000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd6000ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_amd6000ActionPerformed

    private void amd7000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd7000ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_amd7000ActionPerformed

    private void stock40TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock40TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stock40TextFieldActionPerformed

    private void add40ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add40ButtonActionPerformed
        // TODO add your handling code here:
         String name = name40TextField.getText();
        int stock = Integer.parseInt(stock40TextField.getText());
        double price = Double.parseDouble(price40TextField.getText());
        int memory = Integer.parseInt(memory40TextField.getText());
        double clockSpeed = Double.parseDouble(clockSpeed40TextField.getText());
        int numCores = Integer.parseInt(numCores40TextField.getText());
        
        nvidia40Add(name, stock, price, memory, clockSpeed, numCores);      
        
        Nvidia40dataBase();
    }//GEN-LAST:event_add40ButtonActionPerformed

    private void remove40ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove40ButtonActionPerformed
        // TODO add your handling code here:
        String name = name40TextField.getText();
        
        nvidia40Remove(name);
    }//GEN-LAST:event_remove40ButtonActionPerformed

    private void remove30ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove30ButtonActionPerformed
        // TODO add your handling code here:
        String name = name30TextField.getText();

        nvidia30Remove(name);
    }//GEN-LAST:event_remove30ButtonActionPerformed

    private void add30ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add30ButtonActionPerformed
        // TODO add your handling code here:
        String name = name30TextField.getText();
        int stock = Integer.parseInt(stock30TextField.getText());
        double price = Double.parseDouble(price30TextField.getText());
        int memory = Integer.parseInt(memory30TextField.getText());
        double clockSpeed = Double.parseDouble(clockSpeed30TextField.getText());
        int numCores = Integer.parseInt(numCores30TextField.getText());

        nvidia30Add(name, stock, price, memory, clockSpeed, numCores);

        Nvidia30dataBase();
    }//GEN-LAST:event_add30ButtonActionPerformed

    private void amd6000StockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd6000StockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amd6000StockTextFieldActionPerformed

    private void amd7000ClockSpeedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd7000ClockSpeedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amd7000ClockSpeedTextFieldActionPerformed

    private void amd7000NumCoresTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd7000NumCoresTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amd7000NumCoresTextFieldActionPerformed

    private void amd6000AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd6000AddActionPerformed
        // TODO add your handling code here:
        String name = amd6000NameTextField.getText();
        int stock = Integer.parseInt(amd6000StockTextField.getText());
        double price = Double.parseDouble(amd6000PriceTextField.getText());
        int memory = Integer.parseInt(amd6000MemoryTextField.getText());
        double clockSpeed = Double.parseDouble(amd6000ClockSpeedTextField.getText());
        int numCores = Integer.parseInt(amd6000NumCoresTextField.getText());

        amd6000Add(name, stock, price, memory, clockSpeed, numCores);

        Amd6000dataBase();
    }//GEN-LAST:event_amd6000AddActionPerformed

    private void amd6000RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd6000RemoveActionPerformed
        // TODO add your handling code here:
        String name = amd6000NameTextField.getText();        
        amd6000Remove(name);
    }//GEN-LAST:event_amd6000RemoveActionPerformed

    private void amd7000AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd7000AddActionPerformed
        // TODO add your handling code here:
        String name = amd7000NameTextField.getText();
        int stock = Integer.parseInt(amd7000StockTextField.getText());
        double price = Double.parseDouble(amd7000PriceTextField.getText());
        int memory = Integer.parseInt(amd7000MemoryTextField.getText());
        double clockSpeed = Double.parseDouble(amd7000ClockSpeedTextField.getText());
        int numCores = Integer.parseInt(amd7000NumCoresTextField.getText());

        amd7000Add(name, stock, price, memory, clockSpeed, numCores);

        Amd7000dataBase();
    }//GEN-LAST:event_amd7000AddActionPerformed

    private void amd7000RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amd7000RemoveActionPerformed
        // TODO add your handling code here:
        String name = amd7000NameTextField.getText();        
        amd7000Remove(name);
    }//GEN-LAST:event_amd7000RemoveActionPerformed

    private void update30ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update30ButtonActionPerformed
        // TODO add your handling code here:
        String name = name30TextField.getText();
        String fieldName = fieldNameTextField.
       
        
        nvidia30Update(name, fieldName, fieldValue);
        
        Nvidia30dataBase();
    }//GEN-LAST:event_update30ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inventoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventoryMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AMD6000button;
    private javax.swing.JButton AMD7000button;
    private javax.swing.JButton NVIDIA30button;
    private javax.swing.JButton NVIDIA40button;
    private javax.swing.JButton add30Button;
    private javax.swing.JButton add40Button;
    private javax.swing.JButton addButton;
    private javax.swing.JButton amd6000;
    private javax.swing.JButton amd6000Add;
    private javax.swing.JLabel amd6000ClockSpeed;
    private javax.swing.JTextField amd6000ClockSpeedTextField;
    private javax.swing.JLabel amd6000Memory;
    private javax.swing.JTextField amd6000MemoryTextField;
    private javax.swing.JLabel amd6000Name;
    private javax.swing.JTextField amd6000NameTextField;
    private javax.swing.JLabel amd6000NumCores;
    private javax.swing.JTextField amd6000NumCoresTextField;
    private javax.swing.JLabel amd6000Price;
    private javax.swing.JTextField amd6000PriceTextField;
    private javax.swing.JButton amd6000Remove;
    private javax.swing.JLabel amd6000Stock;
    private javax.swing.JTextField amd6000StockTextField;
    private javax.swing.JButton amd6000Update;
    private javax.swing.JButton amd7000;
    private javax.swing.JButton amd7000Add;
    private javax.swing.JLabel amd7000ClockSpeed;
    private javax.swing.JTextField amd7000ClockSpeedTextField;
    private javax.swing.JLabel amd7000Memory;
    private javax.swing.JTextField amd7000MemoryTextField;
    private javax.swing.JLabel amd7000Name;
    private javax.swing.JTextField amd7000NameTextField;
    private javax.swing.JLabel amd7000NumCores;
    private javax.swing.JTextField amd7000NumCoresTextField;
    private javax.swing.JLabel amd7000Price;
    private javax.swing.JTextField amd7000PriceTextField;
    private javax.swing.JButton amd7000Remove;
    private javax.swing.JLabel amd7000Stock;
    private javax.swing.JTextField amd7000StockTextField;
    private javax.swing.JButton amd7000Update;
    private javax.swing.JTextField clockSpeed30TextField;
    private javax.swing.JTextField clockSpeed40TextField;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTextField memory30TextField;
    private javax.swing.JTextField memory40TextField;
    private javax.swing.JTextField name30TextField;
    private javax.swing.JTextField name40TextField;
    private javax.swing.JTextField numCores30TextField;
    private javax.swing.JTextField numCores40TextField;
    private javax.swing.JButton nvidia30;
    private javax.swing.JLabel nvidia30ClockSpeed;
    private javax.swing.JLabel nvidia30Name;
    private javax.swing.JLabel nvidia30NumCores;
    private javax.swing.JLabel nvidia30PMemory;
    private javax.swing.JLabel nvidia30Price;
    private javax.swing.JLabel nvidia30Stock;
    private javax.swing.JButton nvidia40;
    private javax.swing.JLabel nvidia40Memory;
    private javax.swing.JLabel nvidia40Name;
    private javax.swing.JLabel nvidia40NumCores;
    private javax.swing.JLabel nvidia40Price;
    private javax.swing.JLabel nvidia40Stock;
    private javax.swing.JLabel nvidia40clockSpeed;
    private javax.swing.JTextField price30TextField;
    private javax.swing.JTextField price40TextField;
    private javax.swing.JButton remove30Button;
    private javax.swing.JButton remove40Button;
    private javax.swing.JTextField stock30TextField;
    private javax.swing.JTextField stock40TextField;
    private javax.swing.JButton stockButton;
    private javax.swing.JButton update30Button;
    private javax.swing.JButton update40Button;
    // End of variables declaration//GEN-END:variables
}