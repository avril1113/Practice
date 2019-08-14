class Solution {
    public int longestDecomposition(String text) {
        if (text.length() < 2)
            return text.length();
        
        int len = text.length();
        for (int i = 1; i <= len/2; i++) {
            if (text.substring(0, i).equals(text.substring(len-i, len))) {
                return 2 + longestDecomposition(text.substring(i, len-i));
            }
        }
        
        return 1;
    }
}