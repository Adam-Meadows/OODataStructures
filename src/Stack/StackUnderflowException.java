package Stack;

public class StackUnderflowException extends RuntimeException {

    public StackUnderflowException(String message){
        super(message);
    }

    public StackUnderflowException(){

    }
}