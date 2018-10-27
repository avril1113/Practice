class Solution {
    List<String> output = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return output;
        
            getIpAddress(s, 0, "", 0);
        
            return output;
    }
        
    void getIpAddress(String s, int index, String ip, int count) {
        for (int i = 1; index+i <= s.length(); i++) {
            if (s.charAt(index) == '0' && i > 1)
                return;
            
            int d = Integer.valueOf(s.substring(index, index+i));
            
            if (d >= 0 && d < 256) {                    
                if (index+i == s.length() && count == 3) {
                    output.add(ip + d);
                } else if (index+i < s.length() && count < 3) {
                    getIpAddress(s, index+i, ip + d + ".", count+1);
                }   
            } else {
                return;
            }
        }
    }      
}