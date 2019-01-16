class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        
        invert(root);
        
        return root;
    }
    
    void invert(TreeNode node) {
        if (node.left == null && node.right == null)
            return;
        
        if (node.left != null)
            invert(node.left);
        
        if (node.right != null)
            invert(node.right);
        
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
    }
}