class Solution {
    public void findCombination(int idx,int candidates[],int target, List<List<Integer>> result,List<Integer> combination){
        if(idx == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        if(candidates[idx] <= target){
            combination.add(candidates[idx]);
            findCombination(idx,candidates,target-candidates[idx],result,combination);
            combination.remove(combination.size() -1);
        }
        findCombination(idx+1,candidates,target,result,combination);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0,candidates,target,result,new ArrayList<>());
        return result;
    }
}