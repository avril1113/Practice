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
        if (root == null || p == null || q == null) 
            return null;
        
        return locate(root, p, q);
    }
    
    private TreeNode locate(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        
        TreeNode left = locate(node.left, p, q);
        TreeNode right = locate(node.right, p, q);
        
        if (node == p || node == q)
            return node;
        
        if (left != null && right != null) {
            return node;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }
    }
}