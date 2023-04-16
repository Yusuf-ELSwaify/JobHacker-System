package job_hacker.tasks.services;

import java.util.List;

import job_hacker.tasks.dtos.BookDto;
import job_hacker.tasks.exceptions.InvalidBookIDException;
import job_hacker.tasks.exceptions.UnAvailableBookException;
import job_hacker.tasks.mappers.BookMapper;
import job_hacker.tasks.models.Book;
import job_hacker.tasks.repositories.BookRepository;
import job_hacker.tasks.repositories.LibraryRepository;

public class LibraryService {
    LibraryRepository libraryRepository = LibraryRepository.getInstance();
    BookRepository bookRepository = BookRepository.getInstance();
    BookMapper bookMapper = new BookMapper();
    public BookDto getBook(int bookId) throws InvalidBookIDException {
        Book book = libraryRepository.getBookById(bookId);
        return bookMapper.toDto(book);
    }
    public BookDto addBook(String bookName, String authorName, int version) {
        Book book = libraryRepository.addBook(bookName, authorName, version);
        return bookMapper.toDto(book);
    }

    public void removeBook(int bookId) throws InvalidBookIDException {
        libraryRepository.removeBook(bookId);
    }
    
    public void checkoutBook(int bookId) throws UnAvailableBookException, InvalidBookIDException{
        bookRepository.checkoutBook(libraryRepository.getBookById(bookId));
    }
    
    public void returnBook(int bookId) throws InvalidBookIDException{
        bookRepository.returnBook(libraryRepository.getBookById(bookId));
    }
    
    public List<BookDto> getBooks() {

        List<BookDto> books = libraryRepository.getBooks().stream().map(bookMapper::toDto).toList();
        System.out.println("library books:" + books);
        return books;
    }
    public List<BookDto> getAvailableBooks() {
        List<Book> books = libraryRepository.getBooks();
        return bookRepository.getAvailableBooks(books).stream().map(bookMapper::toDto).toList();
    }
    
    public List<BookDto> getBorrowedBooks() {
        List<Book> books = libraryRepository.getBooks();
        return bookRepository.getBorrowedBooks(books).stream().map(bookMapper::toDto).toList();
    }
    
    public void displayBookDetails(Book book) {
        bookRepository.displayBookDetails(book);
    }
}
