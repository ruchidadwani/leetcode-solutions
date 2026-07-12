import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] indexMap = new int[n];
        int[] sortedNums = new int[n];

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            sortedNums[i] = arr[i][0];
            indexMap[arr[i][1]] = i;
        }

        int maxLevel = 32 - Integer.numberOfLeadingZeros(n) + 1;
        int[][] jump = new int[n][maxLevel];

        int right = 0;
        for (int i = 0; i < n; i++) {
            while (right + 1 < n && sortedNums[right + 1] - sortedNums[i] <= maxDiff) {
                right++;
            }
            jump[i][0] = right;
        }

        for (int level = 1; level < maxLevel; level++) {
            for (int i = 0; i < n; i++) {
                jump[i][level] = jump[jump[i][level - 1]][level - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int u = indexMap[queries[i][0]];
            int v = indexMap[queries[i][1]];

            int start = Math.min(u, v);
            int end = Math.max(u, v);

            int res = minJumps(jump, start, end, maxLevel - 1);
            ans[i] = (res == Integer.MAX_VALUE) ? -1 : res;
        }

        return ans;
    }

    private int minJumps(int[][] jump, int start, int end, int level) {
        if (start == end) return 0;

        if (jump[start][0] >= end) return 1;

        if (jump[start][level] < end) return Integer.MAX_VALUE;

        int j = level;
        while (j >= 0 && jump[start][j] >= end) {
            j--;
        }

        return (1 << j) + minJumps(jump, jump[start][j], end, j);
    }
}