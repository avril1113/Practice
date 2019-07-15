/**
 *  Count the number of prime numbers less than a non-negative number, n.
 */

class Solution {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        
        char[] flag = new char[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (!flag[i])
                count++;
            
            if (i <= Math.sqrt(n)) {
                for (int j = i*i; j < n; j+=i)
                    flag[j] = true;
            }
        }
        
        return count;
    }
}