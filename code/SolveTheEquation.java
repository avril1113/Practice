class Solution {
    public String solveEquation(String equation) {
        if (equation.length() == 0)
            return "No solution";
        
        int x = 0, v = 0, temp = 1;
        boolean negative = false, rightSide = false;
        
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == 'x') {
                if (negative)
                    temp = -temp;
                
                if (rightSide)
                    temp = -temp;
                
                x = x + temp;
                temp = 1;
            } else if (equation.charAt(i) == '=') {
                if (equation.charAt(i-1) != 'x') {
                    if (negative)
                        temp = -temp;
                
                    if (!rightSide)
                        temp = -temp;
                    
                    v = v + temp;
                    temp = 1;
                }
                
                rightSide = true;
                negative = false;
            } else if (equation.charAt(i) == '+') {
                if (i > 0 && Character.isDigit(equation.charAt(i-1))) {
                    if (negative)
                        temp = -temp;
                
                    if (!rightSide)
                        temp = -temp;
                    
                    v = v + temp;
                    temp = 1;
                }
                
                negative = false;
            } else if (equation.charAt(i) == '-') {
                if (i > 0 && Character.isDigit(equation.charAt(i-1))) {
                    if (negative)
                        temp = -temp;
                
                    if (!rightSide)
                        temp = -temp;
                    
                    v = v + temp;
                    temp = 1;
                }
                
                negative = true;
            } else {
                int len = 1;
                while (i+len < equation.length() && Character.isDigit(equation.charAt(i+len))) {
                    len++;
                }
                
                temp = Integer.valueOf(equation.substring(i, i+len));
                i = i + len - 1;
            }
        }
        
        if (equation.charAt(equation.length() - 1) != 'x') {
            if (negative)
                temp = -temp;
                
            if (!rightSide)
                temp = -temp;
                    
            v = v + temp;
        }
        
        if (x == 0 && v == 0)
            return "Infinite solutions";
        
        if (x != 0 && v == 0)
            return "x=0";
        
        if (x == 0 && v != 0)
            return "No solution";
        
        return "x=" + v/x;
    }
}