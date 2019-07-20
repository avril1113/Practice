/**
 *  Given a non-empty binary tree, find the maximum path sum.
 *
 *  For this problem, a path is defined as any sequence of nodes from some starting node
 *  to any node in the tree along the parent-child connections.
 *  The path must contain at least one node and does not need to go through the root.
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return max;
        
        max = root.val;
        maxSum(root);
        
        return max;
    }
    
    private int maxSum(TreeNode node) {
        int leftSum = 0, rightSum = 0;
        
        if (node.left != null) {
            leftSum = Math.max(maxSum(node.left), leftSum);
        }
        
        if (node.right != null) {
            rightSum = Math.max(maxSum(node.right), rightSum);
        }
        
        max = Math.max(max, leftSum + rightSum + node.val);
        
        return Math.max(leftSum, rightSum) + node.val;
    }
}