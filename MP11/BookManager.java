import java.util.ArrayList;

public class BookManager {
    ArrayList<Book> books;
    public BookManager(){
        books = new ArrayList<Book>();
    }
    public void add(Book b){
        books.add(b);
    }
    public Book findTitle(String t){
        for(Book b : books){
            if(b.getTitle().equals(t)){
                return b;
            }
        }
        return null;
    }
    public Book findAuthor(String t){
        for (Book b: books){
            if(b.getAuthor().equals(t)){
                return b;
            }
        }
        return null;
    }
    public Book findISBN(int i){
        for (Book b:books){
            if(b.getIsbn() == i){
                return b;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        String s = "";
        for (Book b:books){
                s+=b+"\n";
        }
        return s;
    }
}
