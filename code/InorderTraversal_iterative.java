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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        
        if (root == null)
            return output;
        
        Stack<TreeNode> stack = new Stack();
        
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                output.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        
        return output;        
    }
}