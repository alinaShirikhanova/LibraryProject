public abstract class Item implements Borrowable {
    protected String title;
    protected String author;
    protected boolean isBorrowed;
    protected ItemType itemType;

    public Item(String title, String author, ItemType itemType) {
        this.title = title;
        this.author = author;
        this.itemType = itemType;
        this.isBorrowed = false;
    }

    public abstract void displayInfo();

    @Override
    public void borrow(Reader reader) throws ItemAlreadyBorrowedException, ReaderNotFoundException {
        if (isBorrowed) {
            throw new ItemAlreadyBorrowedException("Item is already borrowed.");
        }
        if (reader == null) {
            throw new ReaderNotFoundException("Reader not found.");
        }
        isBorrowed = true;
        System.out.println("Item borrowed by: " + reader.getName());
    }

    @Override
    public void returnBook(Reader reader) throws ItemNotBorrowedByReaderException {
        if (!isBorrowed) {
            throw new ItemNotBorrowedByReaderException("Item was not borrowed.");
        }
        isBorrowed = false;
        System.out.println("Item returned by: " + reader.getName());
    }

    public String getTitle() {
        return title;
    }

    public ItemType getItemType() {
        return itemType;
    }
}

