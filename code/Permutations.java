class Solution {
    HashSet<List<Integer>> set = new HashSet(); 
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>(set);
        
        getPermutations(nums, 0, new ArrayList<Integer>());
        
        return new ArrayList<>(set);
    }
    
    void getPermutations(int[] array, int index, List temp) {
        for (int i = 0; i <= index; i++) {
            List<Integer> permutation = new ArrayList(temp);
            permutation.add(i, array[index]);
            
            if (permutation.size() == array.length) {
                if (!set.contains(permutation))
                    set.add(permutation);
            } else {
                getPermutations(array, index+1, permutation);
            }
        }
    }
}