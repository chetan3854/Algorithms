import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //minheap
        pq.add(20);
        pq.add(10);
        pq.add(15);
        pq.add(-2);
        pq.add(100);
        pq.add(17);

        System.out.println(pq);
        System.out.println(pq.peek()); //gives the Min element , but doesnt remove it
        System.out.println(pq);
        System.out.println(pq.poll());// gives the min element and remove it.
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.print("Lets check the real order");

        while(pq.isEmpty()){ // remove and rearrange the min heap untill we get everything out.
            System.out.println(pq.poll());
        }
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        // Adding elements
        maxpq.add(20);
        maxpq.add(10);
        maxpq.add(15);

        System.out.println(maxpq.peek());






    }
}
