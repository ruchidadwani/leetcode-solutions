class Solution {
    public String convert(String s, int numRows) {
        // Edge case
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        // Traverse string
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Change direction at top or bottom
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}