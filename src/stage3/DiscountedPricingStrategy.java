
package stage3;

public class DiscountedPricingStrategy implements PricingStrategy {
    private float discountPercentage;

    public DiscountedPricingStrategy(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float calculatePrice(Order order) {
        int quantity = order.getQuantityChoice();
        float price = order.getPrice();
        float totalPrice = quantity * price;
        float discountAmount = totalPrice * (discountPercentage / 100);
        return totalPrice - discountAmount;
    }
}

