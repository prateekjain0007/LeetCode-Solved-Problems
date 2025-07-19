/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: root is null or root matches p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse on left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right returned non-null, this node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Else, return non-null side
        return (left != null) ? left : right;
    }
}
