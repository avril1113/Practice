class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;
        
        int current = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (current == i && nums[i] == 0)
                return false;
            
            current = Math.max(current, i + nums[i]);
            
            if (current >= nums.length-1)
                return true;
        }
        
        return true;
    }
}