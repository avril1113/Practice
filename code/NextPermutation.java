class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        
        int idx = nums.length - 1;
        while (nums[idx] <= nums[idx-1]) {
            idx--;
            if (idx == 0)
                break;
        }
        
        if (idx == 0) {
            Arrays.sort(nums);
            return;
        }
        
        for (int i = nums.length-1; i >= idx; i--) {
            if (nums[i] > nums[idx-1]) {
                int swap = nums[i];
                nums[i] = nums[idx-1];
                nums[idx-1] = swap;
                break;
            }
        }
        
        Arrays.sort(nums, idx, nums.length);
    }
}