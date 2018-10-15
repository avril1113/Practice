class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    HashMap<Integer, List<Integer>> levels = new HashMap();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        
        getLevelOrder(root, 0);
        
        return new ArrayList<List<Integer>>(levels.values());
    }
    
    void getLevelOrder(TreeNode node, int level) {
        List<Integer> list;
        
        if (levels.containsKey(level)) {
            list = levels.get(level);
        } else {
            list = new ArrayList();
            levels.put(level, list);
        }
        
        list.add(node.val);
        
        if (node.left != null)
            getLevelOrder(node.left, level+1);
        
        if (node.right != null)
            getLevelOrder(node.right, level+1);
    }
}