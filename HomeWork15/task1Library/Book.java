package HomeWork15.task1Library;

import java.util.concurrent.Semaphore;

public class Book {
    private int id;
    Semaphore semaphore = new Semaphore(1);
    private boolean isReadingHallOnly = false;



    public Book(int id, boolean isReadingHallOnly) {
        this.id = id;
        this.isReadingHallOnly = isReadingHallOnly;
    }

    public int getId() {
        return id;
    }


    public boolean isReadingHallOnly() {
        return isReadingHallOnly;
    }

    public void setReadingHallOnly(boolean readingHallOnly) {
        isReadingHallOnly = readingHallOnly;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
