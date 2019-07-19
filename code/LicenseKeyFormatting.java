class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0 || K == 0)
            return "";
        
        S = S.replace("-", "").toUpperCase();
        
        if (S.length() == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        int idx = S.length()%K == 0 ? K:S.length()%K;
        
        sb.append(S.substring(0, idx));
        
        while (idx < S.length()) {
            sb.append("-");
            sb.append(S.substring(idx, idx+K));
            idx += K;
        }
        
        return sb.toString();
    }
}