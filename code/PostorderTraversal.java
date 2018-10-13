class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> output = new ArrayList();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return output;
        
        postorder(root);
        
        return output;
    }
    
    void postorder(TreeNode node) {
        if (node.left != null)
            postorder(node.left);
        
        if (node.right != null)
            postorder(node.right);
        
        output.add(node.val);
    }
}