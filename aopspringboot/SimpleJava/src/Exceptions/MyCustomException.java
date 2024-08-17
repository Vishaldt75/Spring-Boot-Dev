package Exceptions;

public class MyCustomException extends Exception{
    MyCustomException(String str)
    {
        super(str);
    }
    MyCustomException(Exception e)
    {
        super(e);
    }

}
