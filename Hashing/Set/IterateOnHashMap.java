package Set;
import java.util.*;
public class IterateOnHashMap {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("Mumbai");
        hs.add("Pune");
        hs.add("Nagpur");
        hs.add("Hinganghat");

        //Using Iterator:
        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


        //using advance for each loop
        for(String h : hs){
            System.out.println(h);
        }

    }
}
