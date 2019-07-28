class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> existed = new HashMap<>();
        int result = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            existed.put(cur, existed.getOrDefault(cur, 0) + 1);
            
            while (existed.size() > k) {
                char startChar = s.charAt(start);
                existed.put(startChar, existed.get(startChar) - 1);
                if (existed.get(startChar) == 0)
                    existed.remove(startChar);
                
                start++;
            }
            
            result = Math.max(result, i-start+1);
        }
        
        return result;
    }
}