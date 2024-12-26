class Solution {
    private void findCombination(int idx, int candidates[], int target, List<List<Integer>> result, List<Integer> ans) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // Skip duplicates
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // Break if the candidate is greater than the target
            if (candidates[i] > target) break;

            // Include the current candidate
            ans.add(candidates[i]);

            // Recursive call with updated target
            findCombination(i + 1, candidates, target - candidates[i], result, ans);

            // Backtrack
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates and enable pruning
        findCombination(0, candidates, target, result, new ArrayList<>());
        return result;
    }
}
