package Collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q1=new LinkedList<>();
        q1.add(50);
        q1.offer(20);
        q1.offer(10);
        q1.offer(70);
        q1.offer(30);

        System.out.println(q1);
        System.out.println(q1.peek());
        q1.poll();
        System.out.println(q1);

        Queue<Integer> q2=new PriorityQueue<>();
        q2.add(50);
        q2.offer(20);
        q2.offer(10);
        q2.offer(70);
        q2.offer(30);

        System.out.println(q2);
        System.out.println(q2.peek());
        q2.poll();
        System.out.println(q2);

        ArrayDeque<Integer> deque=new ArrayDeque<>();
        deque.offer(20);
        deque.offerFirst(30);
        deque.offerLast(10);
        deque.offerFirst(5);
        deque.offerLast(4);

        System.out.println(deque);

    }
}
