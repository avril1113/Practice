/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<String>());
    }
    
    private void dfs(Robot robot, int x, int y, int dir, Set visited) {
        if (visited.contains(x + "," + y))
            return;
        
        robot.clean();
        visited.add(x + "," + y);
        
        for (int i = 0; i < dirs.length; i++) {
            int xx = x + dirs[dir][0];
            int yy = y + dirs[dir][1];
            
            if (robot.move()) {
                dfs(robot, xx, yy, dir, visited);
                back(robot);
            }
            
            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }
    
    private void back(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}