package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryManagement {
    
 
    public void run() {
        
        Scanner scanner = new Scanner(System.in);
        
        Add gpu1 = new Add();
        Remove gpu2 = new Remove();
        View gpu3 = new View();

        while (true) {
            
            System.out.println("                 ===============================================");
            System.out.println("               ||***********************************************||");
            System.out.println("               ||*    #####################################    *||");
            System.out.println("               ||*     Chan's Video Cards Management System    *||");
            System.out.println("               ||*    #####################################    *||");
            System.out.println("               ||***********************************************||");
            System.out.println("                 ===============================================");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println(" This System Manages all current Graphical Video Cards ranging from NVIDIA and AMD ");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("                 Enter 1 to add a GPU    ||  Enter 3 to view GPUs  ");
            System.out.println("                 Enter 2 to remove a GPU ||  Enter 4 to exit");

            int choice;
            
            try{
                choice = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("------------------------------------------------------------");
                System.out.println("Invalid choice! \nPlease input correct number for selection!");
                System.out.println("------------------------------------------------------------");
                scanner.next();
                continue;
            }
            
            switch (choice) 
            {                
                case 1:
                    gpu1.addGPU();
                    break;
                case 2:
                    gpu2.removeGPUs();
                    break;
                case 3:                      
                    gpu3.viewGPUs();
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    System.out.println("Now Exiting the Management System!");
                    System.out.println("----------------------------------");
                    System.exit(0);                             
                    break; 
                default:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Invalid choice! \nPlease input correct number for selection!");
                    System.out.println("------------------------------------------------------------");
                    break;
            }        
        }
    }

    public static void main(String[] args) {        
        InventoryManagement inventory = new InventoryManagement();
        inventory.run();      
    } 
}
