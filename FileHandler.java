package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//class to manage the Files through input/output
public class FileHandler {
    
    private String filename;
    
    public FileHandler(String filename)
    {
        this.filename = filename;
    }
    //readFromFile reads the content of a file specified by the "filename" variable and returns the lines of the file as an ArrayList of strings.
    public ArrayList<String> readFromFile(){
        
        ArrayList<String> lines = new ArrayList<String>();
        
        try{
            
            File file = new File(filename);
            
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()){
                
                String line = scanner.nextLine();
                lines.add(line);                
            }
            scanner.close();            
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + filename);
        }
       return lines;
    }
    
    //this code writes to a file while taking in filename and gpu
    public void writeToFile(String filename, GPU gpu)
    {
        try (FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw)) {
            
           pw.println(gpu.getName()+", "+gpu.getStock()+", "+gpu.getPrice()+", "+gpu.getMemory()+", "+gpu.getClockSpeed()+", "+gpu.getNumCores());          
           
        } catch (IOException e) {
            System.out.println("Error adding GPU");
        }
    }   
    
    //this method removes gpus from file taking in the filename and GPU name specifically
    public void removeGPUFromFile(String fileName, String gpuName){
        
        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {                 
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Remove the GPU with the specified name
        boolean removed = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);                   
            if(line.toLowerCase().contains(gpuName.toLowerCase()))
            {
                lines.remove(i);
                removed = true;
                break;
            }      
        }

        // Write the updated contents back to the file
        if (removed) {            
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    writer.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return;
            }
            System.out.println("GPU removed successfully!");
        } 
        else 
        {
            System.out.println("GPU not found!\n");
        }

    }
    
    //this method views the file while taking in filename and gpuCollection to put into an array to print
    public void viewFile(String fileName, GPUList gpuCollection)
    {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);           

            System.out.println(" ---------------------------------------");
            System.out.println("| Showing all GPUs in " + fileName + " |");
            System.out.println(" ---------------------------------------");

            while (reader.hasNextLine()) {

                String data = reader.nextLine();
                String[] tokens = data.split(", ");

                String name = tokens[0];
                int stock = Integer.parseInt(tokens[1]);
                double price = Double.parseDouble(tokens[2]);
                int memory = Integer.parseInt(tokens[3]);
                double clockSpeed = Double.parseDouble(tokens[4]);
                int numCores = Integer.parseInt(tokens[5]);

                GPU gpu = new GPU(name, stock, price, memory, clockSpeed, numCores);
                             
                gpuCollection.addGPU(gpu);

                System.out.println("Name: " + name + "\nStock: " + stock + "\nPrice: $" + price + "\nMemory: " + memory + "GB\nClock Speed: " + clockSpeed + "GHz\nNumber of Cores: " + numCores);
                System.out.println("-----------------------");
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");

        } catch (InputMismatchException e) {
            System.out.println("Incorrect input!\nPlease try again!");            
        }

    }

}
