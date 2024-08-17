package Exceptions;

public class UncheckedExceptions {
    public void testExceptions(){
        int a=10;
        int b=0;
        //int res=(a/b); // b=0 is not allow it throws run time exception.
        try {
            if (b == 0) {
                throw new MyCustomException(new RuntimeException("B should not be 0"));
            } else {
                int res = (a / b);
                System.out.println("Result : " + res);
            }
        }catch (MyCustomException e)
        {
            e.printStackTrace();
        }
    }
}
