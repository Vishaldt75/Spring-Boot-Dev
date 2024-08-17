package Exceptions;

public class FinallyDemo {
    public static void divide(int a, int b)
    {
        try
        {
            System.out.println("the Division is : "+(a/b));
        }catch (Exception e)
        {
            e.printStackTrace();
           System.exit(0);
        }finally {
            System.out.println("Finally Executed !!");
        }
    }
    public static void main(String[] args) {
        FinallyDemo.divide(10,0);
    }
}
