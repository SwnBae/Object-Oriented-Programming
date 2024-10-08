import java.util.ArrayList;

public class ShoppingMall {
    private ArrayList<Item> items;

    public ShoppingMall() {
        items = new ArrayList<Item>();
    }

    public void add(Item item) {
        Item i = item;
        i.setNumber(items.size() + 1);
        items.add(i);
    }

    public Item fintItem(String name) {
        for (Item i : items) {
            if (name.equals(i.getName())) {
                return i;
            }
        }
        return null;
    }

    public void printItemsInPriceRange(int price1, int price2) {
        String s = "";
        boolean isin = false;
        for (Item i : items) {
            if (i.getPrice() >= price1 && i.getPrice() < price2) {
                s += i;
                isin = true;
            }
        }
        if (isin == false) {
            System.out.println("없음");
        } else {
            System.out.println(s);
        }
    }

    public void printItemsInCategory(String category) {
        String s = "";
        boolean isin = false;
        for (Item i : items) {
            if (category.equals(i.getCategory())) {
                s += i;
                isin = true;
            }
        }
        if (isin == false) {
            System.out.println("없음");
        } else {
            System.out.println(s);
        }
    }

    public void printItemsDependsOnStockStatus(boolean inStock) {
        String s = "";
        for (Item i : items) {
            if (inStock == i.isInStock()) {
                s += i;
            }
        }
        System.out.println(s);
    }

    public void printItemsWithinNumRange(int num1, int num2) {
        String s = "";
        boolean isin = false;
        for (Item i : items) {
            if (i.getNumber() >= num1 && i.getNumber() <= num2) {
                s += i;
                isin = true;
            }
        }
        if (isin == false) {
            System.out.println("없음");
        } else {
            System.out.println(s);
        }
    }

}
