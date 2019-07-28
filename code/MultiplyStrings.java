class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1+len2];
        
        for (int i = len1-1; i >= 0; i--) {
            int c1Num = num1.charAt(i) - '0';
            for (int j = len2-1; j >= 0; j--) {
                int c2Num = num2.charAt(j) - '0';
                int sum = result[i+j+1] + c1Num*c2Num; 
                result[i+j+1] = sum%10;
                result[i+j] += sum/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n: result) {
            if (sb.length() == 0 && n == 0)
                continue;
            sb.append(n);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}