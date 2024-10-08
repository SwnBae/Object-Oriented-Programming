import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        readFile n = new readFile("musiclist.txt");
        String musict = n.getS();
        ShoppingMall shop = new ShoppingMall();
        MusicCD cd = new MusicCD("배",10000,true,"배",musict);
        shop.add(cd);
        Book book = new Book("나",100900,true,"가","123베베");
        shop.add(book);
        System.out.println(cd);
        System.out.println(book);
        System.out.println(shop.fintItem("배"));
        shop.printItemsDependsOnStockStatus(true);
        shop.printItemsInCategory("MusicCD");
        shop.printItemsInPriceRange(9000,11000);
        shop.printItemsWithinNumRange(0,1);
    }
}