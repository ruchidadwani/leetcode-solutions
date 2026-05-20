import java.util.*;

class Solution {

    Map<Character, List<Integer>> map = new HashMap<>();
    int[][] memo;

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();

        // Store positions of every character
        for (int i = 0; i < n; i++) {
            char ch = ring.charAt(i);

            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        memo = new int[n][key.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, ring, key);
    }

    private int dfs(int ringPos, int keyIndex,
                    String ring, String key) {

        // Finished spelling
        if (keyIndex == key.length()) {
            return 0;
        }

        if (memo[ringPos][keyIndex] != -1) {
            return memo[ringPos][keyIndex];
        }

        int n = ring.length();
        char target = key.charAt(keyIndex);

        int ans = Integer.MAX_VALUE;

        // Try every occurrence of target char
        for (int nextPos : map.get(target)) {

            int diff = Math.abs(nextPos - ringPos);

            int rotateSteps = Math.min(diff, n - diff);

            // +1 for pressing button
            int total =
                    rotateSteps + 1 +
                    dfs(nextPos, keyIndex + 1, ring, key);

            ans = Math.min(ans, total);
        }

        return memo[ringPos][keyIndex] = ans;
    }
}