public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        Queue<TreeLinkNode> queue = new LinkedList();
        queue.add(root);
        TreeLinkNode node;
        
        do {
            node = queue.remove();
            if (node.left != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                
                queue.add(node.left);
                queue.add(node.right); 
            }
        } while (!queue.isEmpty());
    }
}