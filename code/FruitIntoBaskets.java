/**
 *  You have two baskets, and each basket can carry any quantity of fruit,
 *  but you want each basket to only carry one type of fruit each.
 *
 *  In a row of trees, the i-th tree produces fruit with type tree[i].
 * 
 *  You start at any tree of your choice, then repeatedly perform the following steps:
 *   1. Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 *   2. Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * 
 *  Note that you do not have any choice after the initial choice of starting tree:
 *  you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 */


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