class Solution {
    List<List<String>> output = new ArrayList();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return output;
        
        getPartition(s, 0, new ArrayList<String>());
        
        return output;
    }
    
    void getPartition(String s, int index, List list) {
        for (int i = index+1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            
            if (helper(sub)) {
                List<String> partition = new ArrayList(list);
                partition.add(sub);
                
                if (i == s.length()) {
                    output.add(partition);
                } else {
                    getPartition(s, i, partition);
                }
            }
        }
    }
    
    boolean helper(String s) {
        for (int l = 0, r = s.length()-1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } 
        }
        
        return true;
    }
}