class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        HashSet<String> shape = new HashSet<>();
            
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, i*grid[0].length + j, sb);
                    shape.add(sb.toString());
                }
            }
        }
        
        return shape.size();
    }
    
    private void dfs(int[][] grid, int x, int y, int start, StringBuilder sb) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
            return;
        
        grid[x][y] = 0;
        int pos = x*grid[0].length + y - start; 
        sb.append(pos);
        sb.append(".");
        dfs(grid, x-1, y, start, sb);
        dfs(grid, x, y+1, start, sb);
        dfs(grid, x+1, y, start, sb);
        dfs(grid, x, y-1, start, sb);
    }
}