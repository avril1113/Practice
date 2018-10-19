class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int removeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                removeCount++;
            } else if (removeCount != 0) {
                nums[i-removeCount] = nums[i];
            }
        }
        
        return nums.length-removeCount;
    }
}