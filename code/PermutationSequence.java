class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1 && k == 1)
            return "1";
        
        int total = 1;
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            total = total * i;
            list.add(i);
        }
        
        if (k > total)
            return null;
        
        return helper(n, k-1, total, list, "");
    }
    
    String helper(int n, int k, int total, List list, String permutation) {
        int index = k/(total/n);
        int sequence = k%(total/n);
        permutation = permutation + list.get(index);
        list.remove(index);
        
        if (list.size() == 0)
            return permutation;
        else
            return helper(n-1, sequence, total/n, list, permutation);
    }
}