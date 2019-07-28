class Solution {
    Set<String> passwords;
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1)
            return "0";
        
        int total = (int) Math.pow(k, n);
        passwords = new HashSet<>();
        String pass = "";
        
        for (int i = 0; i < n; i++)
            pass += "0";
        
        passwords.add(pass);
        
        return dfs(n, k, total, pass);
    }
    
    private String dfs(int n, int k, int total, String pass) {
        String prefix = pass.substring(pass.length()-n+1);
        
        for (int i = 0; i < k; i++) {
            String onePass = prefix + i;
            if (!passwords.contains(onePass)) {
                passwords.add(onePass);
                String result = dfs(n, k, total, pass + i);
                
                if (total == passwords.size())
                    return result;
                
                passwords.remove(onePass);
            }
        }
        
        return pass;
    }
}