class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        ArrayList<int[]>[] distance = new ArrayList[2001];
        Set<Integer> took = new HashSet<>();
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = getDistance(workers[i], bikes[j]);
                if (distance[dist] == null)
                    distance[dist] = new ArrayList<>();
                
                distance[dist].add(new int[]{i, j});
            }
        }
        
        for (ArrayList<int[]> list : distance) {
            if (list == null)
                continue;
            
            for (int[] arr : list) {
                if (result[arr[0]] == -1 && !took.contains(arr[1])) {
                    result[arr[0]] = arr[1];
                    took.add(arr[1]);
                }
            }
        }
        
        return result;
    }
    
    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}