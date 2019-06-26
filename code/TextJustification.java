class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0, j, len;
        
        while (i < words.length) {
            j = i+1;
            len = words[i].length();
            
            while (j < words.length && len + words[j].length() < maxWidth) {
                len = len + words[j++].length() + 1;
            }
            
            StringBuilder sb = new StringBuilder();
            if (len == maxWidth || j == words.length) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
            } else if (j-i == 1) {
                sb.append(words[i]);
            } else {
                int space, extra;
                space = (maxWidth - len)/(j-i-1) + 1;
                extra = (maxWidth - len)%(j-i-1);
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k == j -1)
                        break;
                    
                    for (int l = 0; l < space; l++) {
                          sb.append(" ");  
                    }
                    
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                }
            }
            
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            
            i = j;
            
            list.add(sb.toString());
        }
        
        return list;
    }
}