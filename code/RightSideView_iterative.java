class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList();
        
        if (root == null)
            return output;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int size = 0;
        TreeNode node = null;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                
                if (node.right != null)
                    queue.offer(node.right);
            }
            output.add(node.val);
        }
        
        return output;
    }
}