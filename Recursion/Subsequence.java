import java.util.*;

public class Subsequence {
    
    // This method generates all subsequences of the given array
    public static void subSequenceOFNo(int idx, int arr[], ArrayList<Integer> ds, int n) {
        // Base case: if the index reaches the end of the array
        if (idx == n) {
            // Print the subsequence
            System.out.println(ds);
            return;
        }

        // Include the current element in the subsequence
        ds.add(arr[idx]);
        // Recursively generate subsequences including the current element
        subSequenceOFNo(idx + 1, arr, ds, n);
        
        // Exclude the current element from the subsequence
        ds.remove(ds.size() - 1);
        // Recursively generate subsequences excluding the current element
        subSequenceOFNo(idx + 1, arr, ds, n);
    }

    public static void main(String[] args) {
        // Array of integers
        int arr[] = {3, 1, 2};
        // Length of the array
        int n = arr.length;
        // Call the method to generate subsequences
        subSequenceOFNo(0, arr, new ArrayList<>(), n);
    }
}
