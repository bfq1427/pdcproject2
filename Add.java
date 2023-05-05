package pdcproject2;
/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

//Class that utilises FileHandler and GPU to interact with the user to Add gpus to the file 
public class Add {   

    private FileHandler fileHandler;
    private final ArrayList<GPU> gpuList = new ArrayList<>(); 
    
    public Add(){
        fileHandler = new FileHandler("");
    }
      
    public void addGPU() {

        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;

        while (!validInput) {

            try {

                System.out.println("Enter 1 to add Nvidia GPU's");
                System.out.println("Enter 2 to add AMD GPU's");

                int input = scanner.nextInt();

                switch (input) {
                    case 1: {
                        System.out.println("Enter 1 to add a 30 series GPU");
                        System.out.println("Enter 2 to add a 40 series GPU");
                            int selection = scanner.nextInt();
                            scanner.nextLine();
                            if (selection == 1) {                                
                                boolean addGPU = true;
                                do {
                                    try {                                        
                                        System.out.println("Enter GPU name:");
                                        String name = scanner.nextLine();
                                        
                                        System.out.println("Enter GPU stock:");
                                        int stock = scanner.nextInt();
                                        
                                        System.out.println("Enter GPU price:");
                                        double price = scanner.nextDouble();
                                        
                                        System.out.println("Enter Memory: ");
                                        int memory = scanner.nextInt();
                                        
                                        System.out.println("Enter Clock Speed: ");
                                        double clockSpeed = scanner.nextDouble();
                                        
                                        System.out.println("Enter Number of cores: ");
                                        int numCores = scanner.nextInt();
                                        
                                        GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores); 
                                        Collections.sort(gpuList);
             
                                        gpuList.add(gpu);

                                        String file = "NVIDIA30Series.txt";

                                        fileHandler.writeToFile(file, gpu);

                                        System.out.println("Do you want to add another GPU? Y/N");
                                        scanner.nextLine();
                                        String answer = scanner.nextLine();

                                        if (answer.equalsIgnoreCase("N")) {
                                            addGPU = false;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please try again.");
                                        scanner.nextLine();
                                    }
                                } while (addGPU);

                                System.out.println("GPU added successfully.");
                                
                            } else if (selection == 2) {                                
                                boolean addGPU = true;
                                do {
                                    try {
                                        
                                        System.out.println("Enter GPU name:");
                                        String name = scanner.nextLine();
                                        
                                        System.out.println("Enter GPU stock:");
                                        int stock = scanner.nextInt();
                                        
                                        System.out.println("Enter GPU price:");
                                        double price = scanner.nextDouble();
                                        
                                        System.out.println("Enter Memory: ");
                                        int memory = scanner.nextInt();
                                        
                                        System.out.println("Enter Clock Speed: ");
                                        double clockSpeed = scanner.nextDouble();
                                        
                                        System.out.println("Enter Number of cores: ");
                                        int numCores = scanner.nextInt();
                                        
                                        GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores); 
                                        Collections.sort(gpuList);
                                        gpuList.add(gpu);
                                        String file = "NVIDIA40Series.txt";                                        
                                        fileHandler.writeToFile(file, gpu);
           
                                        System.out.println("Do you want to add another GPU? Y/N");
                                        scanner.nextLine();
                                        String answer = scanner.nextLine();
                                        
                                        if (answer.equalsIgnoreCase("N")) {
                                            addGPU = false;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please try again.");
                                        scanner.nextLine();
                                    }
                                } while (addGPU);                        

                                System.out.println("GPU added successfully.");
                                validInput = true;                                
                            }       
                            break;
                        }
                    case 2:
                        {
                            System.out.println("Enter 1 to add a 6000 series GPU");
                            System.out.println("Enter 2 to add a 7000 series GPU");
                            int selection = scanner.nextInt();
                            scanner.nextLine();
                            if (selection == 1) {
                                boolean addGPU = true;
                                do {
                                    try {
                                        
                                        System.out.println("Enter GPU name:");
                                        String name = scanner.nextLine();
                                        
                                        System.out.println("Enter GPU stock:");
                                        int stock = scanner.nextInt();
                                        
                                        System.out.println("Enter GPU price:");
                                        double price = scanner.nextDouble();
                                        
                                        System.out.println("Enter Memory: ");
                                        int memory = scanner.nextInt();
                                        
                                        System.out.println("Enter Clock Speed: ");
                                        double clockSpeed = scanner.nextDouble();
                                        
                                        System.out.println("Enter Number of cores: ");
                                        int numCores = scanner.nextInt();
                                        
                                        GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                                        Collections.sort(gpuList);
                                        gpuList.add(gpu);
                                        String file = "AMD6000Series.txt";                                        
                                        fileHandler.writeToFile(file, gpu);
                                        
                                        System.out.println("Do you want to add another GPU? Y/N");
                                        scanner.nextLine();
                                        String answer = scanner.nextLine();
                                        
                                        if (answer.equalsIgnoreCase("N")) {
                                            addGPU = false;
                                        }
                                        
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please try again.");
                                        scanner.nextLine();
                                    }
                                } while (addGPU);
         
                                System.out.println("GPU added successfully.");
                                
                            } else if (selection == 2) {
                                boolean addGPU = true;
                                do {
                                    try {
                                        
                                        System.out.println("Enter GPU name:");
                                        String name = scanner.nextLine();
                                        
                                        System.out.println("Enter GPU stock:");
                                        int stock = scanner.nextInt();
                                        
                                        System.out.println("Enter GPU price:");
                                        double price = scanner.nextDouble();
                                        
                                        System.out.println("Enter Memory: ");
                                        int memory = scanner.nextInt();
                                        
                                        System.out.println("Enter Clock Speed: ");
                                        double clockSpeed = scanner.nextDouble();
                                        
                                        System.out.println("Enter Number of cores: ");
                                        int numCores = scanner.nextInt();
                                        
                                        GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                                        Collections.sort(gpuList);
                                        gpuList.add(gpu);
                                        String file = "AMD7000Series.txt";                                        
                                        fileHandler.writeToFile(file, gpu);
                                        
                                        System.out.println("Do you want to add another GPU? Y/N");
                                        scanner.nextLine();
                                        String answer = scanner.nextLine();
                                        
                                        if (answer.equalsIgnoreCase("N")) {
                                            addGPU = false;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please try again.");
                                        scanner.nextLine();
                                    }
                                } while (addGPU);
                                

                                System.out.println("GPU added successfully.");
                            }       break;
                        }
                    default:
                        System.out.println("Invalid input!\nPlease try again!");
                        scanner.nextLine();
                        continue;
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input!\nPlease try again");
                scanner.nextLine();
            }
        }
    }    
}
