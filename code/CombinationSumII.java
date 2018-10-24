class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return output;
        
        Arrays.sort(candidates);
        getCombination(candidates, 0, target, new ArrayList<Integer>());
        
        return output;
    }
    
    void getCombination(int[] array, int index, int target, List list) {
        for (int i = index; i < array.length; i++) {
            if (array[i] > target)
                break;
            
            if (i > index && array[i] == array[i-1])
                continue;
            
            List<Integer> combination = new ArrayList(list);
            combination.add(array[i]);
            
            if (target == array[i]) {
                output.add(combination);
            } else {
                getCombination(array, i+1, target-array[i], combination);
            }   
        }
    }
}