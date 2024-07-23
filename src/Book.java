
public class Book extends Item {
    private String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author, ItemType.BOOK);
        this.isbn = isbn;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}
