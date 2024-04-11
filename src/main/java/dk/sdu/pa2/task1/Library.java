package dk.sdu.pa2.task1;

public class Library {


    private int availableBooks;

    public Library() {
        this.availableBooks = 3;
    }

    public int getAvailableBooks() {
        return this.availableBooks;
    }

    public void borrowBook(int books) {
        this.availableBooks -= books;
    }

    public void returnBook(int books) {
        this.availableBooks += books;
    }
}


