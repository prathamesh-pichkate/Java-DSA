import java.util.PriorityQueue;

public class ConnectingNRodwithMINCOST {
    public static void main(String[] args) {
        int rods[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<rods.length;i++){
            pq.add(rods[i]);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;

            pq.add(min + min2);
        }

        System.out.println("Cost of rod with min rod is" + cost);
    }
}
