class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || target == null)
            return -1;
        
        if (source.length() == 0 && target.length() != 0)
            return -1;
        
        HashMap<Character, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            List<Integer> list = dict.getOrDefault(c, new ArrayList<>());
            list.add(i);
            dict.put(c, list);
        }
        
        int result = 0, idx = 0;
        while (idx < target.length()) {
            char c = target.charAt(idx);
            int sIdx = -1;
            do {
                sIdx = searchNext(target.charAt(idx), sIdx, dict);
                if (sIdx == -1)
                    return -1; 
                
                if (sIdx == -2)
                    break;
                
                idx++;
            } while (idx < target.length() && sIdx < source.length() - 1);
            
            result++;
        }
        
        return result;
    }
    
    private int searchNext(char ch, int idx, Map<Character, List<Integer>> dict) {
        if (!dict.containsKey(ch))
            return -1;
                        
        List<Integer> list = dict.get(ch); 
        int l = 0, r = list.size()-1;
        if (list.get(r) <= idx)
            return -2;
        
        while (l <= r) {
            int m = l + (r-l)/2;
            if (list.get(m) > idx)
                r = m-1;
            else
                l = m+1;
        }
        
        return list.get(l);
    }
}