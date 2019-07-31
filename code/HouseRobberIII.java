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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        
        return dfs(root, new HashMap<TreeNode, Integer>());
    }
    
    private int dfs(TreeNode node, HashMap<TreeNode, Integer> maxValue) {
        if (node == null)
            return 0;
        
        if (maxValue.containsKey(node))
            return maxValue.get(node);
        
        int withCurrent = node.val;
        if (node.left != null)
            withCurrent += dfs(node.left.left, maxValue) + dfs(node.left.right, maxValue);
        
        if (node.right != null)
            withCurrent += dfs(node.right.left, maxValue) + dfs(node.right.right, maxValue);
        
        int withoutCurrent = dfs(node.left, maxValue) + dfs(node.right, maxValue);
        int max = Math.max(withCurrent, withoutCurrent);
        maxValue.put(node, max);
        
        return max;
    }
}