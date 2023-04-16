package job_hacker.tasks;


import job_hacker.tasks.dtos.BookDto;
import job_hacker.tasks.exceptions.InvalidBookIDException;
import job_hacker.tasks.exceptions.UnAvailableBookException;
import job_hacker.tasks.services.LibraryService;

/**
 * Hello world!
 *
 */
public class App 
{
    static LibraryService libraryService;
    public static void main( String[] args )
    {
        try {
            libraryService = new LibraryService();
            testadd();
            testavailableAndBorrowedList();

        } catch (InvalidBookIDException | UnAvailableBookException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void testadd() throws UnAvailableBookException, InvalidBookIDException{
        System.out.println("_____________________________");
        System.out.println("test adding book");
        BookDto firstBook = libraryService.addBook("Alghorithm", "author 1", 1);
        System.out.println("book added " + firstBook);
        libraryService.getBooks();
        System.out.println("_____________________________");
        System.out.println("test removing book");
        libraryService.removeBook(firstBook.getID());
        libraryService.getBooks();
        System.out.println("_____________________________");
    }
    
    public static void testavailableAndBorrowedList() throws UnAvailableBookException, InvalidBookIDException {
        System.out.println("_____________________________");
        BookDto firstBook = libraryService.addBook("Alghorithm", "author 1", 1);
        BookDto secondBook = libraryService.addBook("DS", "author 22", 2);

        libraryService.getBooks();

        libraryService.getAvailableBooks();
        libraryService.getBorrowedBooks();
        System.out.println("_____________________________");
        libraryService.checkoutBook(secondBook.getID());
        System.out.println("checked out: "+ secondBook);
        libraryService.getAvailableBooks();
        libraryService.getBorrowedBooks();
        System.out.println("_____________________________");
        libraryService.returnBook(secondBook.getID());
        System.out.println("returned: " + secondBook);
        libraryService.getAvailableBooks();
        libraryService.getBorrowedBooks();
        System.out.println("_____________________________");
    }

}
