class Solution {
    Set<String> set = new HashSet<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length())
            return false;
        
        return helper(s1, s2, s3);
    }
    
    private boolean helper(String s1, String s2, String s3) {
        if (s3.length() == 0)
            return true;
            
        if (set.contains(s1 + "&" + s2))
            return false;
        
        if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0))
            if (helper(s1.substring(1), s2, s3.substring(1)))
                return true;
        
        if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0))
            if (helper(s1, s2.substring(1), s3.substring(1)))
                return true;
        
        set.add(s1 + "&" + s2);
        return false;
    }
}