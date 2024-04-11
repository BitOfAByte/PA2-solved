package dk.sdu.pa2;

import dk.sdu.pa2.task1.BorrowTask;
import dk.sdu.pa2.task1.Library;
import dk.sdu.pa2.task1.ReturnTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    @Test
    public void test_library_can_borrow_and_return_books() throws InterruptedException {
        Library library = new Library();

        // Create threads for borrowing and returning books
        Thread borrowThread1 = new Thread(new BorrowTask(library, 1));
        Thread borrowThread2 = new Thread(new BorrowTask(library, 2));

        Thread returnThread1 = new Thread(new ReturnTask(library, 2));
        Thread returnThread2 = new Thread(new ReturnTask(library, 1));

        // Start the threads
        borrowThread1.start();
        borrowThread2.start();

        returnThread1.start();
        returnThread2.start();

        // Wait for threads to finish
        borrowThread1.join();
        borrowThread2.join();

        returnThread1.join();
        returnThread2.join();

        assertEquals(3, library.getAvailableBooks());
        System.out.println("The number of available books = "+library.getAvailableBooks());
    }

    @Test
    public void test_borrows_correct_amount_of_books() throws InterruptedException {
        Library library = new Library();

        // Create threads for borrowing and returning books
        Thread borrowThread1 = new Thread(new BorrowTask(library, 1));
        Thread borrowThread2 = new Thread(new BorrowTask(library, 2));

        // Start the threads
        borrowThread1.start();
        borrowThread2.start();

        // Wait for threads to finish
        borrowThread1.join();
        borrowThread2.join();

        assertEquals(0, library.getAvailableBooks());
        System.out.println("The number of available books = "+library.getAvailableBooks());
    }
    @Test
    public void test_returns_correct_amount_of_books() throws InterruptedException {
        Library library = new Library();

        // Create threads for borrowing and returning books
        Thread returnThread1 = new Thread(new ReturnTask(library, 3));
        Thread returnThread2 = new Thread(new ReturnTask(library, 1));
        Thread returnThread3 = new Thread(new ReturnTask(library, 6));

        // Start the threads
        returnThread1.start();
        returnThread2.start();
        returnThread3.start();

        // Wait for threads to finish
        returnThread1.join();
        returnThread2.join();
        returnThread3.join();

        assertEquals(13, library.getAvailableBooks());
        System.out.println("The number of available books = "+library.getAvailableBooks());
    }
}
