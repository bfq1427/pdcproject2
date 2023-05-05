package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

import java.util.InputMismatchException;
import java.util.Scanner;

//Class that utilises FileHandler and GPUList to interact with the user to View the File elements/gpus
public class View {

    private final GPUList gpuCollection;
    private final FileHandler file;

    public View() {
        gpuCollection = new GPUList();
        file = new FileHandler("");
    }

    public void viewGPUs() {

        Scanner input = new Scanner(System.in);

        boolean invalidInput = true;

        while (invalidInput) {

            try {

                System.out.println("Enter 1 for Nvidia GPU's");
                System.out.println("Enter 2 for AMD GPU's");

                int choice = input.nextInt();
                String fileName = "";

                switch (choice) {
                    case 1: {
                        boolean invalidNvidiaInput = true;
                        while (invalidNvidiaInput) {

                            try {
                                System.out.println("Enter 1 for 30 series GPU's");
                                System.out.println("Enter 2 for 40 series GPU's");
                                int selection = input.nextInt();
                                switch (selection) {
                                    case 1:
                                        fileName = "NVIDIA30Series.txt";
                                        break;
                                    case 2:
                                        fileName = "NVIDIA40Series.txt";
                                        break;
                                    default:
                                        System.out.println("Invalid Selection.");
                                        break;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input!\nPlease try again!");
                                input.next();
                            }
                        }
                        break;
                    }
                    case 2: {
                        boolean invalidAmdInput = true;

                        while (invalidAmdInput) {

                            try {
                                System.out.println("Enter 1 for RX 6000 series GPU's");
                                System.out.println("Enter 2 for RX 7000 series GPU's");
                                int selection = input.nextInt();
                                switch (selection) {
                                    case 1:
                                        fileName = "AMD6000Series.txt";
                                        break;
                                    case 2:
                                        fileName = "AMD7000Series.txt";
                                        break;
                                    default:
                                        System.out.println("Invalid selection.");
                                        break;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input!\nPlease try again!");
                                input.next();
                            }
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid selection.");
                        return;
                }
                
                file.viewFile(fileName, gpuCollection);
                
                invalidInput = false;
               
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input!\nPlease try again!");
                input.next();
            }

        }

    }


}
