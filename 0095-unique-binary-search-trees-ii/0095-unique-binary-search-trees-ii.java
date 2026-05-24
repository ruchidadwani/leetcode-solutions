/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // Empty tree
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every number as root
        for (int root = start; root <= end; root++) {

            // Generate all left subtrees
            List<TreeNode> leftTrees = build(start, root - 1);

            // Generate all right subtrees
            List<TreeNode> rightTrees = build(root + 1, end);

            // Combine left and right subtrees
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;

                    result.add(node);
                }
            }
        }

        return result;
    }
}