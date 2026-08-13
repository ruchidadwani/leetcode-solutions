class Solution {

    class Node {
        char leftChar, rightChar;
        int prefix, suffix, best, len;

        Node(char lc, char rc, int p, int s, int b, int l) {
            leftChar = lc;
            rightChar = rc;
            prefix = p;
            suffix = s;
            best = b;
            len = l;
        }
    }

    Node[] tree;
    String s;

    // Merge two nodes
    Node merge(Node a, Node b) {

        Node res = new Node(
            a.leftChar,
            b.rightChar,
            0, 0, 0,
            a.len + b.len
        );

        // Prefix
        res.prefix = a.prefix;

        if (a.prefix == a.len && a.rightChar == b.leftChar) {
            res.prefix = a.len + b.prefix;
        }

        // Suffix
        res.suffix = b.suffix;

        if (b.suffix == b.len && a.rightChar == b.leftChar) {
            res.suffix = b.len + a.suffix;
        }

        // Best
        res.best = Math.max(a.best, b.best);

        // Substring crossing the boundary
        if (a.rightChar == b.leftChar) {
            res.best = Math.max(
                res.best,
                a.suffix + b.prefix
            );
        }

        return res;
    }

    // Build segment tree
    void build(int node, int start, int end) {

        if (start == end) {
            char c = s.charAt(start);
            tree[node] = new Node(c, c, 1, 1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Update one position
    void update(int node, int start, int end,
                int index, char c) {

        if (start == end) {
            tree[node] = new Node(c, c, 1, 1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, end, index, c);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s;

        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}