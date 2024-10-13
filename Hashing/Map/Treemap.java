import java.util.*;
public class Treemap {
    public static void main(String[] args) {

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",150);
        tm.put("China",200);
        tm.put("Pakistan",250);

        System.out.println(tm);
    }
}


//////////////   Notes    //////////////////

/*
 * Treemap use the red black treefor implementation.
 * The value are sorted acording to key in ascendig order.
 */