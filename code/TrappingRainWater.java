class Solution {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        
        int result = 0, l = 0, r = height.length-1, level = 0;
        
        while (l < r) {
            if (height[l] < height[r]) {
                level = height[l] > level ? height[l] : level;
                result = result + level - height[l];
                l++;
            } else {
                level = height[r] > level ? height[r] : level;
                result = result + level - height[r];
                r--;
            }
        }
        
        return result;
    }
}