class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char c : word.toCharArray()) {
                sum = (sum + weights[c - 'a']) % 26;
            }

            ans.append((char) ('a' + (25 - sum)));
        }

        return ans.toString();
    }
}