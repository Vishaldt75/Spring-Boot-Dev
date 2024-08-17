package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(30);
        linkedHashSet.add(4);
        linkedHashSet.add(10);
        linkedHashSet.add(50);

        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.hashCode());
        System.out.println(linkedHashSet.size());

        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(30);
        hashSet.add(4);
        hashSet.add(10);
        hashSet.add(50);


        System.out.println(hashSet);
        System.out.println(hashSet.hashCode());
        System.out.println(hashSet.size());

        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(30);
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(50);

        System.out.println(treeSet);
        System.out.println(treeSet.hashCode());
        System.out.println(treeSet.size());


    }
}
