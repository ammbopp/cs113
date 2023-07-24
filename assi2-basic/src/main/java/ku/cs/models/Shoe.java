package ku.cs.models;
public class Shoe {
    private String id;
    private String name;
    private double price; // Assume price is in USD
    private String size;

    // Constructor
    public Shoe(String id, String name, String size) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = 0;
    }

    // Getter methods
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPriceInUSD() {
        return price;
    }
    public String getSize() {
        return size;
    }
    // Method to convert price from USD to THB
    public double getPriceInTHB() {
        return price * 34;
    }

    public void addPrice(double price) {
        if (price > 0) {
            this.price += price;
        }
    }
    public boolean isId(String id) {
        return this.id.equals(id);
    }
    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' + '\'' +
                ", size: " + size +
                ", price: " + price +
                '}';
    }
}


