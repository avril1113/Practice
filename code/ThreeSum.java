class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        
        if (nums == null || nums.length < 3)
            return output;
        
        Arrays.sort(nums);
        int left = 0, right = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            if (nums[i] + nums[i+1]+ nums[i+2] > 0)
                break;
            
            left = i+1;
            right = nums.length-1;
            
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                        
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                } else {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                }
            }
        }
        
        return output;
    }
}