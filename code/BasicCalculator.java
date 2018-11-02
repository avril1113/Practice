class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack();
        int output = 0, num = 0;
        int sign = 1;
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case ' ':
                    break;
                case '+':
                case '-':  
                    sign = c == '+' ? 1 : -1;
                    break;
                case '(':
                    stack.push(output);
                    stack.push(sign);
                    output = 0;
                    sign = 1;
                    break;
                case ')':
                    num = output*stack.pop();
                    output = stack.pop() + num;
                    break;
                default: 
                    num = Character.getNumericValue(c);
                    while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                        num = num * 10 + Character.getNumericValue(s.charAt(i+1));
                        i++;
                    }
                    
                    output = output + sign*num;
            } // End of switch
        }
        return output;
    }   
}