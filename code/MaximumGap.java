/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 */


class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        
        int min = nums[0], max = nums[0];
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if (min == max)
            return 0;
        
        int gap = (max - min)/nums.length +1;
        int[] maxBucket = new int[nums.length];
        int[] minBucket = new int[nums.length];
        Arrays.fill(maxBucket, -1);
        Arrays.fill(minBucket, -1);
        
        for (int num : nums) {
            int n = (num-min)/gap;
            
            if (maxBucket[n] == -1) {
                maxBucket[n] = num;
                minBucket[n] = num;
            } else {
                maxBucket[n] = Math.max(maxBucket[n], num);
                minBucket[n] = Math.min(minBucket[n], num);
            }
        }
        
        int result = 0, pre = min;
        for (int i = 0; i < nums.length; i++) {
            if (minBucket[i] == -1)
                continue;
            
            result = Math.max(result, minBucket[i] - pre);
            pre = maxBucket[i];
        }
        
        return result;
    }
}