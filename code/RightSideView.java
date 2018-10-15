class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public List<Integer> rightSideView(TreeNode root) {        
        if (root == null)
            return new ArrayList<Integer>();
        
        getRightSideView(root, 0);
        
        return new ArrayList<Integer>(map.values());
    }
    
    void getRightSideView(TreeNode node, int height) {
        if (!map.containsKey(height)) {
            map.put(height, node.val);
        } 
        
        if (node.right != null) 
            getRightSideView(node.right, height+1);
        
        if (node.left != null)
            getRightSideView(node.left, height+1);
    }  
}