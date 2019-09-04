class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
            
        int median = (nums1.length + nums2.length)/2;
        int l = 0, r = nums1.length;
        
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums1[m] > nums2[median-m-1]) {
                r = m;
            } else {
                l = m+1;
            }
        }
        
        int idx1 = l, idx2 = median-l;
        int m1 = Math.min(idx1 == nums1.length ? nums2[idx2] : nums1[idx1], 
                          idx2 == nums2.length ? nums1[idx1] : nums2[idx2]);
        
        if ((nums1.length + nums2.length)%2 == 1)
            return m1;
        
        int m2 = Math.max(idx1 == 0 ? nums2[idx2-1] : nums1[idx1-1],
                          idx2 == 0 ? nums1[idx1-1] : nums2[idx2-1]);
        
        return (m1+m2)*0.5;
    }
}