class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }

    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        // Each row starts with 1
        ansRow.add(1);
        for(int col=1; col<row; col++) {
                ans = ans * (row-col);
                ans = ans / col;
                ansRow.add((int)ans);
            }
            return ansRow;
    }
}



/*class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // Each row starts with 1
            row.add(1);

            // Fill the middle elements
            for (int j = 1; j < i; j++) {
                int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(val);
            }

            // Each row ends with 1 if i > 0
            if (i > 0) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }

    // Main method to test
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        // Print the triangle
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
*/