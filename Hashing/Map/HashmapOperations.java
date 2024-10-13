import java.util.HashMap;

public class HashmapOperations {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        // 1.Add operation - O(1)
        hm.put("India",150);
        hm.put("USA", 200);
        hm.put("China", 20);

        System.out.println(hm);

        // 2.Get operation - O(1)
        System.out.println(hm.get("India"));

        //3.containsKey operation - O(1)
        System.out.println(hm.containsKey("India"));

        //4.remove operation - O(1)
        hm.remove("China");
        System.out.println(hm);

        //5.size operation - O(1)
        System.out.println(hm.size());

        //6.isEmpty operation - O(1)
        System.out.println(hm.isEmpty());

        //7.clear operation - O(1)
        hm.clear();
        System.out.println(hm);

    }
}
