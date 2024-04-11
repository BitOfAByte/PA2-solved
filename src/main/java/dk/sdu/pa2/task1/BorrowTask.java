package dk.sdu.pa2.task1;

public class BorrowTask implements Runnable {
    private Library library;
    private int books;

    public BorrowTask(Library library, int books) {
        this.library = library;
        this.books = books;
    }

    @Override
    public void run() {
        synchronized (library) {
            while (library.getAvailableBooks() < books) {
                try {
                    System.out.println("Waiting for books to be returned. Available books: " + library.getAvailableBooks());
                    library.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            library.borrowBook(books);
            System.out.println("Borrowing " + books + " books. Available books: " + library.getAvailableBooks());
        }
    }
}