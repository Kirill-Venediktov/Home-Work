package HomeWork15.task1Library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

public class Reader extends Thread {
    CopyOnWriteArraySet<Book> books;
    ArrayList<Book> readingBooks = new ArrayList<>();

    public Reader(CopyOnWriteArraySet books) {
        this.books = books;
    }

    @Override
    public void run() {
        boolean homebody = new Random().nextBoolean();
        int numberOfBooks = new Random().nextInt(Library.LIBRARYSIZE);
        for (int i = 0; i < numberOfBooks; i++) {
            int concrete = new Random().nextInt(books.size());
            for (Book book : books) {
                if (book.getId() == concrete && !book.isReadingHallOnly() ||
                        book.getId() == concrete && book.isReadingHallOnly() && !homebody) {
                    Book ourBook = book;
                    readingBooks.add(ourBook);
                    books.remove(book);
                    System.out.println("Читатель" + Thread.currentThread().getName() + " забрал книгу с ID "
                            + book.getId());
                    break;
                }else if (book.getId() == concrete && book.isReadingHallOnly() && homebody) {
                    System.out.println("Читатель " + Thread.currentThread().getName() +
                            ". Книга c ID " + book.getId() + " только для чтения в зале!");
                    break;
                }
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Book book : readingBooks) {
            Book ourBook = book;
            books.add(ourBook);
            System.out.println("Читатель" + Thread.currentThread().getName() + " вернул книгу с ID "
                    + book.getId());
        }

        System.out.println("Читатель" + Thread.currentThread().getName() + " все вернул и ушел восвояси");

    }
}
