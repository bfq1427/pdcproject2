package pdcproject2;
/** *
 * @author Peter Chan
 * #20117970
 * COMP603/04a
 */


//abstract gpu class to hold initial values of name stock and price, with get and set methods
abstract class abstractGPU {
    
    protected String name;
    protected int stock;
    protected double price;
    
    public abstractGPU(String name, int stock, double price)
    {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }
  
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString()
    {
        return this.name+"/n"+this.stock+"/n"+this.price;
    }   
}
