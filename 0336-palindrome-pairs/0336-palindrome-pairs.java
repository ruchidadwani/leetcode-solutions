import java.util.*;

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        // reversed word -> index
        Map<String, Integer> map = new HashMap<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();

            // split word into prefix + suffix
            for (int cut = 0; cut <= len; cut++) {

                String left = word.substring(0, cut);
                String right = word.substring(cut);

                // Case 1:
                // left is palindrome
                // find reverse(right) + word
                if (isPalindrome(left, 0, left.length() - 1)) {

                    String revRight = new StringBuilder(right).reverse().toString();

                    Integer idx = map.get(revRight);

                    if (idx != null && idx != i) {
                        res.add(Arrays.asList(idx, i));
                    }
                }

                // Case 2:
                // right is palindrome
                // find word + reverse(left)
                //
                // cut != len prevents duplicates
                if (cut != len &&
                    isPalindrome(right, 0, right.length() - 1)) {

                    String revLeft = new StringBuilder(left).reverse().toString();

                    Integer idx = map.get(revLeft);

                    if (idx != null && idx != i) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}