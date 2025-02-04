// Leetcode 72: https://leetcode.com/problems/subsets/


class Solution {
    private void findSubsequence(int nums[],int i, List<List<Integer>> result, List<Integer> sub){
        int n = nums.length;
        
        if(i >= n){
            result.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        findSubsequence(nums,i+1,result,sub);
        sub.remove(sub.size() -1);
        findSubsequence(nums,i+1,result,sub);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        findSubsequence(nums,0,result,sub);
        return result;
    }
}