class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (words.length < 2)
            return result;
        
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String suffix = words[i].substring(j);
                
                if (isPalindrome(prefix)) {
                    String reverse = new StringBuilder(suffix).reverse().toString();
                    if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(wordMap.get(reverse));
                        ans.add(i);
                        result.add(ans);
                    }
                }
                
                if (suffix.length() != 0 && isPalindrome(suffix)) {
                    String reverse = new StringBuilder(prefix).reverse().toString();
                    if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(i);
                        ans.add(wordMap.get(reverse));
                        result.add(ans);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}