class Solution {
    private int[][] maze;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length < 2 || maze[0].length < 2)
            return false;
        
        this.maze = maze;

        return dfs(start[0], start[1], destination);
    }
    
    private boolean dfs(int x, int y, int[] end) {
        if (maze[x][y] == 2)
            return false;
        
        if (end[0] == x && end[1] == y)
            return true;
        
        maze[x][y] = 2;
        
        // left
        int i = x;
        while (i > 0 && maze[i-1][y] != 1) {
            i--;
        }
        
        if (dfs(i, y, end))
            return true;
        
        // right
        i = x;
        while (i < maze.length-1 && maze[i+1][y] != 1) {
            i++;
        }
        
        if (dfs(i, y, end))
            return true;
        
        // up
        int j = y;
        while (j > 0 && maze[x][j-1] != 1) {
            j--;
        }
        
        if (dfs(x, j, end))
            return true;
        
        // down
        j = y;
        while (j < maze[0].length-1 && maze[x][j+1] != 1) {
            j++;
        }
        
        if (dfs(x, j, end))
            return true;
        
        return false;
    }
}