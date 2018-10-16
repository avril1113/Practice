class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i+1 || nums[i] < 1 || nums[i] > nums.length || nums[i] == nums[nums[i]-1])
                continue;
            
            swap(nums, i, nums[i]-1);
            i--;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        
        return nums.length+1;
    }
    
    void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}