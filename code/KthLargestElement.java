class Solution {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length-1, k);
    }
    
    private int select(int[] arr, int left, int right, int k) {
        if (left == right)
            return arr[left];
        
        int p = right, r = right-1, l = left;
        
        while (l < r) {
            if (arr[l] <= arr[p]) {
                l++;
            } else if (arr[r] > arr[p]) {
                r--;
            } else {
                swap(arr, l, r);
                l++;
            }
        }
        
        if (arr[r] > arr[p]) {
            swap(arr, r, p);
            p = r;
        }
        
        if (p == arr.length - k)
            return arr[p];
        
        if (p > arr.length - k)
            return select(arr, left, p-1, k);
        
        return select(arr, p+1, right, k);
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}