class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        output.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0)
            return output;
        
        Arrays.sort(nums);
        getSubset(nums, 0, new ArrayList<Integer>());
        return output;
    }
    
    void getSubset(int[] array, int index, List list) {
        for (int i = index; i < array.length; i++) {
            if (i > index && array[i] == array[i-1])
                continue;
            
            List<Integer> subset = new ArrayList(list);
            subset.add(array[i]);
            output.add(subset);
            
            getSubset(array, i+1, subset);
        }
    }
}