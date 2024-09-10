import java.util.PriorityQueue;
import java.util.*;

public class PQDescending {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(54);
        pq.add(5);
        pq.add(96);
        pq.add(21);
        pq.add(9);

        while(!pq.isEmpty()){
            System.out.println(pq.peek() + " ");
            pq.remove();
        }
    }
}
