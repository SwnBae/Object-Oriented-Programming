public class EBook extends Book{
    String bookstore;
    public EBook(String title,String author,int isbn,String bookstore){
        super(title,author,isbn);
        this.bookstore = bookstore;
    }

    @Override
    public String toString() {
        return title+", "+author+", "+isbn+", "+bookstore;
    }
}
