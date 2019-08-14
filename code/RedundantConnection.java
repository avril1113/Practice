class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            roots[i] = i;
        }
        
        int[] result = new int[2];
        for (int[] edge : edges) {
            int root1 = find(edge[0]-1, roots);
            int root2 = find(edge[1]-1, roots);
            
            if (root1 == root2)
                result = edge;
            
            roots[root1] = root2;
        }
        
        return result;
    }
    
    private int find(int target, int[] uf) {
        if (target == uf[target]) 
            return target;
        
        uf[target] = find(uf[target], uf);
        return uf[target]; 
    }
}