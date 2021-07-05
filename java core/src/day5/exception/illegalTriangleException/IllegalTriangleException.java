package day5.exception.illegalTriangleException;

public class IllegalTriangleException extends Exception{
    String errorMessage;

    public IllegalTriangleException(String inErrorMessage) {
        super(inErrorMessage);
        this.errorMessage = inErrorMessage;
    }

    public String getString(){
        return errorMessage;
    }
}
