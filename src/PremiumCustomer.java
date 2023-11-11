public class PremiumCustomer extends Customer {
    double premiumDiscount = 0.2;
    public PremiumCustomer(String name, int measurement) {
        super(name, measurement);
    }

    public double getTotalClothingCoast() {
        return super.getTotalClothingCoast() - (super.getTotalClothingCoast() * premiumDiscount);
    }
}
