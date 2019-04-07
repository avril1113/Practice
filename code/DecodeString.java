class Solution {
    public String decodeString(String s) {
        if (s == null || s == "")
            return s;
        
        String cur = "";
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(Character.toString(c));
            } else {
                String temp = "";
                cur = stack.pop();
                while (!cur.equals("[")) {
                    temp = cur + temp;
                    cur = stack.pop();
                }
                
                cur = stack.pop();
                while (!stack.isEmpty() && stack.peek().matches("\\d+")) {
                    cur = stack.pop() + cur;
                }
                int count = Integer.valueOf(cur);
                cur = "";
                for (int j = 0; j < count; j++) {
                    cur = cur + temp;
                }
                
                stack.push(cur);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
            
        return result;
    }
}