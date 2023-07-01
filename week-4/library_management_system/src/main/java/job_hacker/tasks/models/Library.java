package job_hacker.tasks.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Library{
    private static int count = 0;
    private int code;
    private String name;
    private List<Book> books;
    
    public Library(String name){
        code = ++count;
        this.name = name;
        books = new LinkedList<>();
    }
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
    
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}
