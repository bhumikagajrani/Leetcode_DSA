class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[V];
        Helper(0,visited,adj,result);
        return result;
    }
    
    private void Helper(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
        
        visited[node]=1;
        result.add(node);
        
        for(int i:adj.get(node))
        {
            if(visited[i]==0)
            Helper(i, visited, adj, result);
        }
    }
}
