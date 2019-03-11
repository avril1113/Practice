class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int mostFreqCount = 0;
        int sameFreq = 0;
        
        for (char c: tasks) {
            freq[c-'A']++;
            
            if (freq[c-'A'] > mostFreqCount) {
                mostFreqCount = freq[c-'A'];
            }
        }
        
        for (int count: freq) {
            if (count == mostFreqCount)
                sameFreq++;
        }
        
        int interval = (mostFreqCount - 1)*(n+1) + sameFreq;
        
        return Math.max(tasks.length, interval);
    }
}