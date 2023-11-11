public class Clothing implements Comparable<Clothing> {
    String description;
    double price;
    String size;
    public final static double MIN_PRICE = 10.0;
    public final static double TAX_RATE = 0.2;

    public Clothing(String description, double price, String sSize) {
        this.description = description;
        setPrice(price);
        setSize(sSize);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price * (1 + TAX_RATE);
    }

    public void setPrice(double price) {
        this.price = Math.max(price, MIN_PRICE);
    }

    public void measure(int value) {
        this.size = (value < 10) ? "S" : "M";
    }

    public boolean fit(Customer customer) {
        return this.size.equals(customer.getSize());
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String newSize) {
        this.size = newSize;
    }

    @Override
    public int compareTo(Clothing clothingObject) {
        return this.description.compareTo(clothingObject.description);
    }

    @Override
    public String toString() {
        return getDescription() + ", " + getSize() + ", $" + getPrice();
    }
}
