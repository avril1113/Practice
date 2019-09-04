class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T)
            return 0;
        
        HashMap<Integer, List<Integer>> stops = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> buses = stops.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                stops.put(routes[i][j], buses);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(S);
        
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                List<Integer> buses = stops.get(stop);
                
                for (int bus : buses) {
                    if (visited.contains(bus))
                        continue;
                    
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T)
                            return result;
                    
                        queue.offer(routes[bus][j]);
                    }
                }
            }
        }
        
        return -1;
    }
}