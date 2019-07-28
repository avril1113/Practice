class Solution {    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][] path = new int[matrix.length][matrix[0].length];
        int max = 1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, Integer.MIN_VALUE, path));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int pre, int[][] path) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre)
            return 0;
        
        if (path[i][j] != 0)
            return path[i][j];
        
        int max = dfs(matrix, i-1, j, matrix[i][j], path);
        max = Math.max(max, dfs(matrix, i, j-1, matrix[i][j], path));
        max = Math.max(max, dfs(matrix, i+1, j, matrix[i][j], path));
        max = Math.max(max, dfs(matrix, i, j+1, matrix[i][j], path));
        path[i][j] = max+1;

        return max+1;
    }
}