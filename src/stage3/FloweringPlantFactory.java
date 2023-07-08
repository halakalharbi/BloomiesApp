package stage3;

public class FloweringPlantFactory extends PlantFactory {

    @Override
    public Plant createPlant(int price, String plantName) {
        return new FloweringPlant(price, plantName);
    }

}