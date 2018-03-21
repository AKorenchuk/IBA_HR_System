package exception;

public class ValidationErrorException extends Throwable {

    String message;

    public ValidationErrorException(){

    }


    public ValidationErrorException(String message){
        super(message);
    }

}
