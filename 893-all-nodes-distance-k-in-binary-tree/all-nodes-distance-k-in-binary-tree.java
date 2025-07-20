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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                for (TreeNode neighbor : getNeighbors(current, parentMap)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            currentDistance++;
        }

        // Collect nodes at distance k
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    private void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node.left != null) {
            parentMap.put(node.left, node);
            buildParentMap(node.left, parentMap);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            buildParentMap(node.right, parentMap);
        }
    }

    private List<TreeNode> getNeighbors(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        List<TreeNode> neighbors = new ArrayList<>();
        if (node.left != null) neighbors.add(node.left);
        if (node.right != null) neighbors.add(node.right);
        if (parentMap.containsKey(node)) neighbors.add(parentMap.get(node));
        return neighbors;
    }
}
