class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    map[i][j] = grid[i][j];
                } else if (i == 0) {
                    map[i][j] = map[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    map[i][j] = map[i-1][j] + grid[i][j];
                } else {
                    map[i][j] = Math.min(map[i][j-1], map[i-1][j]) + grid[i][j];
                }
            }
        }
        
        return map[m-1][n-1];
    }
}