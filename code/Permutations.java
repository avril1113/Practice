class Solution {
    List<List<Integer>> output = new ArrayList(); 
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return output;
        
        Arrays.sort(nums);
        getPermutations(nums, 0, new ArrayList<Integer>());
        
        return output;
    }
    
    void getPermutations(int[] array, int index, List temp) {
        for (int i = 0; i <= index; i++) {
            List<Integer> permutation = new ArrayList(temp);
            
            if (i > 0 && permutation.get(i-1) == array[index])
                return;
            
            permutation.add(i, array[index]);
            if (permutation.size() == array.length) {
                output.add(permutation);
            } else {
                getPermutations(array, index+1, permutation);
            }
        }
    }
}