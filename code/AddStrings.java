class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        char[] result = new char[Math.max(n1.length, n2.length)];
        int idx1 = n1.length-1, idx2 = n2.length-1, idx = result.length-1;
        int carry = 0;
        
        while (idx1 >= 0 && idx2 >= 0) {
            int temp = (n1[idx1--] - '0') + (n2[idx2--] - '0') + carry;
            carry = temp/10;
            result[idx--] = (char)(temp%10 + '0');
        }
        
        while (idx1 >= 0) {
            int temp = (n1[idx1--] - '0') + carry;
            carry = temp/10;
            result[idx--] = (char)(temp%10 + '0');
        }
        
        while (idx2 >= 0) {
            int temp = (n2[idx2--] - '0') + carry;
            carry = temp/10;
            result[idx--] = (char)(temp%10 + '0');
        }
        
        return carry == 0 ? String.valueOf(result) : "" + carry + String.valueOf(result); 
    }
}