public abstract class Item {
    private static int count = 1;
    private String name;
    private int price;
    private int number;
    private String category;
    private boolean inStock;

    public Item(String name, int price, String category, boolean inStock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
    }

    public void setNumber(int num) {
        this.number = num;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPrice: " + price + "\nNumber: " +number+ "\nIn Stock: " + inStock + "\n" + getDescription();
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setStockStatus(boolean inStock) {
        this.inStock = inStock;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public abstract String getDescription();
}
