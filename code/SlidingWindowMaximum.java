class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k)
            return new int[]{};
        
        int[] output = new int[nums.length - k + 1];
        
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        
        PriorityQueue<Integer> queue = new PriorityQueue(comparator);
        
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            
            if (queue.size() > k) {
                queue.remove(nums[i-k]);
                output[i-k+1] = queue.peek();
            } else if (queue.size() == k) {
                output[i-k+1] = queue.peek(); 
            }
        }
        
        return output;
    }
}