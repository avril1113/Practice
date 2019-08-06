class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        char[] used = new char[bikes.length];
        HashMap<String, Integer> dist = new HashMap<>();
        
        return dfs(workers, bikes, 0, used, dist);
    }
    
    private int dfs(int[][] workers, int[][] bikes, int idx, char[] used, Map<String, Integer> visited) {
        if (idx == workers.length)
            return 0;
        
        if (visited.containsKey(idx + "-" + String.valueOf(used)))
            return visited.get(idx + "-" + String.valueOf(used));
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if (used[i] == '1')
                continue;
            
            used[i] = '1';
            int dist = getDistance(workers[idx], bikes[i]);
            min = Math.min(min, dfs(workers, bikes, idx+1, used, visited) + dist);
            used[i] = '0';
        }
        
        visited.put(idx + "-" + String.valueOf(used), min);
        return min;
    }
    
    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}