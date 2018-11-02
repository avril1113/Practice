class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, index= -1, match = 0;
        
        while (i < s.length()) { 
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                while (p.charAt(j) == '*') {
                    if (j == p.length()-1)
                        return true;
                    
                    j++;
                }
                
                index = j;
                match = i;
            } else if (index != -1) {
                match++;
                i = match;
                j = index;
            } else {
                return false;
            }
        }
        
        for (;j < p.length(); j++) {
            if (p.charAt(j) != '*')
                return false;            
        }
        
        return true;
    }
}