class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > 9 && n > 45)
            return output;
        
        getCombination(k, 1, n, new ArrayList<Integer>());
        
        return output;
    }
    
    void getCombination(int k, int index, int total, List list) {
        for (int i = index; i < 10; i++) {
            if (i > total)
                break;
            
            List<Integer> combination = new ArrayList(list);
            combination.add(i);
            if (k == 1) {
                if (total == i)
                    output.add(combination);
            } else {
                getCombination(k-1, i+1, total-i, combination);
            }
        }
    }
}