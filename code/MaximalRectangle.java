class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int height, width, max = 0;
        int[] h = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
                
                height = h[j];
                
                for (int k = j; k >= 0; k--) {
                    if (height == 0)
                        break;
                    
                    height = Math.min(height, h[k]);
                    width = j - k + 1;
                    max = Math.max(max, height*width);
                }
            }
        }
        
        return max;
    }
}