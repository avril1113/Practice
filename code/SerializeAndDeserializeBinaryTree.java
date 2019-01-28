/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        
        return helper(root); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        
        boolean negative = false;
        int temp = 0;
        Stack<TreeNode> stack = new Stack();
        
        if (data.charAt(0) == '-')
            temp++;
        
        while (temp < data.length() && Character.isDigit(data.charAt(temp))) {
            temp++;
        }
        
        int value = Integer.parseInt(data.substring(0, temp));
        TreeNode root = new TreeNode(value);
        TreeNode node = root;
        
        for (int i = temp; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c)) {
                temp = i + 1;
                while (temp < data.length() && Character.isDigit(data.charAt(temp))) {
                    temp++;
                }
                
                value = Integer.parseInt(data.substring(i, temp));
                if (negative)
                    value = -value;
                    
                node = new TreeNode(value);                
                TreeNode parent = stack.peek();
                if (data.charAt(i-1) == ' ') {
                    parent.right = node;
                } else {
                    parent.left = node;
                }
                i = temp-1;
                negative = false;
            } else if (c == '-') {
                negative = true;
            } else if (c == '[') {
                stack.push(node);
            } else if (c == ']') {
                stack.pop();
            }
        }
            
        return root;
    }
    
    private String helper(TreeNode node) {
        if (node.left == null && node.right == null)
            return String.valueOf(node.val);
        
        String s = node.val + "[";
        if (node.left != null) {
            s = s + helper(node.left) + " ";
        } else {
            s = s + "x "; 
        }
        
        if (node.right != null) {
            s = s + helper(node.right);
        } else {
            s = s + "x";
        }
            
        return s + "]";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));