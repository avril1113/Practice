class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            
            HashMap<String, Double> divisor = graph.getOrDefault(equation.get(0), new HashMap<>());
            HashMap<String, Double> dividend = graph.getOrDefault(equation.get(1), new HashMap<>());
            divisor.put(equation.get(1), value);
            dividend.put(equation.get(0), 1/value);
            graph.put(equation.get(0), divisor);
            graph.put(equation.get(1), dividend);
        }
        
        double[] result = new double[queries.size()];
        
        for (int j = 0; j < queries.size(); j++) {
            if (!graph.containsKey(queries.get(j).get(0)) || !graph.containsKey(queries.get(j).get(1))) {
                result[j] = -1.0;
            } else {
                result[j] = dfs(graph, queries.get(j).get(0), queries.get(j).get(1), new HashSet<String>());
            }
        }
        
        return result;
    }
    
    private double dfs(HashMap<String, HashMap<String, Double>> graph, String current, String target, Set<String> visited) {        
        if (current.equals(target))
            return 1.0;
        
        if (graph.get(current).containsKey(target))
            return graph.get(current).get(target);
        
        visited.add(current);
        double ans = -1.0;
        for (String connect: graph.get(current).keySet()) {
            if (!visited.contains(connect)) {
                ans = dfs(graph, connect, target, visited);
                if (ans != -1.0)
                    return ans*graph.get(current).get(connect);
            }
        }
        
        return ans;
    }
}