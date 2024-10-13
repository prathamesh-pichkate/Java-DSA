package Set;
import java.util.*;
public class HashSetOperation {
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet<>();

        //1.Add operation
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(10);
        System.out.println(hs); 

        //2.containsKey
        System.out.println(hs.contains(10));

        //3.remove
        hs.remove(10);
        System.out.println(hs);

        //4.size
        System.out.println(hs.size());

        //5.clear
        hs.clear();
        System.out.println(hs);


        //6.isEmpty
        System.out.println(hs.isEmpty());
    }
}
