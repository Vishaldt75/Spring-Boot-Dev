package Collection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"Hello");
        hashMap.put(2,"Hey");
        hashMap.put(3,"Hii");
        hashMap.put(4,null);
        hashMap.put(null,null);
        System.out.println(hashMap);
        for (Map.Entry<Integer,String> entry:hashMap.entrySet())
        {
            System.out.println(entry);

        }
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.size());

        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(1,"Hello");
        linkedHashMap.put(2,"Hey");
        linkedHashMap.put(3,"Hii");
        linkedHashMap.put(4,null);
        linkedHashMap.put(null,null);
        System.out.println(linkedHashMap);
        for (Map.Entry<Integer,String> entry:linkedHashMap.entrySet())
        {
            System.out.println(entry);

        }
        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.values());
        System.out.println(linkedHashMap.size());

        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(2,"Hello");
        treeMap.put(1,"Hey");
        treeMap.put(3,"Hii");
        treeMap.put(4,null);
        //treeMap.put(null,null);
        System.out.println(treeMap);
        for (Map.Entry<Integer,String> entry:treeMap.entrySet())
        {
            System.out.println(entry);

        }
        System.out.println(treeMap.keySet());
        System.out.println(treeMap.values());
        System.out.println(treeMap.size());

        Hashtable<Integer,String> hashtable=new Hashtable<>();
        hashtable.put(2,"Hello");
        hashtable.put(1,"Hey");
        hashtable.put(3,"Hii");
       // hashtable.put(4,null);
        //treeMap.put(null,null);
        System.out.println(hashtable);
        for (Map.Entry<Integer,String> entry:hashtable.entrySet())
        {
            System.out.println(entry);

        }
        System.out.println(hashtable.keySet());
        System.out.println(hashtable.values());
        System.out.println(hashtable.size());

    }
}
