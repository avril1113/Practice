class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i)))
                continue;
            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                char[] chs = current.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        } 
        
        return new ArrayList<String>(queue);
    }
}