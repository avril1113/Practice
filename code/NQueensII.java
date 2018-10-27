class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if (n == 0 || n ==1)
            return n;
        
        getPositions(new HashMap<Integer, Integer>(), 0, n);
        
        return count;
    }
    
    void getPositions(HashMap map, int index, int n) {
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < index; j++) {
                int temp = (int) map.get(j);
                if (i == temp || i == temp + (index-j) || i == temp - (index-j)) {
                    continue loop;
                }
            }
            
            map.put(index, i);
            
            if (index+1 == n) {
                count++;
            } else {
                getPositions(map, index+1, n);
            }
            
            map.remove(index);
        }
    }
}