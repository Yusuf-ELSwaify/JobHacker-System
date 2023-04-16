package job_hacker.tasks.repositories;

import java.util.List;
import java.util.Optional;

import job_hacker.tasks.exceptions.InvalidBookIDException;
import job_hacker.tasks.models.Book;
import job_hacker.tasks.models.Library;

public class LibraryRepository {
    private static LibraryRepository instance;
    Library library = new Library("Yusuf Library");

    private LibraryRepository(){}

    public static synchronized LibraryRepository getInstance(){
        if (instance == null)
            instance = new LibraryRepository();
        return instance;
    }

    public List<Book> getBooks() {
        return library.getBooks();
    }

    public Book getBookById(int bookId) throws InvalidBookIDException {
        Optional<Book> result = library.getBooks().stream()
                .filter(book -> book.getID() == bookId)
                .findFirst();
        if (result.isEmpty())
            throw new InvalidBookIDException(bookId);
        return result.get();
    }
    
    public Book addBook(Book book) {
        library.addBook(book);
        return book;
    }
    public Book addBook(String name, String authorName, int version){
        Book newBook = new Book(name, authorName, version);
        return addBook(newBook);
    }
    public void removeBook(Book book) {
        library.removeBook(book);
    }
    public void removeBook(int bookId) throws InvalidBookIDException {
        removeBook(getBookById(bookId));
    }

}
