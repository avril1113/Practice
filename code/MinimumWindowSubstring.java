class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        
        if (s.equals(t))
            return s;
        
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int start = 0, notMatch = need.size(), len = s.length() + 1;
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (need.containsKey(cur)) {
                need.put(cur, need.get(cur) - 1);
                if (need.get(cur) == 0)
                    notMatch--;
                
                if (notMatch == 0) {
                    do {
                        if (len > (i-start+1)) {
                            result = s.substring(start, i+1);
                            len = result.length();
                        }
                                                                            
                        char startChar = s.charAt(start);
                        if (need.containsKey(startChar)) {
                            need.put(startChar, need.get(startChar) + 1);
                            
                            if (need.get(startChar) > 0)
                                notMatch++;
                        }

                        start++;
                    } while (notMatch == 0);
                }
            }
        }
        
        return result;
    }
}