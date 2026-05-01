class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Create new array with 1 at both ends
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        // length is the distance between left and right
        for (int len = 2; len < n + 2; len++) {
            for (int left = 0; left + len < n + 2; left++) {
                int right = left + len;
                
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(
                        dp[left][right],
                        dp[left][k] + dp[k][right] + arr[left] * arr[k] * arr[right]
                    );
                }
            }
        }
        
        return dp[0][n + 1];
    }
}