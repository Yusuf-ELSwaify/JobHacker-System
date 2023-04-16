package job_hacker.tasks.exceptions;

public class InvalidBookIDException extends Exception{
    public InvalidBookIDException(int ID){
        super("No book with ID "+ID);
    }
}
