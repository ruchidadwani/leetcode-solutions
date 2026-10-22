class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size = n*n;
        int[] hash = new int[size+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                hash[grid[i][j]]++;
            }
        }

        int a = -1, b = -1;

        for(int i=1; i<=size; i++) {
            if (hash[i] == 2)  {
                a = i;
            }
            else if (hash[i] == 0) {
                b = i;
            }
            if(a != -1 && b != -1) 
                break;
        }

        return new int[]{a,b};
    }
}