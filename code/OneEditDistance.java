class Solution {
    private int sIndex = 0, tIndex = 0;
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 0 && t.length() == 0)
            return false;
        
        if (checkString(s, sIndex, t, tIndex)) {
            return false;
        } else {
            int i = sIndex, j = tIndex;
            return checkString(s, i, t, j+1) || checkString(s, i+1, t, j) || checkString(s, i+1, t, j+1) || checkString(s, i, t, j-1) || checkString(s, i-1, t, j);
        }
    }
    
    private boolean checkString(String s, int i, String t, int j) {
        for ( ;i >= 0 && j >= 0 && i < s.length() && j < t.length(); i++, j++) {
            sIndex = i;
            tIndex = j;
            if (s.charAt(i) != t.charAt(j))
                return false;
        }
        sIndex = i;
        tIndex = j;
        
        if (i == s.length() && j == t.length())
            return true;
        
        return false;
    }
}