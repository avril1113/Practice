class Solution {
    Set<String> set = new HashSet<>();
    
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        
        if (sum%2 != 0)
            return false;
        
        return getSubset(nums, 0, sum/2);
    }
    
    private boolean getSubset(int[] nums, int idx, int target) {
        if (target == 0)
            return true;
        
        if (idx == nums.length || target < 0)
            return false;
        
        if (set.contains(idx + "_" + target))
            return false;
        
        if (getSubset(nums, idx + 1, target - nums[idx]))
            return true;
        
        if (getSubset(nums, idx + 1, target))
            return true;
        
        set.add(idx + "_" + target);
        return false;
    }
}