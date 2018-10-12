class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> output = new ArrayList();
        
        if (n == 0)
            return output;
        
        if (n == 1) {
            output.add(new TreeNode(1));
            return output;
        }
        
        return getBSTStructure(1, n);
    }
    
    List<TreeNode> getBSTStructure(int start, int end) {
        List<TreeNode> list = new ArrayList();
        if (start > end) {
            list.add(null);
            return list;
        }
        
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftside = getBSTStructure(start, i-1);
            List<TreeNode> rightside = getBSTStructure(i+1, end);
            
            for (int l = 0; l < leftside.size(); l++) {
                for (int r = 0; r < rightside.size(); r++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftside.get(l);
                    root.right = rightside.get(r);
                    list.add(root);
                }
            }
        }
        
        return list;
    }
    
}