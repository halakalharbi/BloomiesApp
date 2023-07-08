
package stage3;

public class NonFloweringPlantFactory extends PlantFactory {

    @Override
    public Plant createPlant(int price,String plantName) {
        return new NonFloweringPlant(price,plantName);
    }

}
