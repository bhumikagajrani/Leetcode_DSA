class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];
        
        visited[0]=1;
        q.add(0);
        while(!q.isEmpty())
        {
            int top=q.poll();
            result.add(top);
            for(int i:adj.get(top))
            {
                if(visited[i]==0)
                {
                    q.add(i);
                    visited[i]=1;
                }
            }
            
        }
        return result;
        
    }
}
