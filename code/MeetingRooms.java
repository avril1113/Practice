/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {    
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0)
            return true;
        
        Arrays.sort(intervals, (Interval o1, Interval o2) -> o1.start - o2.start);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start)
                return false;
        }
        
        return true;
    }
}