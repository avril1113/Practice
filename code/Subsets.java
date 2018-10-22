class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        output.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0)
            return output;
        
        getSubset(nums, 0, new ArrayList<Integer>());
        return output;
    }
    
    void getSubset(int[] array, int index, List temp) {
        for (int i = index; i < array.length; i++) {
            List<Integer> set = new ArrayList(temp);
            set.add(array[i]);
            output.add(set);
            
            if (i < array.length-1) {
                getSubset(array, i+1, set);
            }
        }
    }
}