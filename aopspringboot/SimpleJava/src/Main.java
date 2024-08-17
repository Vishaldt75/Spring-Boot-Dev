import Exceptions.CheckedExceptions;
import Exceptions.MyCustomException;
import Exceptions.UncheckedExceptions;
import LamdaExpressions.ExpressionClass;
import LamdaExpressions.FirstInterface;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
  /*     //Exceptions
        CheckedExceptions obj=new CheckedExceptions();
        UncheckedExceptions obj1=new UncheckedExceptions();
        obj1.testExceptions();
   */

        //Lambda Expressions
        FirstInterface expression=() ->{
            System.out.println("Hello Lambda Expressions");
        };
        expression.testExpression();

        ExpressionClass expressionClass=new ExpressionClass();
        expressionClass.forEachExpressions();
        expressionClass.forEachExpressions();
        Hashtable h1=new Hashtable<>() ;
        h1.put(10,"Hello");
        //h1.put(20,null);
        System.out.println(h1);
    }
}