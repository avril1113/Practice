class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0 || K == 0)
            return new int[0][0];
        
        int l = 0, r = points.length-1, p;
        
        while (l <= r) {
            p = partition(points, l, r);
            System.out.println(p);
            if (p == K) {
                break;
            } else if (p > K) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] arr, int l, int r) {
        int[] pivot = arr[r];
        int index = r;
        r = r - 1;
        while (l <= r) {
            while (l <= r && isLarger(pivot, arr[l])) {
                l++;
            }
            
            while (l <= r && isLarger(arr[r], pivot)) {
                r--;
            }
            
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        
        swap(arr, index, l);
        
        return l;
    }
    
    private boolean isLarger(int[] a, int[] b) {
        if (a[0]*a[0] + a[1]*a[1] > b[0]*b[0] + b[1]*b[1])
            return true;
        
        return false;
    }
    
    private void swap(int[][] arr, int a, int b) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}