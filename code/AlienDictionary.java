class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        int count = 0;
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == 0) {
                    inDegree[c - 'a'] = 1;
                    count++;
                }    
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i+1].toCharArray();
            int len = Math.min(w1.length, w2.length);
            
            for (int j = 0; j < len; j++) {
                if (w1[j] != w2[j]) {
                    if (!map.containsKey(w1[j])) {
                        map.put(w1[j], new HashSet<Character>());
                    }
                    
                    if (map.get(w1[j]).add(w2[j])) {
                        inDegree[w2[j] - 'a']++;
                    }
                    break;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 1)
                queue.offer(i);
        }
                
        while (!queue.isEmpty()) {
            int in = queue.poll();
            char cur = (char)('a' + in);
            output.append(cur);
            count--;
            
            if (map.containsKey(cur)) {
                for (char c : map.get(cur)) {
                    inDegree[c - 'a']--;
                    if (inDegree[c - 'a'] == 1) {
                        queue.offer(c - 'a');
                    }
                }
            }
            
        }
        
        if (count > 0)
            return "";
        
        return output.toString();
    }
}