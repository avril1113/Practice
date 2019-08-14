class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length != speed.length)
            return -1;
        
        int result = 0;
        double curTime = 0.0;
        HashMap<Integer, Double> times = new HashMap<>();
        
        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - position[i]) / speed[i];
            times.put(position[i], time);
        }
        
        Arrays.sort(position);
        for (int i = position.length - 1; i >= 0 ; i--) {
            if (times.get(position[i]) > curTime) {
                curTime = times.get(position[i]);
                result++;
            }
        }
        
        return result;
    }
}