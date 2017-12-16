package PriorityQueue;

public class PriQUnderflowException extends RuntimeException {
    public PriQUnderflowException(){}

    public PriQUnderflowException(String message){
        super(message);
    }
}
