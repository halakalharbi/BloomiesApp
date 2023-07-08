package stage3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


    public class FloweringPlant extends Plant {
     ArrayList<String> flower;
    private int quantity;
    private String type;
    private HashMap<String, Integer> flowerPrices;
    
    //constructor
    FloweringPlant(int price, String plantName) {
        super(price, plantName);
        this.quantity = quantity;
        this.type = type;
        flower = new ArrayList<String>();
        flower.add("Rose");
        flower.add("Lily");
        flower.add("Daisy");

        flowerPrices = new HashMap<String, Integer>();
        flowerPrices.put("Rose", 10);
        flowerPrices.put("Lily", 10);
        flowerPrices.put("Daisy", 10);
    }
     // getters and setters
       public int getPriceForPlant(String plantName) {
        return flowerPrices.getOrDefault(plantName, 0);
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
   
    public ArrayList<String> getFlower() {
        return flower;
    }
   
    public void setFlower(ArrayList<String> flower) {
        this.flower = flower;
    }

    @Override
    public String getName() {
        return type;
    }
}