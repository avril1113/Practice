class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2)
            return tree.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        
        for (int i = 0; i < tree.length; i++) {
            if (!map.containsKey(tree[i]) && map.size() == 2) {
                Iterator<Integer> it = map.values().iterator();
                start = Math.min(it.next(), it.next()) + 1;
                map.remove(tree[start-1]);
            }
            
            map.put(tree[i], i);
            max = Math.max(max, i - start + 1);
        }
        
        return max;
    }
}