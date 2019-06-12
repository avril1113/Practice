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
    List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;         
    }
    
    private void inorder(TreeNode node) {
        if (node == null)
            return;
        
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}