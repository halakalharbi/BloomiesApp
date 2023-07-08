
package stage3;

public interface PlantComponent {
    int getPrice();
    String getName();
    void add(PlantComponent plant);
    public void remove(PlantComponent plant);
    public PlantComponent getChild(int i);
}
