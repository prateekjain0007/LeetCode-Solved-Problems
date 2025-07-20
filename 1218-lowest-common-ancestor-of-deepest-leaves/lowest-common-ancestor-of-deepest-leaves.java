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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).node;
    }

    private Result helper(TreeNode root) {
        if (root == null)
            return new Result(null, 0);

        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else {
            return new Result(right.node, right.depth + 1);
        }
    }

    // Helper class to return both node and depth
    private class Result {
        TreeNode node;
        int depth;

        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}
