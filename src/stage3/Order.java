package stage3;

import java.util.ArrayList;
import java.util.List;

public class Order {
   
    private String plantType;
    private String chosenPlant;
    private float price;
    private int quantityChoice;
    private String deliveryDate;
    private float totalPrice = 0;
    private PlantComponent plantComponent;

   // constractour for the PlantFactory 
    public Order(String plantType, String chosenPlant, int quantityChoice, float price, String deliveryDate, PlantFactory factory) {
        this.plantType = plantType;
        this.chosenPlant = chosenPlant;
        this.quantityChoice = quantityChoice;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.totalPrice = calcPrice(factory);
    }
   
    //constractour for the plantComponant
    public Order(PlantComponent plantComponent, int quantityChoice, String deliveryDate) {
        this.plantComponent = plantComponent;
        this.quantityChoice = quantityChoice;
        this.deliveryDate = deliveryDate;
    }

    //order construstor 
    public Order(String plantType, String chosenPlant, int quantityChoice, int plantPrice, String deliveryDate) {
    this.plantType = plantType;
    this.chosenPlant = chosenPlant;
    this.quantityChoice = quantityChoice;
    this.price = plantPrice;
    this.deliveryDate = deliveryDate;
    }

   
     public PlantComponent getPlantComponent() {
        return plantComponent;
    }
 
    public String getPlantType() {
        return plantType;
    }
   
    public String getChosenPlant() {
        return chosenPlant;
    }
   
    public float getPrice() {
        return price;
    }
   
    public int getQuantityChoice() {
        return quantityChoice;
    }
   
    public void setQuantityChoice(int quantityChoice ) {
        this.quantityChoice=quantityChoice;
    }
   
    public String getDeliveryDate() {
        return deliveryDate;
    }
   
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
   
    //for the plantFactory
    public float calcPrice(PlantFactory factory) {
        Plant plant = factory.createPlant((int) price, chosenPlant);
        float totalPrice = quantityChoice * plant.getPrice();
        return totalPrice;
    }
    
    
    public float getTotalPrice() {
    return totalPrice;
    }
   
    
    public float calcPrice2() {
        // calculate the total price for the bill based on the quantity and price of the plant
        float totalPrice = quantityChoice * price;
        return totalPrice;
    }
    
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
    
     private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public float calcPrice() {
        if (pricingStrategy == null) {
            throw new IllegalStateException("Pricing strategy is not set!");
        }
        return pricingStrategy.calculatePrice(this);
    }

    
    @Override
    public String toString() {
        return "Order Details: \n" +
                "Plant Type: " + plantType + "\n" +
                "Plant Name: " + chosenPlant + "\n" +
                "Price: $" + price + "\n" +
                "Quantity: " + quantityChoice+ "\n"+
                "Delivery Date: " + deliveryDate;
    }
}