class Solution {
    HashMap<Integer, HashSet<Integer>> grid = new HashMap();
    HashMap<Integer, HashSet<Integer>> row = new HashMap();
    HashMap<Integer, HashSet<Integer>> col = new HashMap();
    Stack<Integer> stack = new Stack();
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!row.containsKey(i))
                row.put(i, new HashSet<Integer>());
            
            for (int j = 0; j < 9; j++) {
                if (!col.containsKey(j))
                    col.put(j, new HashSet<Integer>());
                
                int temp = i/3*3 + j/3;
                if (!grid.containsKey(temp))
                    grid.put(temp, new HashSet<Integer>());
                
                if (board[i][j] == '.') {
                    stack.push(i*9+j);
                } else {
                    row.get(i).add(Character.getNumericValue(board[i][j]));
                    col.get(j).add(Character.getNumericValue(board[i][j]));
                    grid.get(temp).add(Character.getNumericValue(board[i][j]));
                }
            }
        }
        
        if (!stack.isEmpty()) {
            puzzleSolver(board);
        }
    }
    
    boolean puzzleSolver(char[][] board) {
        int location = stack.pop();
        int i = location/9;
        int j = location%9;
        int g = i/3*3 + j/3;
        
        for (int n = 1; n <= 9; n++) {            
            if (row.get(i).contains(n) || col.get(j).contains(n) || grid.get(g).contains(n))
                continue;
            
            board[i][j] = Character.forDigit(n, 10);
            row.get(i).add(n);
            col.get(j).add(n);
            grid.get(g).add(n);
            
            if (stack.isEmpty()) 
                return true;
            
            if (puzzleSolver(board)) 
                return true;
                
            board[i][j] = '.';
            row.get(i).remove(n);
            col.get(j).remove(n);
            grid.get(g).remove(n);
        }
        
        stack.push(location);
        return false;
    }
}