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
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return count;
        
        uniSubtree(root);
        
        return count;
    }
    
    private boolean uniSubtree(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        
        boolean left = true, right = true;
        
        if (node.left != null) {
            left = uniSubtree(node.left) && (node.val == node.left.val);
        }
        
        if (node.right != null) {
            right = uniSubtree(node.right) && (node.val == node.right.val);
        }
        
        if (left && right) {
            count++;
            return true;
        }
        
        return false;
    }
}