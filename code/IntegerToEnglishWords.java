class Solution {
    String[] less20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        String result = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num%1000) + " " + thousands[i] + " " + result;
            }
            
            num = num / 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String helper(int num) {
        String output = "";
        
        if (num % 100 < 20) {
            output = less20[num%100];
        } else {
            output = tens[(num%100)/10] + " " + less20[num%10];
        }
        
        if ((num % 1000)/100 != 0)
            output = less20[(num%1000)/100] + " Hundred " + output;
        
        return output.trim();
    }
}