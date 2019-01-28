/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null)
            return "";
        
        return helper(root);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0)
            return null;
        
        Stack<Node> stack = new Stack();
        int temp = 0;
        Node root = new Node();
        Node node = root;
        
        while (temp < data.length() && Character.isDigit(data.charAt(temp))) {
            temp++;
        }
        root.val = Integer.parseInt(data.substring(0, temp));
        root.children = new ArrayList();
        
        for (int i = temp; i < data.length(); i++) {
            char c = data.charAt(i);
            
            if (Character.isDigit(c)) {
                temp = i;
                while (i < data.length() && Character.isDigit(data.charAt(i))) {
                    i++;
                }
                
                node = new Node();
                node.val = Integer.parseInt(data.substring(temp, i));
                node.children = new ArrayList();
                i--;
                
                Node parent = stack.peek();                
                parent.children.add(node);
            } else if (c == '[') {
                stack.push(node);
            }  else if (c == ']') {
                stack.pop();
            }
        }
        
        return root;
    }
    
    private String helper(Node node) {
        if (node.children.size() == 0)
            return String.valueOf(node.val);
        
        String output = node.val + "[";
        for (Node child: node.children) {            
            output = output + helper(child) + " ";
        }
        return output + "]";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));