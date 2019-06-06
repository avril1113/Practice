class Solution {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        
        if (n == 0)
            return false;
        
        Set<Integer> set = new HashSet<>();
        
        while (!set.contains(n)) {
            set.add(n);
            
            int temp = 0;
            while (n > 0) {
                temp = temp + (int)Math.pow(n%10, 2);
                n = n/10;
            }
            
            if (temp == 1)
                return true;
            
            n = temp;
        }
        
        return false;
    }
}