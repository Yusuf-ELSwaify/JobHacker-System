package job_hacker.tasks.exceptions;

public class UnAvailableBookException extends Exception{
    public UnAvailableBookException(String error){
        super(error);
    }
}
