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
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        
        findPath(root, p, list1);
        findPath(root, q, list2);
        
        int len = Math.min(list1.size(), list2.size());
        
        for (int i = 0; i < len; i++) {
            if (list1.get(i).val != list2.get(i).val)
                return list1.get(i-1);
        }
        
        return list1.get(len-1);
    }
    
    private boolean findPath(TreeNode node, TreeNode target, List list) {        
        list.add(node);
        
        if (node == target) 
            return true;
        
        boolean found = false;
        
        if (node.left != null) {
            if (findPath(node.left, target, list))
                return true;
            
            list.remove(list.size() - 1);
        }
        
        if (node.right != null) {
            if (findPath(node.right, target, list))
                return true;
            
            list.remove(list.size() - 1);
        }
        
        return false;
    }
}