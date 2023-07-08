
package stage3;

import java.util.ArrayList;
import java.util.List;

public class Plant implements PlantComponent {


    private int price;
    private String name;
    private List<PlantComponent> children = new ArrayList<>();
    
    //constructor
    public Plant(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(PlantComponent plant) {
        children.add(plant);
    }

    public void remove(PlantComponent plant) {
        children.remove(plant);
    }

    public PlantComponent getChild(int i) {
        return children.get(i);
    }
}