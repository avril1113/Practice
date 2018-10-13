class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        
        if (root == null)
            return output;
        
        Stack<TreeNode> stack = new Stack();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode temp = stack.peek();
            
            if (temp.right != null) {
                root = temp.right;
            } else {
                temp = stack.pop();
                output.add(temp.val);
                
                while (!stack.isEmpty() && stack.peek().right == temp) {
                    temp = stack.pop();
                    output.add(temp.val);
                }
            }
        }
        
        return output;
    }
}