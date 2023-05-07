package pdcproject2;

import javax.swing.JFrame;

/**
 *
 * @author Peter
 */
public class GUI {
    
    
    public static void main(String[] args) {
        
        //JFrame f = new JFrame("Inventory System Manager");
        
        JFrame frame = new loginMenu();
        frame.setTitle("Inventory System Manager");
        frame.setLocation(900,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
    
}
