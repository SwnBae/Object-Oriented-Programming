class Book {
    String title;
    String author;
    int isbn;
    public Book(String title,String author,int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public int getIsbn() {
        return isbn;
    }
    @Override
    public String toString() {
        return title+", "+author+"," +isbn;
    }
}
