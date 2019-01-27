class MovingAverage {
    int size;
    double total = 0.0;
    List<Integer> queue;
    
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayList();
    }
    
    public double next(int val) {
        total = total + val;
        queue.add(val);
        if (queue.size() > size) {
            total = total - queue.get(0);
            queue.remove(0);
        }
        return total/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */