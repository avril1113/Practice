class Solution {
    public int numUniqueEmails(String[] emails) {
        int result = 0;
        HashMap<String, Set<String>> map = new HashMap<>();
        
        for (String email : emails) {
            String[] address = email.split("@");
            int index = address[0].indexOf("+");
            String local = address[0];
            if (index != -1)
                local = address[0].substring(0, index);
            
            local = local.replace(".", "");
            
            if (!map.containsKey(address[1]))
                map.put(address[1], new HashSet<String>());
            
            Set<String> set = map.get(address[1]);    
            
            if (!set.contains(local)) {
                result++;
                set.add(local);
            }
        }
        
        return result;
    }
}