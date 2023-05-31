package pdcproject2;

import javax.swing.JFrame;

/**
 *
 * @author Peter
 */
public class GUI {
    
    
    public static void main(String[] args) {
        JFrame frame1 = new loginMenu();
        frame1.setTitle("Inventory System Manager");
        frame1.setLocation(900,300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);        
    }
}
