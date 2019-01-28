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
        
        return preorder(root); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data.length() == 0)
            return null;
        
        String[] nodes = data.split(" ");
        return deserialize(nodes);
    }
    
    private String preorder(TreeNode node) {
        if (node == null)
            return "x";
        
        String output = node.val + " ";
        output = output + preorder(node.left) + " ";
        output = output + preorder(node.right);
        
        return output;
    }
    
    private int index = 0;
    public TreeNode deserialize(String[] data) {
        if (data[index].equals("x")) {
            index++;
            return null;
        }
        
        int value = Integer.parseInt(data[index]);
        TreeNode root = new TreeNode(value);
        index++;
        root.left = deserialize(data);
        root.right = deserialize(data);
        
        return root;
    }
}