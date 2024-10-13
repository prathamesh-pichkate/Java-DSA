import java.util.*;
public class LinkedInHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap();
        lhm.put("India",150);
        lhm.put("China",200);
        lhm.put("Pakistan",50);

        System.out.println(lhm);
    }
}


            /////// Notes: //////////////
/*
 * In LinkedHashMap, the order of insertion is maintained.
   The order of elements in LinkedHashMap is based on the order in which they were inserted.
   The doubly Linked list is implementedd.
 */
