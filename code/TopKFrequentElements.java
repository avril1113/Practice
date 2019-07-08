class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k)
                heap.poll();
        }
        
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        
        return result;
    }
}