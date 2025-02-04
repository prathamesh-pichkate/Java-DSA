// Leetcode 90: https://leetcode.com/problems/subsets-ii/

class Solution {
    private void findSubsequence(int nums[],int i, Set<List<Integer>> result, List<Integer> sub){
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
   
       public List<List<Integer>> subsetsWithDup(int[] nums) {
           Arrays.sort(nums);
           Set<List<Integer>> result = new HashSet<>();
           List<Integer> sub = new ArrayList<>();
   
           findSubsequence(nums,0,result,sub);
           return new ArrayList<>(result);
       }
   }
   