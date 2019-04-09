class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        String[] strings = s.trim().split("\\s+");
        String output = "";
        
        for (String str: strings) {
            output = str + " " + output;
        }
        
        return output.trim();
    }
}