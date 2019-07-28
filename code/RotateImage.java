class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2)
            return;
        
        int start = 0, end = matrix.length-1;
        
        while (start < end) {
            for (int i = 0; i < end-start; i++) {
                int swap = matrix[start][start+i];
                matrix[start][start+i] = matrix[end-i][start];
                matrix[end-i][start] = matrix[end][end-i];
                matrix[end][end-i] = matrix[start+i][end];
                matrix[start+i][end] = swap;
            }
            
            start++;
            end--;
        }
    }
}