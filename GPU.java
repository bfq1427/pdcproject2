package pdcproject2;
/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */

//GPU extends abstractGPU to super name, stock and price. And Comparable to implement comparable methods 
//Also adding memory, clockSpeed and number of cores for GPUs.
public class GPU extends abstractGPU implements Comparable<GPU> {
    
    private int memory;
    private double clockSpeed;
    private int numCores;
    
    //Constructor for GPU
    public GPU(String name, int stock, double price, int memory, double clockSpeed, int numCores)
    {
        super(name, stock, price);
        this.memory = memory;
        this.clockSpeed = clockSpeed;
        this.numCores = numCores;
    }
    
    //compareTo method
    public int compareTo(GPU gpu)
    {
         if(this.price < gpu.price)
        {
            return -1;
        }
        else if(this.price > gpu.price)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }    
   //get and set methods
    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

   
    public double getClockSpeed() {
        return clockSpeed;
    }

   
    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

  
    public int getNumCores() {
        return numCores;
    }

   
    public void setNumCores(int numCores) {
        this.numCores = numCores;
    }   


    public String toString()
    {
        return "---------------------\n"+this.name + "\n" + this.stock + "\n$" + this.price + "\nMemory: "+ memory + "GB\nClock Speed: "+ clockSpeed + "GHz\nNumber of Cores: " + numCores + "\n---------------------";
    }      
}
