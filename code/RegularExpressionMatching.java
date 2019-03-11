class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        
        return isMatch(s, p, 0, 0);
    }
    
    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length();
        
        if (j < p.length() - 1 && p.charAt(j+1) == '*') {
            if (i < s.length() && (p.charAt(j) == '.'|| s.charAt(i) == p.charAt(j))) {
                return isMatch(s, p, i+1, j) || isMatch(s, p, i, j+2);
            } else {
                return isMatch(s, p, i, j+2);
            }
        }
        
        if (i < s.length() && (p.charAt(j) == '.'|| s.charAt(i) == p.charAt(j))) {
            return isMatch(s, p, i+1, j+1);
        }
        
        return false;
    }
}