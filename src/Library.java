

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Item> {
    private List<T> items;
    private List<Reader> readers;

    public Library() {
        this.items = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added: " + item.getTitle());
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
        System.out.println("Reader registered: " + reader.getName());
    }

    public T findItemByTitle(String title) throws ItemNotFoundException {
        for (T item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item with title " + title + " not found.");
    }

    public void borrowItem(String title, Reader reader) throws ItemNotFoundException, ReaderNotFoundException, ItemAlreadyBorrowedException {
        T item = findItemByTitle(title);
        item.borrow(reader);
    }

    public void returnItem(String title, Reader reader) throws ItemNotFoundException, ItemNotBorrowedByReaderException {
        T item = findItemByTitle(title);
        item.returnBook(reader);
    }
}