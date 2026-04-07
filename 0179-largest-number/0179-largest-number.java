import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        
        // Convert to string
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sort
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if largest is "0"
        if (arr[0].equals("0")) return "0";

        // Build result
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}