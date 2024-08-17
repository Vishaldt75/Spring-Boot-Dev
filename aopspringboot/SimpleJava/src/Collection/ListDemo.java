package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ListDemo {
    public static void main(String[] args) {
    ArrayList<Integer> demoArray=new ArrayList<>();
        demoArray.add(10);
        demoArray.add(22);
        demoArray.add(30);
        demoArray.add(40);
        demoArray.add(50);
        demoArray.add(60);


        System.out.println("List : "+demoArray);
        System.out.println(demoArray.lastIndexOf(60));
        boolean test=demoArray.contains(10);
        System.out.println(test);


        LinkedList<Integer> demoList=new LinkedList<>();
        demoList.add(10);
        demoList.add(22);
        demoList.add(30);
        demoList.add(40);
        demoList.add(50);
        demoList.add(60);

        System.out.println("List : "+demoList);
        System.out.println(demoList.lastIndexOf(60));
        demoList.offer(100);
        System.out.println(demoList);

        Stack<String> demoStack=new Stack<>();
        demoStack.push("Hello");
        demoStack.push("Hey");
        demoStack.push("Namaste");
        demoStack.push("Kaise ho");

        System.out.println(demoStack);

        demoStack.push("Aur Batao");
        System.out.println(demoStack);

        System.out.println(demoStack.peek());
        demoStack.pop();
        System.out.println(demoStack);

        Vector v1=new Vector();
        v1.add(1);
        v1.add("Hello");
        v1.add(3.4);
        v1.add('A');
        v1.add(true);
        System.out.println(v1);

    }
}
