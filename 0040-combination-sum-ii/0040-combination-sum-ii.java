class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        // Found valid combination
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < candidates.length; i++) {

            // Skip duplicates
            if(i > index && candidates[i] == candidates[i - 1])
                continue;

            // No need to continue further
            if(candidates[i] > target)
                break;

            curr.add(candidates[i]);

            // i + 1 क्योंकि element दुबारा use नहीं कर सकते
            backtrack(candidates,
                      target - candidates[i],
                      i + 1,
                      curr,
                      ans);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}