import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Sort by width ASC, and if equal width then height DESC
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // LIS on heights
        int[] lis = new int[envelopes.length];
        int size = 0;

        for (int[] env : envelopes) {
            int height = env[1];

            int idx = Arrays.binarySearch(lis, 0, size, height);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            lis[idx] = height;

            if (idx == size) {
                size++;
            }
        }

        return size;
    }
}