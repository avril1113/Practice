class Solution {
    List<String> output = new ArrayList();
    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return output;
        
        helper(n, 0, 0, "");
        
        return output;
    }
    
    void helper(int n, int open, int close, String s) {
        if (open < n) 
            helper(n, open+1, close, s+"(");
        
        if (close < open)
            helper(n, open, close+1, s+")");
        
        if (s.length() == n*2)
            output.add(s);
    }
}