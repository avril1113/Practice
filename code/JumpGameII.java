class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        
        int current = nums[0], jumps = 1, farest = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (i == current) {
                jumps++;
                current = farest;
            }
        }
        
        return jumps;
    }
}




// class Solution {
//     public int jump(int[] nums) {
//         if (nums == null || nums.length <= 1)
//             return 0;
//        
//         int last = nums.length-1;
//         int[] jumps = new int[last];
//         int min;
//         for (int i = last-1; i >= 0; i--) {
//             if (nums[i] == 0) {
//                 jumps[i] = last;
//             } else if (i + nums[i] >= last) {
//                 jumps[i] = 1;
//             } else {
//                 min = jumps[i+1];
//                 for (int j = i+2; j < last && j <= i+nums[i]; j++) {
//                     min = Math.min(min, jumps[j]);
//                 }
//                 jumps[i] = 1 + min;
//             }    
//         }     
//         return jumps[0];
//     }
// }