class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                update(board, i , j);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }    
            }
        }
    }
    
    private void update(int[][] board, int i, int j) {
        int count = 0;
        
        if (i > 0 && board[i-1][j]%2 == 1)
            count++;
        
        if (i < board.length-1 && board[i+1][j]%2 == 1)
            count++;
        
        if (j > 0 && board[i][j-1]%2 == 1)
            count++;
        
        if (j < board[0].length-1 && board[i][j+1]%2 == 1)
            count++;
        
        if (i > 0 && j > 0 && board[i-1][j-1]%2 == 1)
            count++;
        
        if (i < board.length-1 && j > 0 && board[i+1][j-1]%2 == 1)
            count++;
        
        if (i > 0 && j < board[0].length-1 && board[i-1][j+1]%2 == 1)
            count++;
        
        if (j < board[0].length-1 && i < board.length-1 && board[i+1][j+1]%2 == 1)
            count++;
        
        if (board[i][j] == 0 && count == 3) {
            board[i][j] = 2;
        } else if (board[i][j] == 1 && (count == 2 || count == 3)) {
            board[i][j] = 3;
        }
    }
}