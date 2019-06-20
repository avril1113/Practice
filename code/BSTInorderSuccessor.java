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
    private boolean found = false;
    private TreeNode res = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        
        if (root == p)
            return root.right;
        
        inorder(root, p);
        
        return res;
    }
    
    private void inorder(TreeNode node, TreeNode p) {
        if (node == null)
            return;
        
        inorder(node.left, p);
        
        if (found) {
            if (res == null)
                res = node;
            return;
        }
        
        if (node == p)
            found = true;
        
        inorder(node.right, p);
    }
}