import java.util.*;
public class ObjectsCompared {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name,int r){
           this.name = name;
           this.rank = r;
        }

        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 20));
        pq.add(new Student("B", 2));
        pq.add(new Student("C", 10));
        pq.add(new Student("D", 1));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().rank + " ");
            pq.remove();
        }

    }
}
