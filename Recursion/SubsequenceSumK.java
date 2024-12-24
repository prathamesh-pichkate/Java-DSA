import java.util.ArrayList;
public class SubsequenceSumK {


            ////QUE 1: Print Alll Subsequnce
    // public static void printSubsequence(int arr[], int idx, int sum, int k,ArrayList<Integer> ds){
    //     if(idx == arr.length){
    //         if(sum == k){
    //             System.out.println(ds);
    //         }
    //         return;
    //     }
    //     ds.add(arr[idx]);
    //     printSubsequence(arr, idx + 1, sum + arr[idx], k, ds);
    //     ds.remove(ds.size() - 1);
    //     printSubsequence(arr, idx + 1, sum, k, ds);
    // }

          ///  QUE 2: Print Any one Subsequence
    // public static boolean printSubsequence(int arr[], int idx, int sum, int k,ArrayList<Integer> ds){
    //     if(idx == arr.length){
    //         if(sum == k){
    //             System.out.println(ds);
    //             return true;
    //         }
    //         return false;
    //     }
    //     ds.add(arr[idx]);
    //     if(printSubsequence(arr, idx + 1, sum + arr[idx], k, ds)){
    //         return true;
    //     }
    //     ds.remove(ds.size() - 1);
    //     if(printSubsequence(arr, idx + 1, sum, k, ds)){
    //         return true;
    //     }
    //     return false;
    // }


    //QUE 3. Print count ubsequnce with sum = k
    public static int printSubsequence(int arr[], int idx, int sum, int k,ArrayList<Integer> ds){
        if(idx == arr.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }
        ds.add(arr[idx]);
        int left = printSubsequence(arr, idx + 1, sum + arr[idx], k, ds);
        ds.remove(ds.size() - 1);
        int right = printSubsequence(arr, idx + 1, sum, k, ds);
        return left + right;
    }
  

        
    
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int k = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        // printSubsequence(arr, 0, 0, k, ds); //print all ans with sum = k
        // System.out.println(printSubsequence(arr, 0, 0, k, ds)); //print first ans with sum = k
       System.out.println( printSubsequence(arr, 0,0,k, ds));
    }
}
