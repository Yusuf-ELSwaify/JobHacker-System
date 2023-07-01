package job_hacker.tasks.dtos;

import job_hacker.tasks.models.enums.AvailabilityStatus;

public class BookDto {
    private final String ID;
    private final String title;
    private final String authorName;
    private final int version;
    private final AvailabilityStatus availabilityStatus;
    
    public BookDto(String ID, String title, String authorName, int version, AvailabilityStatus availabilityStatus) {
        this.ID = ID;
        this.title = title;
        this.authorName = authorName;
        this.version = version;
        this.availabilityStatus = availabilityStatus;
    }
    
    public String getID() {
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
