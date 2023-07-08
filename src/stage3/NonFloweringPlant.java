package stage3;
import java.util.ArrayList;
import java.util.HashMap;

public class NonFloweringPlant extends Plant {
  ArrayList<String> plant;
    private int quantity;
    private String type;
    private HashMap<String, Integer> plantPrices;
    

    //constructor
  public NonFloweringPlant(int price, String plantName){
        super(price, plantName);
        this.quantity = quantity;
        this.type = type;
       
        plant = new ArrayList<String>();
        plant.add("Ferns");
        plant.add("Mosses");
        plant.add("Conifers");

        plantPrices = new HashMap<String, Integer>();
        plantPrices.put("Ferns", 15);
        plantPrices.put("Mosses", 10);
        plantPrices.put("Conifers", 10);
    }

   
     // getters and setters
   
    public int getPriceForPlant(String plantName) {
        return plantPrices.getOrDefault(plantName, 0);
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   
     public ArrayList<String> getPlant() {
        return plant;
    }
   
    public void setPlant(ArrayList<String> plant) {
        this.plant = plant;
    }

@Override
    public String getName() {
        return type;
    }
}