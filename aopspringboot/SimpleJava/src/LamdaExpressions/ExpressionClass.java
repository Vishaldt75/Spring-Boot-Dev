package LamdaExpressions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionClass {


    public void forEachExpressions()
    {
        List<String> names = Arrays.asList("abc","xyz","def","mno");

        //Print Each names using forEach Lambda.
        names.forEach(name -> System.out.println(name));

        //Filter names with Lambda
        List<String> filterNames=names.stream().filter(name -> name.startsWith("a")).collect(Collectors.toList());

        System.out.println("Filtered Names "+filterNames);

        List<Integer> numbers=Arrays.asList(4,5,3,1,6,9,7);
        numbers.sort((a,b)->b-a);
        System.out.println("Sorted Numbers "+numbers);

    }
}
