class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);       // Odd length
            String even = expandAroundCenter(s, i, i + 1);   // Even length

            if (odd.length() > longest.length()) {
                longest = odd;
            }
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println(solver.longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(solver.longestPalindrome("cbbd"));  // Output: "bb"
    }
}
