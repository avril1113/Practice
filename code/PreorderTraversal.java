class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> output = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return output;
        
        preorder(root);
        return output;
    }
    
    void preorder(TreeNode node) {
        output.add(node.val);
        
        if (node.left != null)
            preorder(node.left);
        
        if (node.right != null)
            preorder(node.right);
    }
}