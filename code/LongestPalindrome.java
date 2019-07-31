class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        Set<Character> chars = new HashSet<>();
        int result = 0;
        
        for (char c : s.toCharArray()) {
            if (!chars.add(c)) {
                result += 2;
                chars.remove(c);
            }
        }
        
        return result + (chars.size() > 0 ? 1:0);
    }
}