
package stage3;
    
public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public float calculatePrice(Order order) {
        int quantity = order.getQuantityChoice();
        float price = order.getPrice();
        return quantity * price;
    }
}
