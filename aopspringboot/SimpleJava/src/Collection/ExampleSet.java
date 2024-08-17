package Collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExampleSet {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        int mid=(arrayList.size()%2)==0?(arrayList.size()/2):(arrayList.size()/2)+1;
        arrayList.remove(arrayList.indexOf(mid));
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        arrayDeque.offer(mid);
        for(int test:arrayList)
        {
            if(test%2==0)
            {
                arrayDeque.offerFirst(test);
            }
            else
            {
                arrayDeque.offerLast(test);
            }
        }
        System.out.println(arrayDeque);
    }
}
