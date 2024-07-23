public class Main {
    public static void main(String[] args) {
        Library<Item> library = new Library<>();

        // Создание книг и журналов
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "978-0316769488");
        Magazine magazine1 = new Magazine("National Geographic", "Various", 202);

        // Добавление предметов в библиотеку
        library.addItem(book1);
        library.addItem(magazine1);

        // Регистрация читателей
        Reader reader1 = new Reader("Alice", "R001");
        Reader reader2 = new Reader("Bob", "R002");
        library.registerReader(reader1);
        library.registerReader(reader2);

        // Выдача и возврат книг
        try {
            library.borrowItem("The Catcher in the Rye", reader1);
            library.returnItem("The Catcher in the Rye", reader1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            library.borrowItem("National Geographic", reader2);
            library.returnItem("National Geographic", reader1); // Ошибка, так как читатель не брал этот предмет
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Вывод информации о предметах
        book1.displayInfo();
        magazine1.displayInfo();
    }
}


//Для создания UML-диаграммы по описанному проекту "Библиотечная система", давайте разберем, как будут выглядеть классы и их отношения. Я опишу структуру диаграммы, а также дополню ее краткими пояснениями.
//
//### UML-диаграмма классов
//
//1. **Borrowable (интерфейс)**
//- + `void borrow(Reader reader)`
//- + `void returnBook(Reader reader)`
//
//2. **Item (абстрактный класс)**
//- - `String title`
//- - `String author`
//- - `boolean isBorrowed`
//- - `ItemType itemType`
//- + `Item(String title, String author, ItemType itemType)`
//- + `abstract void displayInfo()`
//- + `void borrow(Reader reader)`
//- + `void returnBook(Reader reader)`
//
//3. **Book (класс)**
//- - `String isbn`
//- + `Book(String title, String author, String isbn)`
//- + `void displayInfo()`
//
//4. **Magazine (класс)**
//- - `int issueNumber`
//- + `Magazine(String title, String author, int issueNumber)`
//- + `void displayInfo()`
//
//5. **Reader (класс)**
//- - `String name`
//- - `String readerId`
//- + `Reader(String name, String readerId)`
//- + `void displayInfo()`
//
//6. **Library<T extends Item> (класс)**
//- - `List<T> items`
//- - `List<Reader> readers`
//- + `Library()`
//- + `void addItem(T item)`
//- + `void registerReader(Reader reader)`
//- + `T findItemByTitle(String title)`
//- + `void borrowItem(String title, Reader reader)`
//- + `void returnItem(String title, Reader reader)`
//
//7. **ItemType (перечисление)**
//- + `BOOK`
//- + `MAGAZINE`
//- + `DVD`
//
//8. **Исключения (классы)**
//- `ItemNotFoundException`
//- `ItemAlreadyBorrowedException`
//- `ReaderNotFoundException`
//- `ItemNotBorrowedByReaderException`
//- (Каждый из классов имеет конструктор, принимающий строку).
//
//### Правила относительных связей:
//- **Item** реализует интерфейс **Borrowable**.
//- **Book** и **Magazine** наследуют **Item**.
//- **Library** работает с дженериками и может хранить любые элементы, которые расширяют **Item**.
//- **Reader** представляет собой отдельный класс, который может взаимодействовать с **Library**.
//
//### Общее представление
//
//На основании описания, диаграмма классов будет выглядеть следующим образом:
//
//
//[Borrowable]
//     |
//     |-------------------------------|
//     |                               |
//[Item (abstract class)]         [ItemType (enum)]
//     |                               |
//     |------------------             |
//     |                   |            |
//[Book]                [Magazine]     |
//     |                   |            |
//     |                   |            |
//    - isbn             - issueNumber  |
//     |                   |            |
//            + displayInfo()        + displayInfo()
//
//[Library<T extends Item>]
//     |
//     + addItem(T item)
//     + registerReader(Reader reader)
//     + findItemByTitle(String title)
//     + borrowItem(String title, Reader reader)
//     + returnItem(String title, Reader reader)
//
//[Reader]
//     |
//     |--------------------|
//     |                    |
//     + displayInfo()
//
//
//### Исключения
//Группу исключений можно выделить отдельно, показывая, что каждая из них наследуется от общего класса `Exception`.
//
//
//[ItemNotFoundException]
//[ItemAlreadyBorrowedException]
//[ReaderNotFoundException]
//[ItemNotBorrowedByReaderException]
//
//
//### Визуализация
//Для визуализации такой диаграммы можно использовать инструменты, такие как:
//- [Lucidchart](https://lucidchart.com)
//- [Draw.io](https://diagrams.net)
//- [PlantUML](https://plantuml.com)
//
//## Заключение
//В приведенной информации описана структура и отношения между классами вашего проекта &quot;Библиотечная система&quot;. На основе этого описания можно создать UML-диаграмму в любом удобном вам инструменте. Если вам требуется дополнительная помощь или конкретный формат, дайте знать!