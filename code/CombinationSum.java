class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return output;
        
        Arrays.sort(candidates);
        if (candidates[0] > target)
            return output;
        
        getCombination(candidates, 0, target, new ArrayList<Integer>());
        
        return output;
    }
    
    void getCombination(int[] array, int index, int target, List temp) {
        for (int i = index; i < array.length; i++) {
            if (array[i] > target)
                return;
            
            List<Integer> combination = new ArrayList(temp);
            combination.add(array[i]);
            
            if (array[i] == target) {
                output.add(combination);
            } else {
                getCombination(array, i, target-array[i], combination);
            }
        }
    }
}