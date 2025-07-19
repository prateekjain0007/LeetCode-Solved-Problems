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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            boolean foundX = false;
            boolean foundY = false;

            int size = queue.size();  // Number of nodes at this level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if current node has both children as x and y
                if (current.left != null && current.right != null) {
                    int l = current.left.val;
                    int r = current.right.val;
                    if ((l == x && r == y) || (l == y && r == x)) {
                        return false;  // Same parent
                    }
                }

                // Check current node’s children
                if (current.left != null) {
                    if (current.left.val == x) foundX = true;
                    if (current.left.val == y) foundY = true;
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    if (current.right.val == x) foundX = true;
                    if (current.right.val == y) foundY = true;
                    queue.offer(current.right);
                }
            }

            // After one level
            if (foundX && foundY) return true;     // same level, different parents
            if (foundX || foundY) return false;    // found only one this level
        }

        return false;
    }
}
