class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();

        // word -> index
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int n = word.length();

            // try every split
            for (int j = 0; j <= n; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1:
                // reverse(right) + word
                if (isPalindrome(left, 0, left.length() - 1)) {

                    String revRight =
                        new StringBuilder(right).reverse().toString();

                    Integer idx = map.get(revRight);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }

                // Case 2:
                // word + reverse(left)
                //
                // j != n avoids duplicates
                if (j != n &&
                    isPalindrome(right, 0, right.length() - 1)) {

                    String revLeft =
                        new StringBuilder(left).reverse().toString();

                    Integer idx = map.get(revLeft);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return ans;
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