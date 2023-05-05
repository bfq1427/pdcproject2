package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

import java.util.InputMismatchException;
import java.util.Scanner;

//Class that utilises FileHandler to interact with the use to Remove gpus from specific files 
public class Remove {

    private final FileHandler fileHandler;

    public Remove() {
        fileHandler = new FileHandler("GPU_Management.txt");
    }

    public void removeGPUs() {

        Scanner scanner = new Scanner(System.in);

        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.println("Enter 1 for NVIDIA cards");
                System.out.println("Enter 2 for AMD cards");
                System.out.println("Enter 0 to go back to the main menu");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        {
                            System.out.println("Enter 1 for NVIDIA 30 series");
                            System.out.println("Enter 2 for NVIDIA 40 series");
                            int selection = scanner.nextInt();
                            if (selection == 1) {
                                System.out.println("Enter the name of the NVIDIA 30 series GPU to remove");
                                String gpuName = scanner.next();
                                fileHandler.removeGPUFromFile("NVIDIA30Series.txt", gpuName);
                            } else if (selection == 2) {
                                System.out.println("Enter the name of the NVIDIA 40 series GPU to remove");
                                String gpuName = scanner.next();
                                fileHandler.removeGPUFromFile("NVIDIA40Series.txt", gpuName);
                            }       break;
                        }
                    case 2:
                        {
                            System.out.println("Enter 1 for AMD 6000 series");
                            System.out.println("Enter 2 for AMD 7000 series");
                            int selection = scanner.nextInt();
                            if (selection == 1) {
                                System.out.println("Enter the name of the AMD 6000 series GPU to remove");
                                String gpuName = scanner.next();
                                fileHandler.removeGPUFromFile("AMD6000Series.txt", gpuName);
                            } else if (selection == 2) {
                                System.out.println("Enter the name of the AMD 7000 series GPU to remove");
                                String gpuName = scanner.next();
                                fileHandler.removeGPUFromFile("AMD7000Series.txt", gpuName);
                            }       break;
                        }
                    case 0:
                        invalidInput = false; 
                        break;
                    default:
                        System.out.println("Invalid input!\nPlease try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Input!\nPlease try again!");
                scanner.next();
            }
        }
    }
}
