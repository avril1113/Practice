class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int wait = 0, id, time, processId = -1, startTime = 0;
        Stack<Integer> stack = new Stack();
        int[] result = new int[n];
        
        for (String log: logs) {
            String[] info = log.split(":");
            id = Integer.valueOf(info[0]);
            time = Integer.valueOf(info[2]);
            
            if (info[1].equals("start")) {
                if (!stack.isEmpty()) {
                    processId = stack.peek();
                    int exe = time - startTime + result[processId];
                    result[processId] = exe;
                }
                
                stack.push(id);
                startTime = time;
            } else {
                processId = stack.pop();
                if (id == processId) {
                    int exe = time - startTime + result[id] + 1;
                    result[id] = exe;
                }                
                
                if (!stack.isEmpty()) {
                    startTime = time + 1;
                }        
                
            }
        }
        
        return result;
    }

}