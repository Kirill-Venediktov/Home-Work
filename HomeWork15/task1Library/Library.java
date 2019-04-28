package HomeWork15.task1Library;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

public class Library {

    public static final int LIBRARYSIZE = 100;
    public static final int NUMBEROFREADERS = 10;

    public static void main(String[] args) {
        CopyOnWriteArraySet<Book> books = new CopyOnWriteArraySet();

        for (int i = 0; i < LIBRARYSIZE; i++) {
            boolean isReadingHallOnly = new Random().nextBoolean();
            Book book = new Book(i, isReadingHallOnly);
            books.add(book);
        }

        for (int i = 0; i < NUMBEROFREADERS; i++) {
            new Reader(books).start();
        }

    }
}



