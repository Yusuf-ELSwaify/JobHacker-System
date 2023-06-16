package job_hacker.tasks.exceptions;

public class InvalidBookIDException extends Exception{
    public InvalidBookIDException(String ID){
        super("No book with ID "+ID);
    }
}
