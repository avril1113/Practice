class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || k > n)
            return output;
        
        getCombination(1, n, k, new ArrayList<Integer>());
        
        return output;
    }
    
    void getCombination(int index, int n, int length, List temp) {
        for (int i = index; i <= n; i++) {
            List<Integer> combination = new ArrayList(temp);
            combination.add(i);
            
            if (combination.size() == length) {
                output.add(combination);
            } else {
                getCombination(i+1, n, length, combination);
            }
        }
    }
}