class Solution {
    public String nextClosestTime(String time) {
        TreeSet<Character> digits = new TreeSet<>();
        char[] timeArray = time.toCharArray();
        
        for (char c : timeArray) {
            if (Character.isDigit(c))
                digits.add(c);
        }
        
        char min = digits.first();
        
        for (int i = timeArray.length-1; i >= 0; i--) {
            if (i == 2)
                continue;
            
            char original = timeArray[i];
            Character higher = digits.higher(timeArray[i]);
            
            while (higher != null) {
                timeArray[i] = higher;
                if (isValid(timeArray))
                    return minTime(timeArray, i+1, min);
                
                higher = digits.higher(higher);
            }
            
            timeArray[i] = original;
        }
        
        return minTime(timeArray, 0, min);
    }
    
    private boolean isValid(char[] array) {
        int hour = (array[0] - '0') * 10 + (array[1] - '0');
        int min = (array[3] - '0') * 10 + (array[4] - '0');
        
        if (hour > 23 || hour < 0)
            return false;
        
        if (min > 59 || min < 0)
            return false;
        
        return true;
    }
    
    private String minTime(char[] array, int index, char min) {
        for (int i = index; i < array.length; i++) {
            if (i == 2)
                continue;
            
            array[i] = min;
        }
        
        return String.valueOf(array);
    }
}