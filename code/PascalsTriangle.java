class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return output;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(output.get(i-1).get(j-1) + output.get(i-1).get(j));
                }
            }
            output.add(list);
        }
        
        return output;
    }
}