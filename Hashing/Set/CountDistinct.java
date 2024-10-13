package Set;
import java.util.*;
public class CountDistinct {
    public static void main(String[] args) {
        int arr[] = {1,7,6,1,3,9,7,1,3,9,4,6,8,6,2};

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }

        System.out.println("The total unique elements are:"+hs.size());
    }
}
