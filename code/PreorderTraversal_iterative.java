class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        
        if (root == null)
            return output;
        
        Stack<TreeNode> stack = new Stack();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                output.add(root.val);
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            root = root.right;
        }
        
        return output;
    }
}