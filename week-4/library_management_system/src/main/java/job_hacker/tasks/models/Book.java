package job_hacker.tasks.models;

import job_hacker.tasks.exceptions.UnAvailableBookException;
import job_hacker.tasks.models.enums.AvailabilityStatus;

public class Book {
    private static int currentID = 0;
    private int ID;
    private String title;
    private String authorName;
    private int version;
    private AvailabilityStatus availabilityStatus;
    
    public Book(String title, String authorName, int version) {
        ++currentID;
        ID = currentID;
        this.title = title;
        this.authorName = authorName;
        this.version = version;
        this.availabilityStatus = AvailabilityStatus.AVAILABLE;
    }
    public int getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public int getVersion() {
        return version;
    }
    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void checkoutBook() throws UnAvailableBookException {
        if (!isAvailable())
            throw new UnAvailableBookException("this book is borrowed");
        this.availabilityStatus = AvailabilityStatus.BORROWED;
    }
    public void returnBook() {
        this.availabilityStatus = AvailabilityStatus.AVAILABLE;
    }
    
    public boolean isAvailable(){
       return availabilityStatus == AvailabilityStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Book {" + 
            "ID: "+ ID +
            ", title: "+ title +
            ", author name: "+ authorName +
            ", version: " + version +
            ", status ? "+ availabilityStatus
            +" }";
    }

}
