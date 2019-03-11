class Solution {
    private List<String> list = new ArrayList<>();
    
    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0);
        
        return list;
    }
    
    private void dfs(char[] array, int index) {
        if (index == array.length) {
            list.add(String.valueOf(array));
            return;
        }
        
        if (Character.isDigit(array[index])) {
            dfs(array, index+1);
            return;
        }
        
        array[index] = Character.toUpperCase(array[index]);
        dfs(array, index+1);
        
        array[index] = Character.toLowerCase(array[index]);
        dfs(array, index+1);
    }
}