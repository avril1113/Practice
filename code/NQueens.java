class Solution {
    List<List<String>> output = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0)
            return output;
        
        if (n == 1) {
            output.add(Arrays.asList("Q"));
            return output;
        }
        
        getPositions(new HashMap<Integer, Integer>(), 0, n);
        
        return output;
    }
    
    void getPositions(HashMap map,int index, int n) {
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < index; j++) {
                int temp = (int) map.get(j);
                if (i == temp || i == temp + (index-j) || i == temp - (index-j)) {
                    continue loop;
                }
                    
            }
            
            map.put(index, i);
            
            if (index+1 == n) {
                List<String> list = new ArrayList();
                String s;
                int location;
                for (int k = 0; k < n; k++) {
                    s = "";
                    location = (int) map.get(k);
                    for (int l = 0; l < n; l++) {
                        s = s + ((location == l) ? "Q" : ".");
                    }
                
                    list.add(s);
                }
            
                output.add(list);
            } else {
                
                getPositions(map, index+1, n);
            }
            map.remove(index);
        }
    }
}