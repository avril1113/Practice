class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words.length == 0)
            return result;
        
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        int total = len * words.length;
        
        if (s.length() < total)
            return result;
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Map<String, Integer> container;
        String temp;
        
        for (int i = 0; i+total <= s.length(); i++) {
            temp = s.substring(i, i+len);
            if (map.containsKey(temp)) {
                int last;
                if (result.size() > 0 && i - (last = result.get(result.size()-1)) == len) {
                    if (s.substring(last, last+len).equals(s.substring(i+total-len, i+total))) {
                        result.add(i);
                    }
                } else {
                    container = new HashMap<>(map);
                
                    for (int j = i; j+len <= s.length(); j += len) {
                        temp = s.substring(j, j+len);
                
                        if (container.containsKey(temp)) {
                            container.put(temp, container.get(temp) - 1);
                
                            if (container.get(temp) == 0)
                                container.remove(temp);
                        } else {
                            break;
                        }
                    }
            
                    if (container.isEmpty()) {
                        result.add(i);
                    }
                }
            }
        }

        return result;
    }
}