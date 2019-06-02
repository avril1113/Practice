class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1)
            return;
        
        int n = matrix.length;
        int left = 0, top = 0, right = n-1, bottom = n-1;
        
        while (left < right) {
            for (int i = 0; i < right-left; i++) {
                int temp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = temp;
            }
            
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}