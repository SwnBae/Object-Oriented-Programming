public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String name, int price, boolean inStock, String author, String isbn) {
        super(name, price, "Book", inStock);
        this.author = author;
        this.isbn = isbn;
    }

    public String getDescription() {
        return "Author: " + author + "\nISBN: " + isbn + "\n";
    }
}
