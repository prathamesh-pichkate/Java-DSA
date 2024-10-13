package Set;
import java.util.*;
public class SubarraySumEqualToK {
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k =-10;
        HashMap<Integer,Integer> hm = new HashMap<>();

        hm.put(0,1);

        int sum = 0;
        int ans = 0;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
