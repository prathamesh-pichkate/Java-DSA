import java.util.HashSet;

public class SubsetOfrray{
    public static boolean isSubset(int arr1[],int arr2[]){
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            if(!hs.contains(arr2[i])){
                  return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = { 11, 3, 7, 1 ,6};

        if(isSubset(arr1,arr2)){
            System.out.println("Yes,arr2 is the subset of the arrr1");
        }else{
            System.out.println("No,arr2 is not the subset of arr1");
        }
    }
}