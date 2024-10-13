import java.util.HashMap;
import java.util.Set;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        hm.put("India",150);
        hm.put("USA", 200);
        hm.put("China", 20);
        hm.put("Bangladesh",30);
        hm.put("Pakistan",60);


        //Iteration
        Set<String> Keys = hm.keySet();
        System.out.println(Keys);

        for (String k : Keys) {
            System.out.println("Key="+k+",value="+hm.get(k));
        }

        //entrySet();
    }
}
