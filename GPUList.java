package pdcproject2;

/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 * 09/06/2023
 */


import java.util.ArrayList;

//GPUList holds the gpus in an array
public class GPUList {
    
    private ArrayList<GPU> gpuList;
    
    public GPUList() {  
        
        gpuList = new ArrayList<>();        
    }
    
    public void addGPU(GPU gpu)
    {
        gpuList.add(gpu);
    }
    
    public void removeGPU(GPU gpu)
    {
        gpuList.remove(gpu);
    }
    //get gpus per line as lines
    public ArrayList<String> getGPUsAsLines(){
        ArrayList<String> lines = new ArrayList<>();
        
        for(GPU gpu : gpuList)
        {
            lines.add(gpu.getName() + ", " + gpu.getStock() + ", " + gpu.getPrice() + ", " + gpu.getMemory() + ", " + gpu.getClockSpeed() + ", " + gpu.getNumCores());
        }
        return lines;
    }    
    //method to get gpus if in array
    public ArrayList<String> getGPU(String name)
    {
        ArrayList<String> matchingGPU = new ArrayList<>();
        for(GPU gpu: gpuList)
        {
            if(gpu.getName().equals(name))
            {
                matchingGPU.add(gpu.getName());
            }
        }
        return matchingGPU.isEmpty() ? null : matchingGPU;
    }
    
    public ArrayList<GPU> getAllGPUs(){
        return gpuList;
    }

}
