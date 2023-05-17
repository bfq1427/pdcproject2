package pdcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527//GPU_Database;","pdc","pdc");
            
            Statement st = conn.createStatement();
            
            String sql = "SELECT * FROM NVIDIA30SERIES";
            
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
                
                String tbData[] = {name, stock, price, memory, clockSpeed, numCores};

                model.addRow(tbData);                
            }
            conn.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Nvidia40dataBase(){
        
         try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527//GPU_Database;","pdc","pdc");
            
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
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527//GPU_Database;","pdc","pdc");
            
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
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527//GPU_Database;", "pdc", "pdc");

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
                .addContainerGap(407, Short.MAX_VALUE))
        );

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 787));

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
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jLabel9)))
                .addContainerGap(80, Short.MAX_VALUE))
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
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(217, Short.MAX_VALUE))
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

        jLabel10.setText("NVIDIA 30 series stock ");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(566, 566, 566)
                .addComponent(jLabel10)
                .addContainerGap(585, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("tab4", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(NVIDIA30button)
                        .addGap(61, 61, 61)
                        .addComponent(NVIDIA40button)
                        .addGap(94, 94, 94)
                        .addComponent(AMD6000button)
                        .addGap(48, 48, 48)
                        .addComponent(AMD7000button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane7)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NVIDIA30button)
                    .addComponent(NVIDIA40button)
                    .addComponent(AMD6000button)
                    .addComponent(AMD7000button))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add / Remove");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(538, 538, 538)
                .addComponent(jLabel2)
                .addContainerGap(576, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(718, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel3);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 1270, 790));

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
    private javax.swing.JButton addButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton stockButton;
    // End of variables declaration//GEN-END:variables
}
