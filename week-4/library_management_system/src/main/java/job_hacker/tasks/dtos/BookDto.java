package job_hacker.tasks.dtos;

import job_hacker.tasks.models.enums.AvailabilityStatus;

public class BookDto {
    private int ID;
    private String title;
    private String authorName;
    private int version;
    private AvailabilityStatus availabilityStatus;
    
    public BookDto(int iD, String title, String authorName, int version, AvailabilityStatus availabilityStatus) {
        ID = iD;
        this.title = title;
        this.authorName = authorName;
        this.version = version;
        this.availabilityStatus = availabilityStatus;
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

    @Override
    public String toString() {
        return "Book {" +
                "ID: " + ID +
                ", title: " + title +
                ", author name: " + authorName +
                ", version: " + version +
                ", status ? " + availabilityStatus
                + " }";
    }
}
