class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0, lefts = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                lefts++;
            } else {
                if (lefts > 0) {
                    stack.pop();
                    lefts--;
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        
        return max;
    }
}