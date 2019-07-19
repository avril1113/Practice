class Solution {
    public int oddEvenJumps(int[] A) {
        if (A.length == 1)
            return 1;
        
        int result = 1, len = A.length-1;
        TreeMap<Integer, boolean[]> map = new TreeMap<>();
        map.put(A[len], new boolean[]{true, true});
        
        for (int i = len-1; i >= 0 ; i--) {
            boolean[] cur = new boolean[]{false, false};
            Integer up = map.ceilingKey(A[i]);
            Integer down = map.floorKey(A[i]);
            
            if (up != null) {
                boolean[] next = map.get(up);
                cur[0] = next[1];
                
                if (next[1])
                    result++;
            }
            
            if (down != null) {
                boolean[] next = map.get(down);
                cur[1] = next[0];
            }
            
            map.put(A[i], cur);
        }
        
        return result;
    }
}