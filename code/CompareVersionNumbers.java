class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length), num1, num2;
        
        for (int i = 0; i < len; i++) {
            if (i < v1.length && i < v2.length) {
                num1 = Integer.valueOf(v1[i]);
                num2 = Integer.valueOf(v2[i]);
                
                if (num1 != num2)
                    return num1 > num2 ? 1 : -1;
            } else if (i < v1.length) {
                while (i < v1.length && Integer.valueOf(v1[i]) == 0) {
                    i++;
                }
                
                if (i < v1.length)
                    return 1;
            } else {
                while (i < v2.length && Integer.valueOf(v2[i]) == 0) {
                    i++;
                }
                
                if (i < v2.length)
                    return -1;
            }
        }
        
        return 0;
    }
}