package job_hacker.tasks.mappers;

import job_hacker.tasks.dtos.BookDto;
import job_hacker.tasks.models.Book;

public class BookMapper {
    public BookDto toDto(Book book){
        return new BookDto(book.getID(), book.getTitle(),
                                book.getAuthorName(), book.getVersion(),
                                book.getAvailabilityStatus());
    }
}
