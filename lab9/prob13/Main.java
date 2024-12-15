package lab9.prob13;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Set up
        Book book = new Book("test", 3);
        List<BookCopy> copies = book.getCopies();
        copies.forEach(copy -> copy.changeAvailability());

        //test
        System.out.println(book.isAvailable());
    }
}
