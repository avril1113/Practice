class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        
        int output = 0, num = 0, temp = 0;
        int sign = 1;
        char c;
        
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case ' ':
                    break;
                case '+':
                case '-':  
                    output = output + sign*num;
                    
                    sign = c == '+' ? 1 : -1;
                    break;
                case '*':
                case '/':    
                    do {
                        i++;
                    } while (!Character.isDigit(s.charAt(i)));
                    
                    temp = Character.getNumericValue(s.charAt(i));
                             
                    while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                        temp = temp*10 + Character.getNumericValue(s.charAt(i+1));
                        i++;
                    }
                    
                    num = c == '*' ? num*temp : num/temp;
                    break;
                default:
                    num = Character.getNumericValue(c);
                    while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                        num = num*10 + Character.getNumericValue(s.charAt(i+1));
                        i++;
                    }
            }  // End of switch
        }
        
        return output + sign*num;
    }
}