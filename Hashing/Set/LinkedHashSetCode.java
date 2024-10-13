
package Set;
import java.util.*;
public class LinkedHashSetCode{
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Mumbai");
        lhs.add("Pune");
        lhs.add("Nagpur");
        lhs.add("Hinganghat");
        lhs.add("Mumbai");

        System.out.println(lhs); //maintain the order
    }
}