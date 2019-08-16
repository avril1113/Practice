class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid.length < 2 || grid[0].length < 2)
            return 0;
        
        int row = grid.length, col = grid[0].length, result = 0;
        for (int i = 0; i < row-1; i++) {
            for (int j = i+1; j < row; j++) {
                int edge = 0;
                
                for (int k = 0; k < col; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1)
                        edge++;
                }
                
                result += edge*(edge-1)/2;
            }
        }
        
        return result;
    }
}