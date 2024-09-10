import java.util.PriorityQueue;
public class PQAscending{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(11);
        pq.add(2);
        pq.add(3);
        pq.add(88);
        pq.add(25);
        
        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " "); //O(1)
            pq.remove(); //O(log n)
        }
    }
}