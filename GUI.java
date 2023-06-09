package pdcproject2;

import javax.swing.JFrame;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 * 09/06/2023
 */

//this class envokes the GUI and calls it to the user to interact with
public class GUI {    
    
    public static void main(String[] args) {
        JFrame frame1 = new loginMenu();
        frame1.setTitle("Inventory System Manager");
        frame1.setLocation(900,300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);        
    }
}
