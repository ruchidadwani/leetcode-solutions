/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the leftmost node of each level
        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;

            while (current != null) {

                // Connect left child -> right child
                current.left.next = current.right;

                // Connect right child -> next node's left child
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to next node in current level
                current = current.next;
            }

            // Move to next level
            leftMost = leftMost.left;
        }

        return root;
    }
}