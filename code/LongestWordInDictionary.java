class Solution {
    public String longestWord(String[] words) {
        if (words.length == 0)
            return "";
        
        Arrays.sort(words);
        Set<String> dict = new HashSet<>();
        String result = "";
        
        for (String word : words) {
            if (word.length() == 1 || dict.contains(word.substring(0, word.length()-1))) {
                dict.add(word);
                
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))
                    result = word;
            }
        }
        
        return result;
    }
}