package LamdaExpressions;

import java.util.ArrayList;
import java.util.Collections;

public class StudentMain {
    public static void main(String[] args) {
        ArrayList<StudentClass> arrayList=new ArrayList<>();
        arrayList.add(new StudentClass("Virat",18));
        arrayList.add(new StudentClass("Sachin",10));
        arrayList.add(new StudentClass("Dhoni", 7));
        arrayList.add(new StudentClass("Rohit",45));
        arrayList.add(new StudentClass("Rahul",1));
        arrayList.add(new StudentClass("Rishabh", 17));
        arrayList.add(new StudentClass("Yuvraj",12));

        System.out.println("Students Before Sorting :");
        for (StudentClass s1:arrayList)
        {
            System.out.println(s1);
        }

        Collections.sort(arrayList);
        System.out.println("\nStudents after Sorting :");
        for (StudentClass s1:arrayList)
        {
            System.out.println(s1);
        }
    }
}
