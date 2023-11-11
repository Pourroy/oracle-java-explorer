import java.lang.module.Configuration;
import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ShopApp {

    public static void main(String[] args) {
        System.out.println("Welcome tho the Gansinho Vizinho Store");
        Customer c1 = new PremiumCustomer("Pinky", 14);
        System.out.println("Min price " + Clothing.MIN_PRICE);

        Clothing item1 = new Clothing("Blue Jacket",20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Blue T-Shirt", 10.5, "S");
        Clothing item4 = new Clothing("Green Scart", 5.0, "S");
        Clothing[] items = {item1, item2, item3, item4};

        try {
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder().get("/items", list).build();
            ServerConfiguration configuration = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer webServer = WebServer.create(configuration, routing);
            webServer.start();
        } catch (UnknownHostException exception) {
            exception.printStackTrace();
        }


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
