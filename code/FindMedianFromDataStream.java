class MedianFinder {
    PriorityQueue<Integer> big;
    PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        big = new PriorityQueue<>();
        small = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (big.isEmpty()) {
            big.offer(num);
        } else if (big.peek() > num) {
            small.offer(num);
        } else {
            big.offer(num);
        }
            
        if (big.size() > small.size()+1) {
            small.offer(big.poll());
        } else if (small.size() > big.size()) {
            big.offer(small.poll());
        }
    }
    
    public double findMedian() {
        if (big.size() != small.size())
            return big.peek();
        
        return 0.5*(big.peek() + small.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */