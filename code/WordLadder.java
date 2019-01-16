class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 0;
        
        HashSet<String> words = new HashSet(wordList);
        
        if (!words.contains(endWord))
            return 0;
        
        int step = 0, size;
        String current;
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        
        while (!queue.isEmpty()) {
            size = queue.size();
            step++;
            
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                
                for (int j = 0; j < current.length(); j++) {
                    StringBuilder temp = new StringBuilder(current);
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp.setCharAt(j, c);
                    
                        if (words.contains(temp.toString())) {
                            if (temp.toString().equals(endWord))
                                return step+1;
                        
                            queue.offer(temp.toString());
                            words.remove(temp.toString());
                        }
                    }
                }    
            }
        }
        
        return 0;
    }
}