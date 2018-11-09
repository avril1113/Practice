class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int numDecodings(String s) {
        return helper(s, 0);
    }
    
    int helper(String s, int index) {
        if (map.containsKey(index))
            return map.get(index);
        
        if (index < s.length() && s.charAt(index) == '0')
            return 0;
        
        if (index == s.length()-1 || index == s.length())
            return 1;
        
        int count = 0;
        int temp = (s.charAt(index) - '0') * 10 + (s.charAt(index+1) - '0');
        if (temp > 0 && temp < 27 && index + 2 <= s.length()) {
            count = helper(s, index+1) + helper(s, index+2);
        } else {
            count = helper(s, index+1);
        }
        
        map.put(index, count);
        return count;
    }
}