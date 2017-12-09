package Stack;

public class StackOverflowException extends RuntimeException {

    public StackOverflowException(String message){
        super(message);
    }

    public StackOverflowException(){

    }
}