package LamdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareInterfaces {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Namaste");
        arrayList.add("Hey");
        arrayList.add("Hi");
        arrayList.add("Bye");

        System.out.println("List Without Sort:"+arrayList);

        Collections.sort(arrayList);

        System.out.println("List After Sort:"+arrayList);
   /*     Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                {
                    return 1;
                }
                else
                    return -1;
            }
        };*/
        //Using Lambda Expression
        Comparator<String> comparator=(o1, o2) -> o1.length()>o2.length() ? 1:-1;

        Collections.sort(arrayList,comparator);
        System.out.println("List Sort using Comparator:"+arrayList);
    }
}
