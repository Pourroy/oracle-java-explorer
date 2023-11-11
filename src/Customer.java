public class Customer {
    private String name;
    private String address;
    private String size;
    private Clothing[] items;


    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }


    public void addItems(Clothing[] someItems) {
        items = someItems;
    }

    public Clothing[] getItems() {
        return items;
    }

    public double getTotalClothingCoast() {
        double total = 0.0;
        for(Clothing item: items) {
            total = total + item.getPrice();

        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1: case 2: case 3:
                setSize("S");
                break;
            case 4: case 5:
                setSize("M");
                break;
            case 6: case 7: case 8:
                setSize("L");
                break;
            case 9:
                setSize("X");
                break;
            default:
                setSize("XL");
        }
    }
}
