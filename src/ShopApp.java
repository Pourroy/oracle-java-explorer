import java.sql.SQLOutput;
import java.util.Arrays;

public class ShopApp {

    public static void main(String[] args) {
        System.out.println("Welcome tho the Gansinho Vizinho Store");
        Customer c1 = new PremiumCustomer("Pinky", 14);
        System.out.println("Min price " + Clothing.MIN_PRICE);

        Clothing item1 = new Clothing("Blue Jacket",20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");

        Clothing[] items = {item1, item2, new Clothing("Green Scart", 5.0, "S"), new Clothing("Blue T-Shirt", 10.5, "S")};

        c1.addItems(items);

        System.out.println("Customer is: " + c1.getName() + ", " + "Size: " + c1.getSize() +  ", Total in $$: " + c1.getTotalClothingCoast());
        System.out.println("Items List: ");
        for (Clothing item: items) {
            System.out.println("Item " + ": " + item);
        }

        int average = 0;
        int count = 0;

        for (Clothing item: c1.getItems()){
            if (item.getSize().equals("L")) {
                count++;
                average += item.getPrice();
            }
        }
        try{
            average = (count == 0) ? 0 : average / count;
            System.out.println("Average price of each clothe is: $" + average + ", Clothes amount: " + count);
        } catch(ArithmeticException e) {
            System.out.println("Please, don't divide by zero!");
        }
        Arrays.sort(c1.getItems()); // sort by alphabetical order

        for (Clothing item: c1.getItems()) {
            System.out.println("Item " + ": " + item);
        }

        System.out.println("Thanks for visit our Shop"); // line will be executed independet of exeptions rises
    }
}
