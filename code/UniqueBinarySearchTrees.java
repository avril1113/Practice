class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int numTrees(int n) {
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);
        
        return getNumberOfBST(n);
    }
    
    int getNumberOfBST(int n) {
        if (map.containsKey(n))
            return map.get(n);
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
           sum = sum + getNumberOfBST(i)*getNumberOfBST(n-i-1);
        }
        
        map.put(n, sum);
        return sum;
    }
}