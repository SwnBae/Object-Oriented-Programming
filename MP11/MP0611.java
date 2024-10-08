public class MP0611 {
    public static void main(String[] args){
        BookManager bm = new BookManager();
        bm.add(new Book("A", "B", 1));
        bm.add(new Book("B", "C", 11));
        bm.add(new Book("C", "D", 111));
        bm.add(new EBook("D","E",1111,"F"));

        System.out.println(bm);
        System.out.println(bm.findTitle("A"));
        System.out.println(bm.findISBN(11));
        System.out.println(bm.findAuthor("E"));
    }
}
