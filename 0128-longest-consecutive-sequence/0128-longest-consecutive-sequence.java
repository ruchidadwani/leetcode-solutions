import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        // Step 2: Iterate through set
        for (int num : set) {
            
            // Only start if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                
                // Expand the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}