public interface Borrowable {
    void borrow(Reader reader) throws ItemAlreadyBorrowedException, ReaderNotFoundException;
    void returnBook(Reader reader) throws ItemNotBorrowedByReaderException;
}
