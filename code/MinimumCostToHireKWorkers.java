class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (quality.length != wage.length || K < 1 || K > wage.length)
            return 0.0;
        
        double[][] workers = new double[wage.length][2];
        for (int i = 0; i < wage.length; i++) {
            double ratio = (double) wage[i]/quality[i];
            workers[i][0] = ratio;
            workers[i][1] = quality[i];
        }
        
        double min = Double.MAX_VALUE, total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(workers, (w1, w2) -> Double.compare(w1[0], w2[0]));
        
        for (int i = 0; i < workers.length; i++) {
            total += workers[i][1];
            pq.offer(workers[i][1]);
            
            if (pq.size() < K)
                continue;
            
            if (pq.size() > K) {
                double qual = pq.poll();
                total -= qual;
            }
            
            double cur = total*workers[i][0];
            min = Math.min(min, cur);
        }
        
        return min;
    }
}