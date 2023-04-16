package job_hacker.tasks.repositories;

import java.util.List;
import java.util.function.Predicate;

import job_hacker.tasks.exceptions.UnAvailableBookException;
import job_hacker.tasks.models.Book;

public class BookRepository {
    private static BookRepository instance;
    
    private BookRepository(){}

    public static synchronized BookRepository getInstance() {
        if (instance == null)
            instance = new BookRepository();
        return instance;
    }
    public void checkoutBook(Book book) throws UnAvailableBookException {
        book.checkoutBook();
    }
    
    public void returnBook(Book book) {
        book.returnBook();
    }
    
    public List<Book> getAvailableBooks(List<Book> books) {
        List<Book> availableBooks = books.stream().filter(Book::isAvailable).toList();
        System.out.println("available library books: " + availableBooks);
        return availableBooks;
    }

    public List<Book> getBorrowedBooks(List<Book> books) {
        List<Book> borrowedBooks = books.stream().filter(Predicate.not(Book::isAvailable)).toList();
        System.out.println("borrowed library books: " + borrowedBooks);
        return borrowedBooks;
    }
    
    public void displayBookDetails(Book book) {
        System.out.println(book);
    }
    
}
