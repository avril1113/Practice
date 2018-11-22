class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int left = 0, right = nums.length-1, middle, start = -1, end = -1;
        
        while (left <= right) {
            middle = left + (right - left)/2;
            
            if (nums[middle] >= target) {
                right = middle-1;
                
                if (nums[middle] == target) {
                    start = middle;
                }
            } else {
                left = middle+1;
            }
        }
        
        if (start == -1)
            return new int[]{-1, -1};
        
        right = nums.length-1;
        
        while (left <= right) {
            middle = left + (right - left)/2;
            
            if (nums[middle] <= target) {
                left = middle+1;
                
                if (nums[middle] == target) {
                    end = middle;
                }
            } else {
                right = middle-1;
            }
        }
        
        return new int[]{start, end};
    }
}