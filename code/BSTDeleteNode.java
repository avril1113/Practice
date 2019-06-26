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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        
        root = delete(root, key);
        
        return root;
    }
    
    private TreeNode delete(TreeNode node, int key) {
        if (node == null)
            return node;
        
        if (node.val == key) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right != null) {
                TreeNode newNode = node.right, cur;
                cur = newNode;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = node.left;
                return newNode;
            } else {
                if (node.left != null) {
                    return node.left;
                } else {
                    return node.right;
                }
            }
        
        } else if (node.val > key) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }
        
        return node;
    }
}