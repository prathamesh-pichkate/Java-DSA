import java.util.*;
class Solution {
    public static void findUniqueSeq(int nums[],int idx, ArrayList<ArrayList<Integer>> result,int n,ArrayList<Integer> ds){
            result.add(new ArrayList<>(ds));
        
        for(int i =idx;i<n;i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findUniqueSeq(nums,i+1,result,n,ds);
            ds.remove(ds.size() -1);
        }
    }
    
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        findUniqueSeq(nums,0,result,n,new ArrayList<>());
        return result;
    }
}
