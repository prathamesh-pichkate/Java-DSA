import java.util.*;
public class PriorityQueueOperation {
    public static void main(String[] args) {

        //ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        pq.add(10); // O(log(n))
        pq.add(8);
        pq.add(15);
        pq.add(1);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //O(log(n))
            pq.remove(); //O(1)
        }

         //Descending order
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); 
        pq1.add(10); // O(log(n))
        pq1.add(8);
        pq1.add(15);
        pq1.add(1);

        while(!pq1.isEmpty()){
            System.out.println(pq1.peek()); //O(log(n))
            pq1.remove(); //O(1)
        }
    }
}
