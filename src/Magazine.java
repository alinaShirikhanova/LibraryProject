
public class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
        super(title, author, ItemType.MAGAZINE);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine Title: " + title + ", Author: " + author + ", Issue No: " + issueNumber);
    }
}