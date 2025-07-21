class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // prune unnecessary branches

            path.add(candidates[i]);                    // choose
            backtrack(candidates, i, target - candidates[i], path, result); // explore
            path.remove(path.size() - 1);               // un-choose (backtrack)
        }
    }
}
