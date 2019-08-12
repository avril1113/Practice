class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length < 2)
            return intervals.length;
        
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        int room = 1;
        endTime.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int pre = endTime.peek();
            if (intervals[i][0] < pre) {
                room++;
            } else {
                endTime.poll();
            }
            
            endTime.offer(intervals[i][1]);
        }
        
        return room;
    }
}