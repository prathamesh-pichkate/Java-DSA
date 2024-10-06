import java.util.PriorityQueue;

public class ObjectsInPQ {

    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
         PriorityQueue<Student> pq = new PriorityQueue<>(); 
        
        pq.add(new Student("A", 50)); // O(log(n))
        pq.add(new Student("B", 12) );
        pq.add(new Student("C", 1) );
        pq.add(new Student("D", 60) );

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +"->"+ pq.peek().rank); //O(log(n))
            pq.remove(); //O(1)
        }
    }
}
